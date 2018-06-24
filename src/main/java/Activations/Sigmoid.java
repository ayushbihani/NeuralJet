package Activations;

public class Sigmoid implements ActivationFunctions {

    public float activate(float value) {
        return (float)(1.0/(1 + Math.exp(-value)));
    }

    public float derivative(float value){
        float activated = this.activate(value);
        return activated*(1-activated);
    }

}
