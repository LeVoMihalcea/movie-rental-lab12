package ro.ubb.catalog.core.model.exceptions;

public class ParameterCountException extends RuntimeException {
    public ParameterCountException(int expected, int provided){
        super("Wrong parameter count; expected " + expected + " provided " + provided);
    }

    public ParameterCountException(int expected, int alt, int provided){
        super("Wrong parameter count; expected " + expected + " or " + alt + " provided " + provided);
    }
}
