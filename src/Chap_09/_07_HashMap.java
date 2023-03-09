package Chap_09;

import java.util.HashMap;

public class _07_HashMap {
    public static void main(String[] args) {
        // 맵 (key, Value) key 값을 통해 value 값을 가져오는 것
        HashMap<String, Integer> map = new HashMap<>();// LinkedHashMap 은 순서를 보장해줌

        //데이터 추가
        map.put("유재석", 10);
        map.put("박명수", 5);
        map.put("김종국", 3);
        map.put("서장훈", 15);

        System.out.println("총 고객수 : " + map.size());
        System.out.println("-------------------------");

        //조회
        System.out.println("유재석님의 포인트 : " + map.get("유재석"));
        System.out.println("유재석님의 포인트 : " + map.get("박명수"));
        System.out.println("-------------------------");

        //확인
        if (map.containsKey("서장훈")){
            int point = map.get("서장훈");
            map.put("서장훈", ++point);
            System.out.println("서장훈님의 누적 포인트 : " + map.get("서장훈"));
        }else {
            map.put("서장훈", 1);
            System.out.println("서장훈님 신규 등록 (포인트1)");
        }
        System.out.println("-------------------------");

        //삭제
        map.remove("유재석");
        System.out.println(map.get("유재석"));
        System.out.println("-------------------------");

        //전체 삭제
        map.clear();
        if (map.isEmpty())
            System.out.println("다 지워졌습니다");
        System.out.println("-------------------------");

        //다시추가
        map.put("유재석", 10);
        map.put("박명수", 5);
        map.put("김종국", 3);
        map.put("서장훈", 15);

        //Key 확인
        for (String key : map.keySet()){
            System.out.println(key);
        }//키값만을 haspmap 출력 순서가 보장이안됨 중복도 안됨
        System.out.println("-------------------------");

        //Value 확인
        for (int value : map.values())
            System.out.println(value);
        System.out.println("-------------------------");

        //Key, Value 한번에확인
        for (String key : map.keySet()){
            System.out.println("고객이름 : " + key + "\t포인트 : " + map.get(key));
        }
        System.out.println("-------------------------");

        //맵 : 중복 x , 순서 x
        map.put("김종국", 10);
        map.put("김종국", 30);
        map.put("김종국", 50);//최종 값만 들어감

        for (String key : map.keySet()){
            System.out.println("고객이름 : " + key + "\t포인트 : " + map.get(key));
        }
        System.out.println("-------------------------");
    }
}
