package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class methodreference {
    public static void main(String[] args) {
//        UnaryOperator<String> hi = (s) -> "hi" + s;
        UnaryOperator<String> hi = Greeting::hi; // 스태틱 매서드 호출 방법

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello; // 인스턴스 매서드 호출 방법
        System.out.println(hello.apply("keesun"));

        Supplier<Greeting> newGreeting = Greeting::new; //아무일도 일어나지않음
        newGreeting.get();

        Function<String, Greeting> keesunGreeting = Greeting::new;
        Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());

        String[] names = {"keesun","whiteship","toby"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });  밑의 식으로 변경가능
//        Arrays.sort(names, (o1, o2) -> 0);
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
