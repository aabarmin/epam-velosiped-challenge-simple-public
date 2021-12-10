package dev.abarmin.velosiped.task7;

import dev.abarmin.velosiped.helper.VelosipedHelper;
import dev.abarmin.velosiped.task5.DIContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Checking if DI container is processing {@link PostConstruct} annotation correctly and
 * caching already created instances - literally creates singletons.
 *
 * @author Aleksandr Barmin
 */
public class VelosipedTask7Test {
  private DIContainer diContainer = VelosipedHelper.getInstance(DIContainer.class);

  @BeforeEach
  void setUp() {
    diContainer.init();
  }

  @Test
  void getBean_getComponentsFromContainer() {
    final ParentComponent parentBean = diContainer.getBean(ParentComponent.class);

    assertThat(parentBean)
        .withFailMessage("Parent bean is not available")
        .isNotNull();
    
    assertThat(parentBean.getChildComponent())
        .withFailMessage("Child bean is not available")
        .isNotNull();
    
    assertThat(parentBean)
        .withFailMessage("Invalid number of invocations on parent bean")
        .extracting("numberOfInvocations")
        .isEqualTo(1);
    
    assertThat(parentBean.getChildComponent())
        .withFailMessage("Invalid number of invocations on child bean")
        .extracting("numberOfInvocations")
        .isEqualTo(1);
  }

  @Test
  void getBean_checkIfBeansAreSingletons() {
    final ParentComponent firstInvocation = diContainer.getBean(ParentComponent.class);
    final ParentComponent secondInvocation = diContainer.getBean(ParentComponent.class);

    assertThat(firstInvocation)
        .withFailMessage("Different parent instances are provided")
        .isSameAs(secondInvocation);

    assertThat(firstInvocation.getChildComponent())
        .withFailMessage("Different child instances are provided")
        .isSameAs(secondInvocation.getChildComponent());
  }
}
