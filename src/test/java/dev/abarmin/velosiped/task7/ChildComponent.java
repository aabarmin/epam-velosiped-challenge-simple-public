package dev.abarmin.velosiped.task7;

/**
 * The child component which should be used for injection.
 *
 * @author Aleksandr Barmin
 */
public class ChildComponent {
  private int numberOfInvocations = 0;

  @PostConstruct
  public void init() {
    this.numberOfInvocations++;
  }

  public int getNumberOfInvocations() {
    return numberOfInvocations;
  }
}
