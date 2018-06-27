package processingunit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultiplierBlockTest extends BlockTest{

    public MultiplierBlockTest(char input , String expected) {
        super(input, expected);
    }

    @Override
    public Block createInstanceOfBlock() {
        return new MultiplierBlock();
    }

    @Parameterized.Parameters
    public static Collection InputsToCheck() {
        return Arrays.asList(new Object[][]{{'a', "aa"},
                                            {'B', "BB"},
                                            {'@', "@@"},
                                            {'1', "11"},
                                            {' ', "  "}});
    }
}
