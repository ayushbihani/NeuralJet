package Utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataUtils {

    private String FILE_DIRECTORY;
    private Logger logger;
    private int rows;
    private int columns;
    private float inputData[][];
    private float outputData[];

    DataUtils(String directory){
            this.FILE_DIRECTORY = directory;
            this.logger = Logger.getLogger(DataUtils.class.getName());
    }

    public float[][] readInputFile(String file){
        List<String> lines;
        try{
            lines = Files.readAllLines(Paths.get(FILE_DIRECTORY.concat(file)),Charset.defaultCharset());
            if(lines.size() > 0){
                rows = lines.size();
                columns = lines.get(0).split(",").length;
                inputData = new float[rows][columns];
                parseInputFile(lines);
            } else {
                logger.log(Level.OFF, "Input File cannot be empty! Exiting");
                System.exit(1);
            }
        } catch (IOException e){
            logger.log(Level.SEVERE, "Unable to read file");
            e.printStackTrace();
        }
        return inputData;
    }

    private void parseInputFile(List<String>lines){

        for(int i = 0;i < rows; i++){
            String[] arrLine = lines.get(i).split(",");
            for(int j = 0;j < columns; j++){
                inputData[i][j] = Float.parseFloat(arrLine[j]);
            }
        }
    }


    public float[] readOutputFile(String file){
        List<String> lines;
        try{
            lines = Files.readAllLines(Paths.get(FILE_DIRECTORY.concat(file)),Charset.defaultCharset());
            if(lines.size() > 0){
                outputData = new float[lines.size()];
                for(int i = 0;i < lines.size(); i++){
                    outputData[i] = Float.parseFloat(lines.get(i));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return outputData;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }



}
