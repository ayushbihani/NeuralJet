import Activations.ActivationFunctions;
import Exceptions.ZeroNeuronException;

public class NeuralNetwork {

    private float[][] input;
    private float[][] output;
    private NeuronLayer inputLayer, outputLayer;
    private NeuronLayer inputReference, outputReference;
    private int inputNeurons;
    private int hiddenLayerNeurons = 0;
    private float rate;
    private ActivationFunctions functions;

    public NeuralNetwork(float[][] input, float[][] output,int hiddenLayerNeurons)throws ZeroNeuronException{
        this(input,output);
        this.hiddenLayerNeurons = hiddenLayerNeurons;
    }

    public  NeuralNetwork(float[][] input, float[][] output)throws ZeroNeuronException {
        this.input = input;
        this.output = output;
        if(this.input[0].length == 0){
            throw new ZeroNeuronException("Input cannot have 0 features");
        }
        inputNeurons = this.input[0].length;
        init();
    }

    public void init(){
        try{
            inputLayer = new NeuronLayer(inputNeurons, (hiddenLayerNeurons!=0)?hiddenLayerNeurons:inputNeurons+1);
            outputLayer = new NeuronLayer((hiddenLayerNeurons!=0)?hiddenLayerNeurons:inputNeurons+1, output[0].length);
            outputLayer.setOutputLayer(true);
            inputLayer.setNextLayer(outputLayer);
            outputLayer.setPreviousLayer(inputLayer);
            inputReference = inputLayer;
            outputReference = outputLayer;
        } catch (ZeroNeuronException e){
            e.printStackTrace();
        }
    }

    public void addLayer(NeuronLayer layer){
        inputReference.setNextLayer(layer);
        layer.setPreviousLayer(inputReference);
        layer.setNextLayer(outputReference);
        inputReference = layer;
    }

    public void setActivation(ActivationFunctions functions){
        this.functions = functions;
    }

    public void setRate(float rate){
        this.rate = rate;
    }
}
