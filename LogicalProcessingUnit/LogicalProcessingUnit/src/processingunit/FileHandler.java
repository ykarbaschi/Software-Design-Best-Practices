package processingunit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

    public List<String> readFileForBlocks(String fileAddress) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileAddress));
        return stream.collect(Collectors.toList());
    }
}
