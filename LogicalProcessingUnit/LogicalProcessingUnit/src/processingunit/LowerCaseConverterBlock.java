package processingunit;

public class LowerCaseConverterBlock implements  Block{

    @Override
    public String convert(char input) {
        return String.valueOf(Character.toLowerCase(input));
    }
}
