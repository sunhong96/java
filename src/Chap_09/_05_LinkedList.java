package Chap_09;

import java.util.LinkedList;

public class _05_LinkedList {
    public static void main(String[] args) {
        //링크드 리스트
        LinkedList<String> list = new LinkedList<>();

        //데이터추가
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        //조회
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());//list.size()-1 필요없이 마지막값을 불러옴

        System.out.println("------------------------------");

        //추가
        list.addFirst("서장훈");//맨앞으로 추가됨
        for (String s : list)
            System.out.println(s);

        System.out.println("------------------------------");


        list.addLast("김희철");//맨뒤로 추가됨
        for (String s : list)
            System.out.println(s);

        System.out.println("------------------------------");

        list.add(1,"김영철");
        System.out.println(list.get(1));//자리차지를 하면서 밀림

        System.out.println("------------------------------");
        for (String s : list)
            System.out.println(s);


        System.out.println("------------------------------");
        //삭제
//        list.remove("김영철");
        System.out.println("남은 학생 수 (제외 전) : " + list.size());
        list.remove(list.size() - 1);
        System.out.println("남은 학생 수 (제외 후) : " + list.size());

        System.out.println("------------------------------");

        list.removeFirst();//처음 데이터
        list.removeLast();//마지막 데이터
        for (String s : list)
            System.out.println(s);

        System.out.println("------------------------------");
        //변경
        list.set(0,"이수근");
        System.out.println(list.get(0));

        System.out.println("------------------------------");

        //확인
        System.out.println(list.indexOf("김종국"));
        if (list.contains("김종국"))
            System.out.println("수강신청 성공");
        else
            System.out.println("수강신청 실패");

        System.out.println("------------------------------");

        list.clear();
        if(list.isEmpty())
            System.out.println("리스트가 비었습니다");
    }
}
