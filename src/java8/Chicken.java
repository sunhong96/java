package java8;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) //쓸수있게 해줌 ChickenAnnotation여기서 어노테이션을 타입파라미터에도 쓸수있게해줌
@Target(ElementType.TYPE_USE) //모든 타입에 쓸수있게해줌
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
