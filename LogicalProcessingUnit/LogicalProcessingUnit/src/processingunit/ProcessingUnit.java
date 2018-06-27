package processingunit;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessingUnit {

    private List<Block> listOfBlocks;
                                      
    public ProcessingUnit(List<Block> theListOfBlocks){
        listOfBlocks = theListOfBlocks;
    }

    public String processUsingOneBlock(String inputStream, Block block)  {

        return inputStream.chars()
                          .mapToObj(inputChar -> (char)inputChar)
                          .map(block::convert)
                          .collect(Collectors.joining());
    }

    public String process(String input) {

        return listOfBlocks.stream()
                           .reduce(input, this::processUsingOneBlock, String::concat);
    }
}



