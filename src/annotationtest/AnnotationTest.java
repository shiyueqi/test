package annotationtest;

import java.lang.reflect.Method;

/**
 * Created by shiyueqi on 2016/7/20.
 */
public class AnnotationTest {

    public class UseCase {
        @TestCheck(desc = "test", id = 7)
        public String test(String input) {
            System.out.println("method input : " + input);
            return input+" 123";
        }

        @TestCheck(desc = "test2")
        public String test2(){
            return "";
        }

        public int test3(){
            return 0;
        }
    }

    public static void getAnnotations(Class<?> clazz){
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            TestCheck testCheck = method.getAnnotation(TestCheck.class);
            System.out.println("methodName : " + method.getName() + " || id : " + testCheck.id()
                    + " || methodName : " + testCheck.desc());
        }
    }

    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();
        getAnnotations(UseCase.class);
    }
}
