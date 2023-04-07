package java8;

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
}
