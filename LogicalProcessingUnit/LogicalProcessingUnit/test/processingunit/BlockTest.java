package processingunit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BlockTest {
    private char _input;
    private String _expected;
    private Block block;

    public BlockTest(char input, String expected){
        _input = input;
        _expected = expected;
    }

    @Before
    public void setUp() {
        block = createInstanceOfBlock();
    }

    public abstract Block createInstanceOfBlock();

    @Test
    public void blockFunctionalityChecker() {
        assertEquals(_expected, block.convert(_input));
    }
}
