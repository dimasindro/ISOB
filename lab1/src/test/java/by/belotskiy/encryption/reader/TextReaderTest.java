package by.belotskiy.encryption.reader;

import by.belotskiy.encryption.reader.exception.ReaderException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextReaderTest {
    @DataProvider
    public Object[][] filepath() {
        return new Object[][]{
                {"src/main/resources/data/default.txt", "some default text :)"},
                {"src/main/resources/data/input_text.txt", "суету навести охота"},
                {"blablabla", "some default text :)"},

        };
    }
    @Test(dataProvider = "filepath")
    public void readerTest(String filepath, String actual) throws ReaderException {
        TextReader textReader = new TextReader();
        String result = textReader.read(filepath);
        assertEquals(result, actual);
    }
}
