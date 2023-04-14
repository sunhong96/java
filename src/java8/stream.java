package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        //새로만들어주는거지 데이터 자체를 대문자로 바꾸는게 아님
        //한번만쓰이고 사라짐
        System.out.println("-----------------------");

        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });
        //종료형 opreater가 있어야 실행을함

        List<String> collect = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //이와같이 종료형 opreater가 있어야 실행이됨

        System.out.println("-----------------------");

        for(String name : names) {
            if (name.startsWith("k")) {
                System.out.println(name.toUpperCase());
            }
        }
        //병렬적 처리가 어려움

        names.stream() // 문자열 컬렉션(Collection)에 대해 스트림(Stream)을 생성
                .filter(name -> name.startsWith("k")) // "k"로 시작하는 요소만 필터링
                .map(String::toUpperCase) // 각 요소를 대문자로 변환
                .forEach(System.out::println); // 변환된 요소를 출력
        //이렇게 가능

        System.out.println("-----------------------");

        List<String> collect1 = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("-----------------------");

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring data jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest api development",false));



        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .forEach(s -> System.out.println(s.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
//              .filter(s -> !s.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                //java 11에 추가된것 predicate 는 전달된 객체에 논리적 판단 수행후 true false 값을 반환함
                .forEach(s -> System.out.println(s.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"The java, Test",true));
        javaClasses.add(new OnlineClass(7,"The java, Code manipulation",true));
        javaClasses.add(new OnlineClass(8,"The java, 8 to 11",false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);


        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(list -> list.stream()) //flatMap은 뭉쳐져서 있는 list를 나열해줌
                .forEach(s -> System.out.println(s.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10,i -> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(s -> s.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(s -> s.getTitle().contains("spring"))
                .map(OnlineClass::getTitle) //순서에 따라 다음 연산자에 뭐가 들어갈지 다름 순서를 생각해서 써줘야댐
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


    }
}
