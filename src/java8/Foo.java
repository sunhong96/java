package java8;

import java.util.function.*;

public class Foo {
    //익명 내부 클래스
    RunSomething runSomething = new RunSomething() {
        @Override
        public void doIt() {
            System.out.println("Hello");
        }
    };//람다로 바꾸기 가능
//    RunSomething runSomething = () -> System.out.println("Hello");//바꾼식

//    RunSomething runSomething = new RunSomething() {
//        @Override
//        public void doIt() {
//            System.out.println("Hello");
//            System.out.println("Lambda");
//        }
//    };//람다로 바꾸기 가능

//  RunSomething runSomething = () -> {
//      System.out.println("Hello");
//    System.out.println("Lambda");
//  };
// 바꾼식
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));
        //Function<Integer, Integer> plus10 = (i) -> i +10; 이렇게 바꿔줄수있음 plus10 인터페이스에 있는걸
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
//        UnaryOperator<Integer> plus11 = (i) -> i + 11; 입력값과 결과값의 타입이 같을때 사용살수있음
//        BinaryOperator 3개도 가능
        System.out.println(multiply2.apply(2));

        plus10.compose(multiply2); //compose는 입력값을 가지고 뒤에있는 함수를 적용하고 결과값을 다시 앞에 plus10의 변수에사용
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));

        plus10.andThen(multiply2); //andThen는 앞에 함수의 결과값에다가 뒤의 함수에 넣어줌
        System.out.println(plus10.andThen(multiply2).apply(2));

        Consumer<Integer> printT = (i) -> System.out.println(i); //Consumer 입력값을 받기만하고 반환값이 없는 매서드
        printT.accept(10); //값을 받는 역할만함

        Supplier<Integer> get10 = () -> 10; // 받아올 값의 타입과 인자를 정의함

        Predicate<String> startWithKeesun = (s) -> s.startsWith("keesun"); //true false를 반환하는 매서드
        Predicate<Integer> isEven = (i) -> i % 2 == 0;


    }
}
