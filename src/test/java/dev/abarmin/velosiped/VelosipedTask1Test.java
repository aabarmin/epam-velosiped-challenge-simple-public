package dev.abarmin.velosiped;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aleksandr Barmin
 */
class VelosipedTask1Test {
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
    final URL url = new URL("http://localhost:1234/sum?a=" + a + "&b=" + b);
    final URLConnection connection = url.openConnection();
    try (final InputStream stream = connection.getInputStream()) {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
      final String response = reader.readLine();
      assertEquals(a + b, Integer.parseInt(response));
    }
  }
}