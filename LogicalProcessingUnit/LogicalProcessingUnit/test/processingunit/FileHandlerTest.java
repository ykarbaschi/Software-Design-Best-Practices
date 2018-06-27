package processingunit;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class FileHandlerTest {
    FileHandler fileHandler;

    @Before
    public void setUp() {
        fileHandler = new FileHandler();
    }

    @Test
    public void readFileAndCheckForNumberOfBlocks() throws IOException {
        String currentDirectory = new File("").getAbsolutePath();
        assertEquals(4, fileHandler.readFileForBlocks(currentDirectory + "/LogicalProcessingUnit/Input/BlockInput.txt").size());
    }
}
