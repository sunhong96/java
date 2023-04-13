package java8;

import java.util.*;

public class interfaceMethod {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        name.forEach(System.out::println);
        System.out.println("======================");

        //spliterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance((System.out::println)));
        System.out.println("======================");
        while (spliterator1.tryAdvance((System.out::println)));

        System.out.println("======================");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        Spliterator<String> spliterator3 = names.spliterator();
        while (spliterator3.tryAdvance(s -> System.out.println(s.length())));
        //Spliterator를 사용하여 병렬 처리를 하려면 trySplit() 메소드를 호출하여 스플리터레이터를 분할하고,
        // 각각의 스플리터레이터에서 tryAdvance() 메소드를 호출하여 병렬 처리할 수 있습니다.



        //stream
        long k = name.stream().map(String::toUpperCase).filter(s -> s.startsWith("K")).count();
        //Java 8에서 추가된 스트림(Stream)은 데이터 처리를 위한 연속된 요소들의 모임을 의미합니다.
        // 스트림을 이용하면 컬렉션의 요소를 람다 표현식을 이용하여 선언적으로 처리할 수 있으며, 병렬 처리를 통해 처리 속도를 높일 수 있습니다.
        //
        //스트림은 다양한 메소드를 제공하며, 이를 이용하여 데이터를 처리할 수 있습니다. map() 메소드는 스트림의 요소들을 다른 형태로 변환하는 메소드입니다.
        // 예를 들어, 문자열 스트림에서 각 문자열을 대문자로 변환하고 싶다면, map(String::toUpperCase) 메소드를 사용할 수 있습니다.
        //
        //map() 메소드는 함수형 인터페이스인 Function<T, R>을 매개변수로 받습니다.
        // Function<T, R>은 입력 타입이 T이고 출력 타입이 R인 메소드를 단일 추상 메소드로 가지고 있습니다.
        // map() 메소드는 각 요소에 대해 Function<T, R>을 적용하여 새로운 스트림을 생성합니다.
        System.out.println(k);

        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);

        System.out.println("======================");

        //Comparator
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        //거꾸로바꾸기

        System.out.println("======================");
        name.sort(Comparator.comparing(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        name.forEach(System.out::println);
        //위의 코드에서, comparing() 메소드를 사용하여 문자열의 길이를 비교하는 Comparator를 생성하고,
        // thenComparing() 메소드를 사용하여 대소문자를 무시하고 알파벳 순서로 비교하는 Comparator를 지정합니다.
        // String.CASE_INSENSITIVE_ORDER는 대소문자를 무시하고 문자열을 비교하는 Comparator입니다.



    }
}
