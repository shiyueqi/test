package annotationtest;

import java.lang.annotation.*;

/**
 * Created by shiyueqi on 2016/7/20.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestCheck {
    String desc() default "desc";

    int id() default 0;
}
