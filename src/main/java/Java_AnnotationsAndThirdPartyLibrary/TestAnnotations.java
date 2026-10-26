package Java_AnnotationsAndThirdPartyLibrary;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotations {

    @Override
    @MethodInfo(author = "Mihir", date = "October 27, 2026",
            revision = 1, comments = "Overrides Object.toString()")
    public String toString() {
        return "This method has MethodInfo metadata.";
    }

    @Deprecated
    @MethodInfo(date = "October 27, 2026", comments = "Use a newer method instead")
    public void oldMethod() {
        System.out.println("This is an old method.");
    }

    public static void main(String[] args) {
        Method[] methods = TestAnnotations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo info = method.getAnnotation(MethodInfo.class);

                System.out.println("Method: " + method.getName());
                System.out.println("Author: " + info.author());
                System.out.println("Date: " + info.date());
                System.out.println("Revision: " + info.revision());
                System.out.println("Comments: " + info.comments());

                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation: " + annotation);
                }
                System.out.println();
            }
        }
    }
}
