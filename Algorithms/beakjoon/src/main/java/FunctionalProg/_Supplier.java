package FunctionalProg;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
//        getdatabaseURL.get();
        System.out.println(getdatabaseURL.get());

    }

    static Supplier<String> getdatabaseURL=()->"fasgh.govt.kr";
}
