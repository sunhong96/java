package Chap_09;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class _06_HashSet {
    public static void main(String[] args) {
        //세트 (중복을 허용하지않음)
        HashSet<String> set = new HashSet<>();

        //데이터 추가
        set.add("삼겹살");
        set.add("쌈장");
        set.add("음료");
        set.add("소금");
        set.add("후추");
        set.add("삼겹살");
        set.add("깻잎");
        set.add("상추");
        set.add("삼겹살");

        System.out.println("총 구매 상품 수 : " + set.size());

        //순회
        for (String s : set)
            System.out.println(s); //순서도 보정이 안되고 중복도 다 제거됨
        System.out.println("-----------------------");

        // 확인
        if (set.contains("삼겹살"))
            System.out.println("삼겹살 포함됨");
        System.out.println("-----------------------");

        //삭제
        System.out.println("총 구매 상품수 (삼겹살 삭제 전) : " + set.size());
        set.remove("삼겹살");
        System.out.println("총 구매 상품수 (삼겹살 삭제 후) : " + set.size());
        System.out.println("-----------------------");

        //전체 삭제
        set.clear();
        if(set.isEmpty())
            System.out.println("모두 삭제되었습니다");
        System.out.println("-----------------------");

        // 세트 : 중복허용 x , 순서보장 x
        HashSet<Integer> intset = new LinkedHashSet<>();// LinkedHashSet은 순서를 보장해줌
        intset.add(1);
        intset.add(13);
        intset.add(2);

        for (int i : intset)
            System.out.println(i);

    }
}
