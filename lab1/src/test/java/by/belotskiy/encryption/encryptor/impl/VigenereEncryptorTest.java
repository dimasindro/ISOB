package by.belotskiy.encryption.encryptor.impl;

import by.belotskiy.encryption.encryptor.CaesarEncryptor;
import by.belotskiy.encryption.encryptor.VigenereEncryptor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VigenereEncryptorTest {
    @DataProvider
    public Object[][] decrypt() {
        return new Object[][]{
                {"суету навести охота", 3, "суету навести охота"},
                {"абвгдеёжзийклмнопрстуфхцчшщъыьэюя", 10, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"}
        };
    }

    @Test(dataProvider = "decrypt")
    public void decryptRussianTest(String text, int shift, String actual) {
        VigenereEncryptor encryptor = new VigenereEncryptor('а', 'я');
        String encrypted = encryptor.encrypt(text, shift, "лемон");
        String result = encryptor.decrypt(encrypted, shift, "лемон");
        assertEquals(result, actual);
    }
}
