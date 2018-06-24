package Activations;

public class Tanh implements ActivationFunctions {

    public float activate(float value) {
        return (float)((2/(1+Math.exp(value)))-1);
    }

    public float derivative(float value){
        return (float)(1- Math.pow(this.activate(value),2));
    }
}
