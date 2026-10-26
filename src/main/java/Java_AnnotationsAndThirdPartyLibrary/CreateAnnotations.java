package Java_AnnotationsAndThirdPartyLibrary;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited // @Inherited applies to class annotations, so it has no effect with METHOD only.
@interface MethodInfo {
    String author() default "Mihir";
    String date();
    int revision() default 1;
    String comments() default "";
}

public class CreateAnnotations {

    @MethodInfo(date = "October 27, 2026", comments = "A small annotation example")
    public void sayHello() {
        System.out.println("Hello from an annotated method!");
    }

    public static void main(String[] args) {
        CreateAnnotations example = new CreateAnnotations();
        example.sayHello();
    }
}
