package dev.abarmin.velosiped;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aleksandr Barmin
 */
class VelosipedTask3Test {
  private VelosipedTask1 uut = VelosipedHelper.getInstance(VelosipedTask1.class);

  @BeforeEach
  void setUp() {
    uut.startServer(1234);
  }

  @AfterEach
  void tearDown() {
    uut.stopServer();
  }

  @ParameterizedTest
  @CsvSource({
      "1,2",
      "10,20",
      "-1,-2"
  })
  void check_calculation(int a, int b) throws Exception {
    final URL url = new URL("http://localhost:1234/sum-post");
    final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json");

    final String requestBody = "{\"arg1\": " + a + ", \"arg2\": " + b +"}";
    try (final OutputStream outputStream = connection.getOutputStream()) {
      outputStream.write(requestBody.getBytes(StandardCharsets.UTF_8));
    }

    try (final InputStream stream = connection.getInputStream()) {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      final String response = reader.readLine();

      final String expectedResult = "{\"result\":" + (a + b) + "}";
      assertEquals(expectedResult, response);
    }
  }
}