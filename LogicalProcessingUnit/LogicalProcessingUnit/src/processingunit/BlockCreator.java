package processingunit;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BlockCreator {

     public Block createInstance(String inputStringOfBlock) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

            String[] blockNameAndParameters = inputStringOfBlock.split(" ");

            Class<Block> blockClass = (Class<Block>) Class.forName("processingunit." + blockNameAndParameters[0]);
            final Constructor<Block> constructor = (Constructor<Block>) blockClass.getConstructors()[0];

            if (blockNameAndParameters.length == 2)
                return (constructor.newInstance(blockNameAndParameters[1].charAt(0)));
            else
                return (constructor.newInstance());
    }
}
