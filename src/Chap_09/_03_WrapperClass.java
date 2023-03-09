package Chap_09;

public class _03_WrapperClass {
    public static void main(String[] args) {
        // 래퍼(Wrapper) 클래스
        // int double float char 기본자료형을 객체로 만들어서 사용할 수 있게함

        Integer i = 123;
        Double d = 1.0;
        Character c = 'A';

        System.out.println(i);
        System.out.println(d);
        System.out.println(c);

        System.out.println("-------------------------");

        System.out.println(i.intValue());
        System.out.println(d.intValue());//실수를 인트형 타입으로 변환해서 출력
        System.out.println(c.charValue());

        System.out.println("-------------------------");

        String s = i.toString();//문자열형태로 변환
        System.out.println(s);
    }
}
