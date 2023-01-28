package lambda;

@FunctionalInterface
public interface SampleFunctionalI {

    static void staticMethod() {
        System.out.println("This is a static method in Function Interfacee");
    }

    void sampleAbstractmethod(String var1, String var2);
}