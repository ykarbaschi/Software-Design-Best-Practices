package processingunit;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;


public class BlockCreatorTest {

    BlockCreator blockCreator;

    @Before
    public void setUp() {
        blockCreator = new BlockCreator();
    }

    @Test
    public void createzBlockerFromInputString() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        assertEquals(true, blockCreator.createInstance("Blocker z") instanceof Blocker);
    }

    @Test
    public void createMultiplierBlockFromInputString() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        assertEquals(true, blockCreator.createInstance("MultiplierBlock") instanceof MultiplierBlock);
    }

    @Test
    public void createUpperCaseConverterBlockFromInputString() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        assertEquals(true, blockCreator.createInstance("UpperCaseConverterBlock") instanceof UpperCaseConverterBlock);
    }
}


