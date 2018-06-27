package processingunit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UpperCaseConverterBlockTest extends BlockTest{

    public UpperCaseConverterBlockTest(char input , String expected) {
        super(input, expected);
    }

    @Override
    public Block createInstanceOfBlock() {
        return new UpperCaseConverterBlock();
    }

    @Parameterized.Parameters
    public static Collection InputsToCheck() {
        return Arrays.asList(new Object[][]{
                {'k', "K"},
                {'Z', "Z"},
                {'1', "1"},
                {'Z', "Z"},
                {'/', "/"}});
    }

}
                                