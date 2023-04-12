package java8;

public class DefaultFoo2 implements Foo2{
    String name;

    public DefaultFoo2(String name){
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("DefaultFoo");
    }

    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        Foo2 foo2 = new DefaultFoo2("keesun");
        foo2.printName();
        foo2.printNameUpperCase();

        Foo2.printAnything(); // static 매서드는 직접호출해야함

    }
}
