package Exceptions;

public class ZeroNeuronException  extends Exception{
    public ZeroNeuronException(){
        super();
    }

    public ZeroNeuronException(String message){
        super(message);
    }

    public ZeroNeuronException(String message, Throwable casue){
        super(message, casue);
    }

}
