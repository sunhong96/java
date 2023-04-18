package java8;

import jdk.dynalink.beans.StaticClass;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
public class ChickenAnnotation {
    public static void main(String[] args) {
        
//        Chicken[] chickens = ChickenAnnotation.class.getAnnotationsByType(Chicken.class);
//        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));
        
        ChickenContainer chickenContainer = ChickenAnnotation.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> System.out.println(c.value()));
        //호출의 2가지 방법
        
    }

//    static class FeelsLikeChicken<@Chicken T>{
//        public static <@Chicken C> void print(C c){ //똑같은 C 지만 둘은 서로 전혀 다른거임
//            System.out.println(c);
//        };
}
