package dev.abarmin.velosiped.task9;

import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Aleksandr Barmin
 */
public class VelosipedTask9Test {
  @Test
  void checking_classesAnnotatedWithControllerAnnotation() {
    final Reflections scanner = new Reflections("dev.abarmin.velosiped.task9");
    final Set<Class<?>> controllers = scanner.getTypesAnnotatedWith(Controller.class);

    assertThat(controllers)
        .withFailMessage("No classes annotated with @Controller in the package " +
            "with name dev.abarmin.velosiped.task9")
        .isNotEmpty();
  }

  @Test
  void checking_classesAnnotatedWithServiceAnnotation() {
    final Reflections scanner = new Reflections("dev.abarmin.velosiped.task9");
    final Set<Class<?>> service = scanner.getTypesAnnotatedWith(Service.class);

    assertThat(service)
        .withFailMessage("No classes annotated with @Service in the package " +
            "with name dev.abarmin.velosiped.task9")
        .isNotEmpty();
  }
}
