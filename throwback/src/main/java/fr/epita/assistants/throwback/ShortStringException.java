package fr.epita.assistants.throwback;

public class ShortStringException extends StringException{
    public ShortStringException(String str){
        super("ShortStringException: " + str + " (length: " + str.length() + ")");
    }
}
