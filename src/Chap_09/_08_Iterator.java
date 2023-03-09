package Chap_09;

import java.util.*;

public class _08_Iterator {
    public static void main(String[] args) {
        // 이터레이터
        List<String> list = new ArrayList<>();//List로 만들어도 인터페이스로 리스트에서 받아서 쓸수있음

        list.add("유재석");
        list.add("(알 수 없음)");
        list.add("김종국");
        list.add("(알 수 없음)");
        list.add("강호동");
        list.add("(알 수 없음)");
        list.add("박명수");
        list.add("(알 수 없음)");
        list.add("조세호");

        for (String s : list)
            System.out.println(s);
        System.out.println("--------------------");

        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.next());//커서를 다음위치로 이동한다고생각하면댐
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


        //전체 조회
        System.out.println("--------------------");
        iterator = list.iterator();//커서를 처음위치로 이동
        while (iterator.hasNext())//가져올데이터가있으면 true로 반복되고 없으면 false로 반환
        {
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");

        //불필요한 글자를 삭제시켜줌
        iterator = list.iterator();//커서를 처음위치로 이동
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.contains("(알 수 없음)")){
                iterator.remove();
            }
        }

        iterator = list.iterator();//커서를 처음위치로 이동
        while (iterator.hasNext())//가져올데이터가있으면 true로 반복되고 없으면 false로 반환
        {
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");

        HashSet<String> set = new HashSet<>();
        set.add("유재석");
        set.add("박명수");
        Iterator<String> itset = set.iterator();
        while (itset.hasNext()){
            System.out.println(itset.next());
        }
        System.out.println("--------------------");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("유재석", 10);
        map.put("박명수", 5);

//        map.iterator() 바로 적용이안됨
        Iterator<String> itMapKey = map.keySet().iterator();//map.keySet().iterator(); key가 들어오게됨
        while (itMapKey.hasNext()){
            System.out.println(itMapKey.next());
        }
        System.out.println("--------------------");

        Iterator<Integer> itMapValue = map.values().iterator();//map.values().iterator(); value가 들어오게됨
        while (itMapValue.hasNext()){
            System.out.println(itMapValue.next());
        }
        System.out.println("--------------------");

        map.entrySet().iterator();//key와 value가 쌍으로 들어오게됨 ctrl+alt+v
        Iterator<Map.Entry<String, Integer>> itMap = map.entrySet().iterator();
        while (itMap.hasNext()){
            System.out.println(itMap.next());
        }

    }
}
