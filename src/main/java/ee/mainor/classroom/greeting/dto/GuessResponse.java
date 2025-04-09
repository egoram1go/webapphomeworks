package ee.mainor.classroom.greeting.dto;

public class GuessResponse {
    private String message;

    public GuessResponse(String message) {
        this.message = message;
    }

    public GuessResponse() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
