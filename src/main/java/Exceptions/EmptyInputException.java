package Exceptions;

public class EmptyInputException  extends Exception{
    public EmptyInputException(){
        super();
    }

    public EmptyInputException(String message){
        super(message);
    }

    public EmptyInputException(String message, Throwable casue){
        super(message, casue);
    }

}