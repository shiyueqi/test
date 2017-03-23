package annotationtest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by shiyueqi on 2016/7/20.
 */
@Deprecated
@SupportedAnnotationTypes("annotationtest.TestCheck")
public class TestCheckProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("annotation success!");
        return true;
    }
}
