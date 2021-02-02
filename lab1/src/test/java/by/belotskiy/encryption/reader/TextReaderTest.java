package by.belotskiy.encryption.reader;

import by.belotskiy.encryption.reader.exception.ReaderException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextReaderTest {
    @DataProvider
    public Object[][] filepath() {
        return new Object[][]{
                {"src/main/resources/data/default.txt", "Some default text :)"},
                {"src/main/resources/data/input_text.txt", "Всем привет, с вами Димас и сегодня мы попытаемся сдать первую лабу по ИСОБу. Поехали!"},
                {"blablabla", "Some default text :)"},

        };
    }
    @Test(dataProvider = "filepath")
    public void readerTest(String filepath, String actual) throws ReaderException {
        TextReader textReader = new TextReader();
        String result = textReader.read(filepath);
        assertEquals(result, actual);
    }
}
