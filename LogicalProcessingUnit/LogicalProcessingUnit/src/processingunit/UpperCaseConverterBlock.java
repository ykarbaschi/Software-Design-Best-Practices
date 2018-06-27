package processingunit;

public class UpperCaseConverterBlock implements Block{

    @Override
    public String convert(char input) {
          return String.valueOf(Character.toUpperCase(input));
    }

}

