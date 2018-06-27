package processingunit;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class ProcessingUnitTest {
    ProcessingUnit processingUnit;

    @Test
    public void inputAStringAndReturnAllzBlockedFromTheString() {

        processingUnit = new ProcessingUnit(Arrays.asList(new Blocker('z'))); 
        assertEquals("abcd123ZZ", processingUnit.process("abcdzz123ZZ"));
    }

    @Test
    public void inputAStringAndReturnAllCharactersMultipliedBy2() {

        processingUnit = new ProcessingUnit(
          Arrays.asList(new MultiplierBlock()));

        assertEquals("aabbccddzz112233ZZ",
          processingUnit.process("abcdz123Z"));
    }

    @Test
    public void inputAStringAndReturnAllCharactersInUpperCase() {

        processingUnit = new ProcessingUnit(
          Arrays.asList(new UpperCaseConverterBlock()));

        assertEquals("ABCDZZ123ZZ", processingUnit.process("abcdzz123ZZ"));
    }

    @Test
    public void inputAStringAndReturnzRemovedAndAllInUpperCaseAndMultipliedBy2() {

        processingUnit = new ProcessingUnit (
          Arrays.asList(new Blocker('z'),
            new MultiplierBlock(),
            new UpperCaseConverterBlock()));

        assertEquals("AABBCCDD112233ZZZZ",
          processingUnit.process("abcdzz123ZZ"));
    }

}
