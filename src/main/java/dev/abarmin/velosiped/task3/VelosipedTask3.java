package dev.abarmin.velosiped.task3;

import dev.abarmin.velosiped.task2.Request;
import dev.abarmin.velosiped.task2.Response;
import dev.abarmin.velosiped.task2.VelosipedTask2;

/**
 * Task 3 - Non-Lazy JSON.
 *
 * <p>
 *   Implement a simple <pre>/sum</pre> endpoint which should receive requests via POST.
 *   The request is represented in JSON format
 *
 *   <pre>
 *   {"arg1": 1, "arg2":2 }
 *   </pre>
 *
 *   contains object {@link Request} with two parameters.
 *   The result of the sum should be returned back to the user in a next JSON object.
 *
 *   <pre>
 *   {"result":3}
 *   </pre>
 *
 *   See, the {@link Response} class for details.
 * </p>
 *
 * <p>
 *   Please provide implementation of {@link VelosipedJsonAdapter} for dealing with JSON. It is not
 *   expected that external Json library will be used.
 * </p>
 *
 * <p>
 *   The interface has two methods - {@link VelosipedTask2#startServer(int)}
 *   which starts a web server on a given port and the {@link VelosipedTask2#stopServer()}
 *   method which stops the server.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedTask3 {
  /**
   * Start a server on a given port.
   *
   * @param port number
   */
  void startServer(int port);

  /**
   * Stop a started server.
   */
  void stopServer();
}
