package processingunit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BlockerTest extends BlockTest{

    public BlockerTest(char input, String expected) {
        super(input, expected);
    }

    @Override
    public Blocker createInstanceOfBlock() {
        return new Blocker('z');
    }

    @Parameterized.Parameters
    public static Collection InputsToCheck() {
        return Arrays.asList(new Object[][]{
                { 'k', "k"},
                { 'Z', "Z"},
                { 'z', ""}});
    }

}
