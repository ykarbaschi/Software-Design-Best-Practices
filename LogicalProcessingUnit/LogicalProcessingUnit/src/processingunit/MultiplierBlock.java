package processingunit;

public class MultiplierBlock implements Block{

    public String convert(char input) {
        return String.format("%s%s", input,input);
    }
}
