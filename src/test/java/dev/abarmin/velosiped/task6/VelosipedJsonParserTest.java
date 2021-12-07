package dev.abarmin.velosiped.task6;

import dev.abarmin.velosiped.helper.VelosipedHelper;
import dev.abarmin.velosiped.task6.VelosipedJsonParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aleksandr Barmin
 */
class VelosipedJsonParserTest {
  private VelosipedJsonParser uut = VelosipedHelper.getInstance(VelosipedJsonParser.class);

  @ParameterizedTest
  @CsvSource({
      "1,2",
      "10,20",
      "-1,-2"
  })
  void parseJson(int a, int b) {
    final String requestBody = "{\"arg1\": " + a + ", \"arg2\": " + b +"}";
    final Request result = uut.parse(requestBody, Request.class);

    assertAll(
        () -> assertNotNull(result),
        () -> assertEquals(a, result.getArg1()),
        () -> assertEquals(b, result.getArg2())
    );
  }

  static class Request {
    private int arg1;
    private int arg2;

    public int getArg1() {
      return arg1;
    }

    public void setArg1(int arg1) {
      this.arg1 = arg1;
    }

    public int getArg2() {
      return arg2;
    }

    public void setArg2(int arg2) {
      this.arg2 = arg2;
    }
  }
}