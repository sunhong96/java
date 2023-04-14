package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Optional1 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot",true));
        springClasses.add(new OnlineClass(2,"spring data jpa",true));
        springClasses.add(new OnlineClass(3,"spring mvc",false));
        springClasses.add(new OnlineClass(4,"spring core",false));
        springClasses.add(new OnlineClass(5,"rest api development",false));


        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();


        OnlineClass onlineClass = optional.orElse(createNewClasss());
        System.out.println(onlineClass.getTitle());
        //있으면 가져오고 없으면 새로운 반을 만듬 근데 있는데도 새로운반을 문구를 호출함 그때쓸수있는게 다음과 같음
        //이미만들어져있는걸 참고해서 쓸때는 orElse 를 쓰는게 좋음
        System.out.println("----------------------------");
        onlineClass = optional.orElseGet(Optional1::createNewClasss);
        System.out.println(onlineClass.getTitle());
        System.out.println("----------------------------");
        //새로 만들거나 추가할때 작업에는 orElseGet 을 쓰는게 좋음

        Optional<OnlineClass> onlineClass1 = optional.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass1.isEmpty());
        //필터에 해당이되면 그대로 나오고 아니면 실행이안됨

        System.out.println("----------------------------");
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        System.out.println("----------------------------");

//        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
//        Optional<Progress> progress2 = progress1.orElse(Optional.empty()); //이렇게 호출해줘야되는데 optional 2개가 있을때

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        //flatMap 을 쓰면 한번에 호출할수있음
        //stream 에서의 flatMap 은 다름 input이 1개일때 output이 여러개일때에서 쓰는것임

        System.out.println("----------------------------");
        boolean present = optional.isPresent();
        System.out.println(present); //존재하는지
        System.out.println("----------------------------");

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        System.out.println("----------------------------");



    }

    private static OnlineClass createNewClasss() {
        System.out.println("creating new online class");
        return new OnlineClass(10,"New class",false);
    }
}
