

import java.util.Arrays;

import lambda.SampleFunctionalI;
import leetcode.AddTwoNumber;
import leetcode.Solution;

public class App {
    public static void main(String[] args) throws Exception {
        //lambdaOperations();
        //streamAPIOperation();
        testLeetCode();
    }

    static void streamAPIOperation() {
        String arr[] = {"Sunil","Bivas","Dona","Ganguly","Sahil"};
        Arrays.asList(arr).stream().
        filter(x-> x.startsWith("S")).
        sorted().
        forEach(System.out::print);
    }

    static void lambdaOperations() {
        System.out.println("Hello, World!");
        SampleFunctionalI.staticMethod();
        SampleFunctionalI functionalI = (a, b) -> {
            System.out.println(a + b);
        };
        functionalI.sampleAbstractmethod("String A", "String B");
        functionalI.sampleAbstractmethod("String A", "String B");
    }

    static void testLeetCode() {
        //AddTwoNumber obj = new AddTwoNumber();
        //obj.prepareTwoNumbers();

        Solution obj = new Solution();
        int arr[] = new int[]{2,7,11,15};
        obj.twoSum(arr, 9);
    }
}
