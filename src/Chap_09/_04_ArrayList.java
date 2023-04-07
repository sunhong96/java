package chap_09;

import java.util.ArrayList;
import java.util.Collections;

public class _04_ArrayList {
    public static void main(String[] args) {
        // 컬렉션 프레임워크 (List, Set, Map)

//        String[] fruitsArray = {"apple", "banana", "kiwi", "mango"};
//        ArrayList<String>  fruits = new ArrayList<>(Arrays.asList(fruitsArray));
//
//        System.out.println("Has apple? : " + fruits.contains("apple"));
//        if (fruits.contains("mango")) {
//            System.out.println("There is mango in the list");
//        }
//        if (!fruits.contains("strawberry")) {
//            System.out.println("There is no strawberry in the list");
//        }  이런식으로 배열에 담아서 써줄수도있음

        ArrayList<String> list = new ArrayList<>();

        //추가
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        //조회
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println("----------------------");

        //삭제
        System.out.println("신청 학생수 (제거 전)" + list.size());
        list.remove("박명수");//들어가있는 값을 제거
        System.out.println("신청 학생수 (제거 후)" + list.size());
        System.out.println(list.get(3));//데이터가 빈곳으로 당겨짐

        System.out.println("----------------------");

        System.out.println("남은 학생 수 (제거 전)" + list.size());
        list.remove(list.size() - 1);//인덱스값을 제거 (사이즈값=4 마지막껄지울려면 1을 빼줘야댐)
        System.out.println("남은 학생 수 (제거 후)" + list.size());

        System.out.println("----------------------");

        for (String s: list) {
            System.out.println(s);
        }

        System.out.println("----------------------");

        //변경
        System.out.println("변경 전: " +list.get(0));
        list.set(0,"이수근");
        System.out.println("변경 후: " +list.get(0));

        //확인
        System.out.println(list);
        System.out.println(list.indexOf("김종국"));//찾으려는 데이터가 몇번째있는지

        if(list.contains("김종국"))//boolean타입의 contain문 포함되면 ture
            System.out.println("포함됨");
        else
            System.out.println("포함되지 않음");

        System.out.println("-----------------------");

        //전체삭제
        list.clear();
        if(list.isEmpty())//boolean타입의 isEmpty문 비어있는지 확인
            System.out.println("비어 있습니다");

        //새로운데이터
        list.add("유재석");
        list.add("조세호");
        list.add("김종국");
        list.add("박명수");
        list.add("강호동");

        Collections.sort(list);//Collections패키치의 sort 정렬문
        for (String s:
             list) {
            System.out.println(s);
        }
    }
}
