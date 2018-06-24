package Activations;

public class Relu implements ActivationFunctions {

    Relu(){

    }
    public float activate(float value) {

        return (value>0)?value:0;
    }

    public float derivative(float value){
        return (value > 0)? 1:0;
    }
}
