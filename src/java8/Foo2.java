package java8;

public interface Foo2 {
    void printName();

    //    @implSpec 이 태그를 붙여줘서 무슨 동작을 하는지 설명을 붙여줘야함
    // 내가 만든 인터페이스
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}
