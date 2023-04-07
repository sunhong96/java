package java8;

@FunctionalInterface
public interface RunSomething {
    void doIt();
    static void printName(){
        System.out.println("Keesun");
    }
    default void printAge(){
        System.out.println("40");
    }
}
// 추상 매서드가 하나만 있으면 함수형 인터페이스
