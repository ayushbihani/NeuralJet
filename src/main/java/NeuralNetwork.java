import Activations.ActivationFunctions;
import Exceptions.ZeroNeuronException;
import Utils.utils;

public class NeuralNetwork {

    private float[][] input;
    private float[][] output;
    private NeuronLayer inputLayer, outputLayer;
    private NeuronLayer inputReference, outputReference;
    private int inputNeurons, outputNeurons;
    private float rate;
    private int epochs = 100; //default
    private ActivationFunctions functions;


    public  NeuralNetwork(float[][] input, float[][] output)throws ZeroNeuronException {
        this.input = input;
        this.output = output;
        if(this.input[0].length == 0 || this.output[0].length == 0){
            throw new ZeroNeuronException("Input cannot have 0 features");
        }
        inputNeurons = this.input[0].length;
        outputNeurons = this.output[0].length;
        init();
    }

    public void init(){
        try{
            inputLayer = new NeuronLayer(inputNeurons);
            outputLayer = new NeuronLayer(outputNeurons);
            outputLayer.setOutputLayer(true);
            inputLayer.setInputLayer(true);
            inputLayer.setNextLayer(outputLayer);
            outputLayer.setPreviousLayer(inputLayer);
            inputReference = inputLayer;
            outputReference = outputLayer;
            initializeWeights();
        } catch (ZeroNeuronException e){
            e.printStackTrace();
        }
    }

    public void setEpochs(int epochs){
        this.epochs = epochs;
    }

    public void addLayer(NeuronLayer layer)throws ZeroNeuronException{
        inputReference.setNextLayer(layer);
        layer.setPreviousLayer(inputReference);
        layer.setNextLayer(outputReference);
        outputReference.setPreviousLayer(layer);
        inputReference = layer;
        randomWeightsInit(inputReference, layer);
    }

    public void initializeWeights() throws ZeroNeuronException{
        NeuronLayer temp = inputLayer;
        while(!temp.getOutputLayer()){
            NeuronLayer nextLayer = temp.getNextLayer();
            randomWeightsInit(temp,nextLayer);
            temp = nextLayer;
        }
    }

    public void randomWeightsInit(NeuronLayer layer1, NeuronLayer layer2) throws ZeroNeuronException{
        int layer1Neurons = layer1.getNoOfNeurons();
        int layer2Neurons = layer2.getNoOfNeurons();
        if(layer1Neurons == 0 || layer2Neurons == 0){
            throw new ZeroNeuronException("Numbers of neurons in a layer cannot be 0");
        }
        float[] bias = new float[layer2Neurons];
        float[] outputWeights = new float[layer2Neurons];
        float[][] weights = new float[layer2Neurons][layer1Neurons];
        for(int i = 0; i < layer2Neurons; i++){
           bias[i] = utils.weightInit();
           for(int j = 0; j < layer1Neurons; j++){
                weights[i][j] = utils.weightInit();
           }
        }
        layer1.setBias(bias);
        layer1.setWeights(weights);
        layer1.setOutputWeights(outputWeights);
    }

    public void setActivation(ActivationFunctions functions){
        this.functions = functions;
    }

    public void setRate(float rate){
        this.rate = rate;
    }
}
