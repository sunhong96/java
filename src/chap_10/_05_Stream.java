package chap_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _05_Stream {
    public static void main(String[] args) {
        //스트림
        // stream은 생성하고 쓰이면 없어지기때문에 매번 다시만들어줘야댐
        int[] scores = {100, 95, 90, 85, 80};
        IntStream scoreStream = Arrays.stream(scores); //만들걸 바로 객체로 만들고싶으면 ctrl+alt+v

        String[] langs = {"python", "java", "javascript", "c", "c++", "c#"};
        Stream<String> langstream = Arrays.stream(langs);

        List<String> langlist = new ArrayList<>();
        langlist = Arrays.asList("python", "java", "javascript", "c", "c++", "c#");
        // langlist.add(xxxxx)한개한개씩 넣어주는효과랑 똑같음

        Stream<String> langListStream = langlist.stream();

        // Stream.of();
        Stream<String> langListOfStream = Stream.of("python", "java", "javascript", "c", "c++", "c#");

        // 스트림 사용
        // 중간 연산 (Intermediate Operation) : filter, map, sorted, distinct, skip, ....
        // 최종 연산 (Terminal Operation) : count, min, max, sum, forEach, anyMatch, allMatch, ...


        // 90점 이상인 점수만 출력
        Arrays.stream(scores).filter(x -> x >= 90).forEach(x -> System.out.println(x));
//        Arrays.stream(scores).filter(x -> x >= 90).forEach(System.out::println); 위의 문장과 똑같은 동작을함
        System.out.println("------------------------");

        // 90점 이상인 사람의 수
        int count = (int) Arrays.stream(scores).filter(x -> x >=90).count();
        System.out.println(count);
        System.out.println("------------------------");

        // 90점 이상인 사람의 점수들의 합
        int sum = Arrays.stream(scores).filter(x -> x >= 90).sum();
        System.out.println(sum);
        System.out.println("------------------------");

        // 90점 이상인 점수들을 정렬
        Arrays.stream(scores).filter(x -> x >= 90).sorted().forEach(System.out::println);
        System.out.println("------------------------");

        // "pytion", "java", "javascript", "c", "c++", "c#"
        // 이중에서 c 라는 글자로 시작하는 프로그래밍 언어
        Arrays.stream(langs).filter(x -> x.startsWith("c")).forEach(System.out::println);
        System.out.println("------------------------");

        // java 라는 글자를 포함하는 언어
        Arrays.stream(langs).filter(x -> x.contains("java")).forEach(System.out::println);
        System.out.println("------------------------");

        // 4글자 이하의 언어를 정렬해서 출력
        langlist.stream().filter(x -> x.length() <= 4).sorted().forEach(System.out::println);
        System.out.println("------------------------");

        // 4글자 이하의 언어중에서 c라는 글자를 포함하는 언어
        langlist.stream().filter(x -> x.length() <=4).filter(x -> x.contains("c")).forEach(System.out::println);
        System.out.println("------------------------");

        // 4글자 이하의 언어중에서 c라는 글자가 하나라도 있는지 여부
        boolean anyMatch = langlist.stream().filter(x -> x.length() <=4).anyMatch(x -> x.contains("c"));
        //anyMatch는 boolean타입
        System.out.println(anyMatch);
        System.out.println("------------------------");

        // 4글자 이하의 언어들은 모두 c라는 글자를 포함하는지 여부
        boolean allMatch = langlist.stream().filter(x -> x.length() <=4).allMatch(x -> x.contains("c"));
        System.out.println(allMatch);
        System.out.println("------------------------");

        // 4글자 이하의 언어 중에서 c 라는 글자를 포함하는 언어 뒤에 (어려워요) 라는 글자를 함께 출력
        // map
        // map을 이용하면 원하는 형태로 데이터 가공가능
        langlist.stream().filter(x -> x.length() <=4).filter(x -> x.contains("c"))
                .map(x -> x + " (어려워요)").forEach(System.out::println);
        System.out.println("------------------------");

        //c라는 글자를 포함하는 언어를 대문자로 출력
        langlist.stream().filter(x -> x.contains("c")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("------------------------");

        // c 라는 글자를 포함하는 언어를 대문자로 변경하여 리스트로 저장
        List<String> langListStartsWithC = langlist.stream().filter(x -> x.contains("c"))
                .map(String::toUpperCase).collect(Collectors.toList());
        langListStartsWithC.stream().forEach(System.out::println);
    }
}
