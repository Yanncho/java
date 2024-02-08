package fr.epita.assistants.throwback;

public class LongStringException extends StringException{
    public LongStringException(String str) {
        super("LongStringException: " + str + " (length: " + str.length() + ")");
    }
}
