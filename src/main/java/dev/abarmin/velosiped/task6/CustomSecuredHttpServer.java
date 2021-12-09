package dev.abarmin.velosiped.task6;

import dev.abarmin.velosiped.task2.Request;


/**
 * Task 6 - Batman Will Defend Me.
 *
 * <p>
 *  We extending the CustomHttpServer with security filter.
 *  THis filter should find Bearer token and check that it's equals to "Batman" encoded to Base64.
 *  If yes - calculation should be proceeded, otherwise - 401 status should be returned with message "Unauthorized access"
 * </p>

 * @author Aleksandr Barmin
 */
public interface CustomSecuredHttpServer {
    /**
     * This method receives a request as a string and should convert it to the {@link Request}
     * object accordingly.
     *
     * @param httpRequest to parse.
     * @return a {@link Request} object.
     */
    Request parseRequestParameters(String httpRequest);

    /**
     * This method receives a response <b>body</b> and should convert it to the HTTP response.
     *
     * @param responseBody to include into the HTTP response.
     * @return a content of HTTP response.
     */
    String createHttpResponse(String responseBody);

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

    /**
     * Checks if a request contains the expected header in the expected format.
     *
     * @param httpRequest to check.
     * @return true either false depends on the results of the check.
     * @throws SecurityException
     */
    boolean securityFilter(String httpRequest) throws SecurityException;
}
