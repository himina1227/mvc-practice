import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Reflection {

    private static final Logger logger = LoggerFactory.getLogger(Reflection.class);
    @DisplayName("리플렉션으로 @Controller 어노테이션이 맵핑된 클래스 정보를 가져온다.")
    @Test
    public void refection() {
        Set<Class<?>> beans = getAnnotations(List.of(Controller.class, Service.class));
    }

    private static Set<Class<?>> getAnnotations(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.stream().forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
