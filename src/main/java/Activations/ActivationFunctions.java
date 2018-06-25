package Activations;

/**
 * Interface for activations functions. All functions must implement
 * this interface and override the methods
 * */
public interface ActivationFunctions {

    /**
     * Calculate the activation value defined by the function
     * @param value The input value
     * @return Returns the activation value
     * */
    float activate(float value);
    /**
     * @param value :Input Value
     * @return Returns derivative
     * */
    float derivative(float value);
}
