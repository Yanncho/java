package fr.epita.assistants.throwback;

public class UnknownException extends Exception {
    public UnknownException(String str){
        super("UnknownException: " + str);
    }
}
