import Activations.ActivationFunctions;

public class ForwardPropogation {
    
    private NeuronLayer inputLayer, outputLayer;
    private float[] input, output;
    public ForwardPropogation(){}
    
    public ForwardPropogation(NeuronLayer inputLayer, NeuronLayer outputLayer){
        this.inputLayer = inputLayer;
        this.outputLayer = outputLayer;
    }
    
    public void calculateOutput(float[] input, float[] output){
        float[] input_ = input;
        while(!inputLayer.getOutputLayer()){
            float[][] weights = inputLayer.getWeights();
            float[] LayerOutput = inputLayer.getOutputWeights();
            float[] bias = inputLayer.getBias();
            if(!inputLayer.getInputLayer()){
                input_ = inputLayer.getOutputWeights();
            }
            ActivationFunctions functions = inputLayer.getActivationFunction();
            NeuronLayer nextLayer = inputLayer.getNextLayer();
            for(int i = 0; i < inputLayer.getNoOfNeurons(); i++){
                float sum = 0;
                for(int j = 0; j <nextLayer.getNoOfNeurons();j++){
                    sum+= input_[j]*weights[i][j];
                }
                LayerOutput[i] = functions.activate(sum+bias[i]);
            }
            inputLayer.setOutputWeights(LayerOutput);
            inputLayer = nextLayer;
        }
    }
    
//    private void softmax() {
//        double max = Double.NEGATIVE_INFINITY;
//        for (int i = 0; i < outputLayer.units; i++) {
//            if (outputLayer.outputLayer[i] > max) {
//                max = outputLayer.outputLayer[i];
//            }
//        }
//
//        double sum = 0.0;
//        for (int i = 0; i < outputLayer.units; i++) {
//            double out = Math.exp(outputLayer.outputLayer[i] - max);
//            outputLayer.outputLayer[i] = out;
//            sum += out;
//        }
//
//        for (int i = 0; i < outputLayer.units; i++) {
//            outputLayer.outputLayer[i] /= sum;
//        }
//    }
}
