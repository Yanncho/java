package fr.epita.assistants.throwback;

public class PositiveIntegerException extends IntegerException{
    public PositiveIntegerException(String str){
        super("PositiveIntegerException: " + str);
    }
}
