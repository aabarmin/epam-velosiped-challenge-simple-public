package dev.abarmin.velosiped.task1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VelosipedTask1Impl implements VelosipedTask1 {

    private HttpServer server;
    private final String rootContext;
    private final HttpHandler httpHandler;

    public VelosipedTask1Impl() {
        this.rootContext = "/sum";
        this.httpHandler = this::handle;
    }

    @Override
    public void startServer(int port) {
        try {
            if (server != null)
                stopServer();

            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext(rootContext, httpHandler);
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopServer() {
        if (server != null){
            server.stop(1);
            server = null;
        }

    }

    private void handle(HttpExchange httpExchange) throws IOException {
        Map<String, List<String>> params = queryToMap(httpExchange.getRequestURI().getQuery());
        String response = "Invalid input";
        int code = 500;
        if (!params.containsKey("a") || !params.containsKey("b")) {
            respond(httpExchange, response, code);
            return;
        }

        try {
            List<String> aps = params.get("a");
            int a = Integer.parseInt(aps.get(0));
            List<String> bps = params.get("b");
            int b = Integer.parseInt(bps.get(0));

            code = 200;
            response = String.valueOf((a + b));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        respond(httpExchange, response, code);
    }

    private void respond(HttpExchange httpExchange, String response, int code) throws IOException {
        httpExchange.getResponseHeaders().add("Content-Type", "text/html");
        httpExchange.sendResponseHeaders(code, response.length());

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.flush();
        os.close();
    }

    private Map<String, List<String>> queryToMap(String query) {
        Map<String, List<String>> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], Collections.singletonList(pair[1]));
            } else {
                result.put(pair[0], Collections.singletonList(""));
            }
        }
        return result;
    }
}
