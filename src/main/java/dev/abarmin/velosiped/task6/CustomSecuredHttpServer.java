package dev.abarmin.velosiped.task6;

import dev.abarmin.velosiped.task2.Request;


/**
 * Task 6 - Batman Will Defend Me.
 *
 * <p>
 *  We extending the CustomHttpServer with security filter.
 *  THis filter should find Bearer token and check that it's equals to "Batman" encoded to Base64.
 *  If yes - calculation should be proceeded, otherwise - 401 status should be returned with message "Unauthorized access"
 *
 * </p>
 *
 *
 * @author Aleksandr Barmin
 */
public interface CustomSecuredHttpServer {
    Request parseRequestParameters(String httpRequest);
    String createhttpResponse(String responseBody);
    void startServer(int port);
    void stopServer();
    Boolean securityFilter(String httpRequest) throws SecurityException;
}
