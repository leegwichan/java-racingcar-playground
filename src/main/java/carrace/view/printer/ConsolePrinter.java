package carrace.view.printer;

public final class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
