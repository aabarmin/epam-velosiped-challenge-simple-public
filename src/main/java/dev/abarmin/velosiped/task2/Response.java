package dev.abarmin.velosiped.task2;

/**
 * DTO class for mapping the response.
 */
public class Response {
    private int result;

    public Response(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
