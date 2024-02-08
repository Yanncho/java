package fr.epita.assistants.throwback;

public class NegativeIntegerException extends IntegerException{
    public NegativeIntegerException(String str){
        super("NegativeIntegerException: " + str);
    }
}
