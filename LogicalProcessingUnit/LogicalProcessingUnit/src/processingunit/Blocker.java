package processingunit;

public class Blocker implements Block{

    private final char characterToBlock;

    public Blocker(char charToBlock) {
        characterToBlock = charToBlock;
    }

    public String convert(char input ) {
        return input == characterToBlock ? "" : String.valueOf(input);
    }
}
