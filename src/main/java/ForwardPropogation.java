import Activations.ActivationFunctions;

public class ForwardPropogation {
    private NeuronLayer layer;
    private float[][] input;

    public ForwardPropogation(NeuronLayer layer){
        this.layer = layer;
    }

    public ForwardPropogation(float[][] input, NeuronLayer layer){
        this.input = input;
        this.layer = layer;
    }

    public void calculateOutput(){

        NeuronLayer previousLayer = layer.getPreviousLayer();
        float[] input = previousLayer.getOutputWeights();
        float[][] weights = layer.getWeights();
        float[] output = layer.getOutputWeights();
        float[] bias = layer.getBias();
        ActivationFunctions functions = layer.getActivationFunction();
        for(int i = 0; i < layer.getNoOfNeurons(); i++){
            float sum = 0;
            for(int j = 0; j < previousLayer.getNoOfNeurons();j++){
                sum+= input[j]*weights[i][j];
            }
            output[i] = functions.activate(sum+bias[i]);
        }
        layer.setOutputWeights(output);
    }
}
