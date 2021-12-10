package dev.abarmin.velosiped.task3;

import dev.abarmin.velosiped.helper.VelosipedHelper;
import dev.abarmin.velosiped.task2.Request;
import dev.abarmin.velosiped.task2.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aleksandr Barmin
 */
class VelosipedJsonAdapterTest {
    private VelosipedJsonAdapter uut = VelosipedHelper.getInstance(VelosipedJsonAdapter.class);

    @ParameterizedTest
    @CsvSource({
            "1,2",
            "10,20",
            "-1,-2"
    })
    void parseJson(int a, int b) {
        final String requestBody = "{\"arg1\": " + a + ", \"arg2\": " + b + "}";
        final Request result = uut.parse(requestBody, Request.class);

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(a, result.getArg1()),
                () -> assertEquals(b, result.getArg2())
        );
    }

    @Test
    void packJson() {
        Response result = new Response(3);
        final String resultString = uut.writeAsJson(result);
        assertEquals(resultString, "{\"result\":3}");
    }


}