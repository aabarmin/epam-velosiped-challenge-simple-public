package dev.abarmin.velosiped.task8;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Checking that there are classes with methods annotated with {@link RequestMapping} annotation
 * and parameters annotated with {@link RequestBody} there.
 *
 * @author Aleksandr Barmin
 */
public class VelosipedTask8Test {
  @Test
  void check_thereIsAClassAnnotatedWithControllerAnnotation() {
    final Reflections scanner = new Reflections("dev.abarmin.velosiped.task8");
    final Set<Class<?>> classesWithAnnotatedMethods = scanner.getSubTypesOf(Object.class)
        .stream()
        .filter(type -> hasAnnotatedMethods(type, RequestMapping.class))
        .collect(Collectors.toSet());

    assertThat(classesWithAnnotatedMethods)
        .withFailMessage("There are no classes with methods annotated with @RequestMapping " +
            "annotation in the package dev.abarmin.velosiped.task8")
        .isNotEmpty();

    final Set<Method> annotatedMethods = classesWithAnnotatedMethods.stream()
        .flatMap(type -> Arrays.stream(type.getDeclaredMethods()))
        .filter(method -> method.isAnnotationPresent(RequestMapping.class))
        .filter(method -> hasAnnotatedParameter(method, RequestBody.class))
        .collect(Collectors.toSet());

    assertThat(annotatedMethods)
        .withFailMessage("There are no parameters annotated with @RequestBody in methods " +
            "annotated with @RequestMapping in the package dev.abarmin.velosiped.task8")
        .isNotEmpty();
  }

  private boolean hasAnnotatedParameter(Method method, Class<? extends Annotation> annotation) {
    for (Annotation[] parameterAnnotations : method.getParameterAnnotations()) {
      for (Annotation parameterAnnotation : parameterAnnotations) {
        if (parameterAnnotation.annotationType() == annotation) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasAnnotatedMethods(Class<?> classToCheck,
                                      Class<? extends Annotation> annotation) {
    for (Method method : classToCheck.getDeclaredMethods()) {
      if (method.isAnnotationPresent(annotation)) {
        return true;
      }
    }
    return false;
  }
}
