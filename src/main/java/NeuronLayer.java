import Activations.ActivationFunctions;
import Activations.Sigmoid;
import Utils.utils;
import Exceptions.ZeroNeuronException;

public class NeuronLayer {

    private NeuronLayer previousLayer;
    private NeuronLayer nextLayer;
    private int inputLayer;
    private boolean outputLayer = false;
    private ActivationFunctions activationFunction;
    private int noOfNeurons;
    private float rate;
    private float[] bias;
    private float[][] weights;
    private float[] outputWeights;

    public NeuronLayer(int noOfNeurons) throws ZeroNeuronException{

        this.noOfNeurons = noOfNeurons;
        this.activationFunction = new Sigmoid();
        this.rate = 0.01f;
        init();
    }

    public NeuronLayer(int previousLayer, int noOfNeurons) throws ZeroNeuronException{
        inputLayer = previousLayer;
        this.noOfNeurons = noOfNeurons;
        this.activationFunction = new Sigmoid();
        this.rate = 0.01f;
        init();
    }

    public NeuronLayer(int noOfNeurons, ActivationFunctions functions, float rate) throws ZeroNeuronException{
        this.activationFunction = functions;
        this.noOfNeurons = noOfNeurons;
        this.rate = rate;
        init();
    }

    private void init() throws ZeroNeuronException {
        if(noOfNeurons == 0){
            throw new ZeroNeuronException("Number of neurons in a hidden layer cannot be 0");
        }
        bias = new float[noOfNeurons];
        outputWeights = new float[noOfNeurons];
        if(previousLayer!=null){
            inputLayer = previousLayer.noOfNeurons;
            weights = new float[inputLayer][noOfNeurons];
        } else {
            try {
                weights = new float[inputLayer][noOfNeurons];
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for(int i = 0; i < inputLayer; i++){
            bias[i] = utils.weightInit();
            for(int j = 0; j < noOfNeurons; j++){
                weights[i][j] = utils.weightInit();
            }
        }
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

    public void setNextLayer(NeuronLayer nextLayer) {
        this.nextLayer = nextLayer;
    }

    public boolean isOutputLayer() {
        return outputLayer;
    }

    public void setOutputLayer(boolean outputLayer) {
        this.outputLayer = outputLayer;
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
