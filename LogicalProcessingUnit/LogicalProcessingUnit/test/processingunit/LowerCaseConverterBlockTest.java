package processingunit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LowerCaseConverterBlockTest extends BlockTest{

    public LowerCaseConverterBlockTest(char input , String expected) {
        super(input, expected);
    }

    @Override
    public Block createInstanceOfBlock() {
        return new LowerCaseConverterBlock();
    }

    @Parameterized.Parameters
    public static Collection InputsToCheck() {
        return Arrays.asList(new Object[][]{
                {'K', "k"},
                {'Z', "z"},
                {'1', "1"},
                {'o', "o"},
                {'/', "/"}});
    }
}
