package by.belotskiy.encryption.encryptor.impl;

import by.belotskiy.encryption.encryptor.CaesarEncryptor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CaesarEncryptorTest {

    @DataProvider
    public Object[][] english() {
        return new Object[][]{
                {"abcd", 1, "bcde"},
                {"abcdz", 1, "bcdea"},
        };
    }
    @DataProvider
    public Object[][] russian() {
        return new Object[][]{
                {"суету навести охота", 3, "фцихц ргеифхл сшсхг"},
        };
    }
    @DataProvider
    public Object[][] decrypt() {
        return new Object[][]{
                {"суету навести охота", 3, "суету навести охота"},
        };
    }

    @Test(dataProvider = "english")
    public void encryptEnglishTest(String text, int shift, String actual) {
        CaesarEncryptor encryptor = new CaesarEncryptor('a', 'z');
        String result = encryptor.encrypt(text, shift);
        assertEquals(result, actual);
    }

    @Test(dataProvider = "russian")
    public void encryptRussianTest(String text, int shift, String actual) {
        CaesarEncryptor encryptor = new CaesarEncryptor('а', 'я');
        String result = encryptor.encrypt(text, shift);
        assertEquals(result, actual);
    }
    @Test(dataProvider = "decrypt")
    public void decryptRussianTest(String text, int shift, String actual) {
        CaesarEncryptor encryptor = new CaesarEncryptor('а', 'я');
        String encrypted = encryptor.encrypt(text, shift);
        String result = encryptor.decrypt(encrypted, shift);
        assertEquals(result, actual);
    }
}

