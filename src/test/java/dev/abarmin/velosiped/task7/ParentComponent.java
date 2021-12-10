package dev.abarmin.velosiped.task7;

/**
 * This is the main component which has a dependency to be injected.
 *
 * @author Aleksandr Barmin
 */
public class ParentComponent {
  @Inject
  private ChildComponent childComponent;

  private int numberOfInvocations = 0;

  @PostConstruct
  public void init() {
    this.numberOfInvocations++;
  }

  public ChildComponent getChildComponent() {
    return childComponent;
  }

  public int getNumberOfInvocations() {
    return numberOfInvocations;
  }
}
