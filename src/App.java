
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {

    public static void main(String[] args) throws Exception {
        String fundsAndPayments = "GBP:100,EUR:200,CZK:1000|" +
                "743:EUR:5.76,932:GBP:32.10,909:CZK:2223.26,23:CZK:8890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01";
        String fundsAvailable = fundsAndPayments.substring(0,fundsAndPayments.indexOf('|'));
        String merchantPaymentNeedsMap = fundsAndPayments.substring(fundsAndPayments.indexOf('|') +1);
        // Funds available for each currency
        Map<String,BigDecimal> accountFundsMap = distributeAvailableFundsInAccount(fundsAvailable);
        // Payments needed for merchants
        Map<String, Map> currencyPaymentMaps = merchantPaymentNeedsMap(merchantPaymentNeedsMap);
        Map<String, BigDecimal> gbpPaymentMap = currencyPaymentMaps.get("GBP");
        Map<String, BigDecimal> eurPaymentMap = currencyPaymentMaps.get("EUR");
        Map<String, BigDecimal> czkPaymentMap = currencyPaymentMaps.get("CZK");
        StringBuilder result = new StringBuilder("");
        //CZK Batch Add
        czkPaymentMap = czkPaymentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        BigDecimal czkBalance = accountFundsMap.get("CZK");
        boolean czkBatchAdded = false;
        for(Map.Entry<String,BigDecimal> val: czkPaymentMap.entrySet()) {
            if(czkBalance.doubleValue() > val.getValue().doubleValue()) {
                if(!czkBatchAdded)
                    result.append("CZK");
                czkBatchAdded = true;
                result.append(System.getProperty("line.separator"));
                result.append(val.getKey()).append(":").append("CZK:").append(val.getValue());
                czkBalance = new BigDecimal(czkBalance.doubleValue()-val.getValue().doubleValue());
                System.out.println("Remaining Balance : " + czkBalance);
            }
        }
        //EUR Batch Add
        eurPaymentMap = eurPaymentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        BigDecimal eurBalance = accountFundsMap.get("EUR");
        boolean eurBatchAdded = false;
        for(Map.Entry<String,BigDecimal> val: eurPaymentMap.entrySet()) {
            if(eurBalance.doubleValue() > val.getValue().doubleValue()) {
                if(!eurBatchAdded) {
                    if(result.length()>0)
                        result.append(System.getProperty("line.separator"));
                    result.append("EUR");
                }
                eurBatchAdded = true;
                result.append(System.getProperty("line.separator"));
                result.append(val.getKey()).append(":").append("EUR:").append(val.getValue());
                eurBalance = new BigDecimal(eurBalance.doubleValue()-val.getValue().doubleValue());
            }
        }

        //GBP Batch Add
        gbpPaymentMap = gbpPaymentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        BigDecimal gbpBalance = accountFundsMap.get("GBP");
        boolean gbpBatchAdded = false;
        for(Map.Entry<String,BigDecimal> val: gbpPaymentMap.entrySet()) {
            if(gbpBalance.doubleValue() > val.getValue().doubleValue()) {
                if(!gbpBatchAdded) {
                    if(result.length()>0)
                        result.append(System.getProperty("line.separator"));
                    result.append("GBP");
                }
                gbpBatchAdded = true;
                result.append(System.getProperty("line.separator"));
                result.append(val.getKey()).append(":").append("GBP:").append(val.getValue());
                eurBalance = new BigDecimal(gbpBalance.doubleValue()-val.getValue().doubleValue());
            }
        }
        System.out.println(result);
    }
    public static Map distributeAvailableFundsInAccount(String fundsAvailable) {
        Map<String,BigDecimal> accountFundsMap = new HashMap<>();
        List<String> accountFundsList = Collections.list(new StringTokenizer(fundsAvailable, ",")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        for(String fund: accountFundsList){
            // As the currency code is fixed to 3 character, Hence hardcoding the indices
            accountFundsMap.put(fund.substring(0,3),BigDecimal.valueOf(Double.valueOf(fund.substring(4))));
        }
        return accountFundsMap;
    }

    public static Map merchantPaymentNeedsMap (String merchantPaymentNeedsMap) {
        Map<String, BigDecimal> gbpPaymentMap = new HashMap<>();
        Map<String, BigDecimal> eurPaymentMap = new HashMap<>();
        Map<String, BigDecimal> czkPaymentMap = new HashMap<>();
        Map<String, Map> currencyPaymentMaps = new HashMap<>();
        List<String> merchantPaymentList = Collections.list(new StringTokenizer(merchantPaymentNeedsMap, ",")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        for(String paymentEntry: merchantPaymentList) {
            String merchantId = paymentEntry.substring(0,paymentEntry.indexOf(':'));
            String currencyCode = paymentEntry.substring(paymentEntry.indexOf(':')+1,paymentEntry.indexOf(':') +4);
            BigDecimal amountTobePayed = deriveAccountPayable(paymentEntry.substring(paymentEntry.indexOf(':') +5),currencyCode);
            switch (currencyCode) {
                case "EUR": eurPaymentMap.put(merchantId,amountTobePayed);break;
                case "GBP": gbpPaymentMap.put(merchantId,amountTobePayed);break;
                case "CZK": czkPaymentMap.put(merchantId,amountTobePayed);break;
                default: break;
            }
        }
        currencyPaymentMaps.put("GBP",gbpPaymentMap);
        currencyPaymentMaps.put("EUR",eurPaymentMap);
        currencyPaymentMaps.put("CZK",czkPaymentMap);
        return currencyPaymentMaps;
    }

    public static BigDecimal deriveAccountPayable(String payment,String currencyCode) {
        double valueInDouble = Double.valueOf(payment);
        BigDecimal valueInBigD = BigDecimal.valueOf(valueInDouble);
        BigDecimal processingFeeDeductedValue ;
        if("GBP".equals(currencyCode)) {
            processingFeeDeductedValue = roundUpPaymentGbp(valueInBigD);
        } else
            processingFeeDeductedValue = roundUpPaymentOtherCurrency(valueInBigD);
        BigDecimal rounderUpValue = roundUpPayment(processingFeeDeductedValue);


        return rounderUpValue;
    }
    public static BigDecimal roundUpPayment(BigDecimal payment) {
        return payment.setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal roundUpPaymentGbp(BigDecimal payment) {
        Double derivedAmount = payment.doubleValue() - ((payment.doubleValue()*0.01)/3);
        return BigDecimal.valueOf(derivedAmount).setScale(2,RoundingMode.CEILING);
    }
    public static BigDecimal roundUpPaymentOtherCurrency(BigDecimal payment) {
        Double derivedAmount = payment.doubleValue() - ((payment.doubleValue()*0.01)/2);
        return BigDecimal.valueOf(derivedAmount).setScale(2,RoundingMode.CEILING);
    }

}
