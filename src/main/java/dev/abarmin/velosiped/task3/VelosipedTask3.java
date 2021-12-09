package dev.abarmin.velosiped.task3;

/**
 * Task 3 - Non-Lazy JSON.
 *
 * <p>
 *   Implement a simple <pre>/sum</pre> endpoint which should receive requests via POST.
 *   The request is represented in JSON format
 *   {"arg1": 1, "arg2":2 }
 *   contains object Request with two parameters.
 *   The result of the sum should be returned back to the user in a next JSON object.
 *   {"result":3}
 *   External JSON library dependencies couldn't be used. For the JSON parsing and packing the
 *   VelosipedJsonParser class should be used
 * </p>
 *
 * <p>
 *   The interface has two methods - <pre>startServer</pre> which starts a web server on a given
 *   port and the <pre>stopServer</pre> method which stops the server.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedTask3 {
  void startServer(int port);
  void stopServer();
}
