import Activations.ActivationFunctions;
import Activations.Sigmoid;
import Exceptions.ZeroNeuronException;

public class NeuronLayer {

    private NeuronLayer previousLayer;
    private NeuronLayer nextLayer;

    private boolean inputLayer = false;
    private boolean outputLayer = false;
    private ActivationFunctions activationFunction;
    private int noOfNeurons;
    private float[] bias;
    private float[][] weights;
    private float[] outputWeights;

    public NeuronLayer(int noOfNeurons){
        this.noOfNeurons = noOfNeurons;
        this.activationFunction = new Sigmoid();

    }
    public NeuronLayer(int noOfNeurons, ActivationFunctions functions){
        this.activationFunction = functions;
        this.noOfNeurons = noOfNeurons;
    }

    public boolean getInputLayer() {
        return inputLayer;
    }

    public void setInputLayer(boolean inputLayer) {
        this.inputLayer = inputLayer;
    }
    public NeuronLayer getPreviousLayer() {

        return previousLayer;
    }

    public void setPreviousLayer(NeuronLayer previousLayer) {
        this.previousLayer = previousLayer;
    }

    public NeuronLayer getNextLayer() {

        return nextLayer;
    }

    public void setNextLayer(NeuronLayer nextLayer)
    {
        this.nextLayer = nextLayer;
    }

    public boolean isOutputLayer() {

        return outputLayer;
    }

    public void setOutputLayer(boolean outputLayer) {

        this.outputLayer = outputLayer;
    }

    public boolean getOutputLayer(){
        return outputLayer;
    }

    public ActivationFunctions getActivationFunction() {

        return activationFunction;
    }

    public void setActivationFunction(ActivationFunctions activationFunction) {
        this.activationFunction = activationFunction;
    }

    public int getNoOfNeurons() {
        return noOfNeurons;
    }

    public void setNoOfNeurons(int noOfNeurons) {

        this.noOfNeurons = noOfNeurons;
    }

    public float[] getBias() {
        return bias;
    }

    public void setBias(float[] bias) {
        this.bias = bias;
    }

    public float[][] getWeights() {
        return weights;
    }

    public void setWeights(float[][] weights) {
        this.weights = weights;
    }

    public float[] getOutputWeights() {
        return outputWeights;
    }

    public void setOutputWeights(float[] outputWeights) {
        this.outputWeights = outputWeights;
    }

}
