package chap_09;


import chap_09.User.User;
import chap_09.User.vipUser;
import chap_09.coffee.*;

public class _02_GenericsClass {
    public static void main(String[] args) {
        //제너릭 클래스
        CoffeeByNumber c1 = new CoffeeByNumber(33);
        c1.ready();

        CoffeeByNickname c2 = new CoffeeByNickname("유재석");
        c2.ready();
        //매번 클래스를 만들어줘야하는 불편함이있다 타입이 다르면 그래서 제너릭 클래스사용

        System.out.println("----------------------------");

        CoffeeByName c3 = new CoffeeByName(34);
        c3.ready();
        CoffeeByName c4 = new CoffeeByName("박명수");
        c4.ready();

        System.out.println("----------------------------");
        int c3Name = (int) c3.name; //바로는 Object 타입이라 안들어감 int로 형변환을 시켜줘야 들어감
        System.out.println("주문 고객 번호 : "+ c3Name);

        String c4Name = (String) c4.name;
        System.out.println("주문 고객 번호 : " + c4Name);

//        c4Name = (String) c4.name;
//        정수를 실수로 변환불가

        System.out.println("----------------------------");

        Coffee<Integer> c5 = new Coffee<>(35);
        c5.ready();
        int c5Name = c5.name;
        System.out.println("주문 고객 번호 : " + c5Name);

        Coffee<String> c6 = new Coffee<>("조세호");
        c6.ready();
        String c6Name = c6.name;
        System.out.println("주문 고객 이름 : " + c6Name);

        System.out.println("---------------------------");
        CoffeeByUser<User> c7 = new CoffeeByUser<>(new User("강호동"));
        c7.ready();//User 만을 상속하는 객체를만들때

        CoffeeByUser<User> c8 = new CoffeeByUser<>(new vipUser("서장훈"));
        c8.ready();

        System.out.println("---------------------------");
        orderCoffee("김영철");
        orderCoffee(36);

        orderCoffee("김희철", "아메리카노");
        orderCoffee(37, "라떼");
    }

    public static <T> void orderCoffee(T name){
        System.out.println("커피 준비 완료 : " + name);
    }

    public static <T, V> void orderCoffee(T name, V coffee){
        System.out.println(coffee + "커피 준비 완료 : " + name);
    }
}