package processingunit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessingUnitDriver {

    public static void main(String[] args) {

        List<String> blocks = new ArrayList<>();
        try {
            blocks = new FileHandler().readFileForBlocks(new File("").getAbsolutePath() + args[0]);
        } catch (IOException e) {
            System.out.println("Please specify correct Block names in correct format in the correct address");
        }

        List<Block> listOfBlocks = new ArrayList<>();

        for (String block : blocks)
            try {
                listOfBlocks.add(new BlockCreator().createInstance(block));
            } catch (Exception ex) {
                System.out.println("Some blocks do not exist or cannot be accessed. Please recheck.");
            }

        Scanner scanner = new Scanner(System.in);
        ProcessingUnit processingUnit = new ProcessingUnit(listOfBlocks);

        System.out.println("Demo Input: 12zZas \nOutput = " + processingUnit.process("12zZas"));
        System.out.println("\nDemo Input: ZA1q \nOutput = " + processingUnit.process("ZA1q") + "\n\nPlease enter your input: ");

        while (scanner.hasNext()) {
            System.out.println("Output = " + processingUnit.process(scanner.nextLine()));
            System.out.println("\nPlease enter your input: ");
        }
    }
}
