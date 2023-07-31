package carrace.view.reader;

public class MockReader implements Reader {

    private final String message;

    public MockReader(String mockMessage) {
        this.message = mockMessage;
    }

    @Override
    public String read() {
        return message;
    }
}
