package Exceptions_SeminarHW.Exceptions;

public class WrongNumberOfUserDetailsException extends IllegalArgumentException {
    int requiredLength;
    int length;
    public WrongNumberOfUserDetailsException(int length, int requiredLength) {
        super("You've only entered " + length + " of the user parameters, while the required number is " + requiredLength +
                ". Please, try again.");
        this.requiredLength = requiredLength;
        this.length = length;
    }
}
