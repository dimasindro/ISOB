package by.belotskiy.encryption;

import by.belotskiy.encryption.encryptor.CaesarEncryptor;
import by.belotskiy.encryption.encryptor.VigenereEncryptor;
import by.belotskiy.encryption.reader.TextReader;
import by.belotskiy.encryption.reader.exception.ReaderException;

public class Program {

    public static final String filepath = "src/main/resources/data/input_text.txt";
    public static final String alice_filepath = "src/main/resources/data/big_input.txt";

    public static void main(String[] args) throws ReaderException {
        TextReader reader = new TextReader();
        String text = reader.read(filepath);
        System.out.print("input text:                             \t");
        System.out.println(text);
        CaesarEncryptor caesarEncryptor = new CaesarEncryptor('а','я');
        String encryptedText = caesarEncryptor.encrypt(text, 3);
        System.out.print("encrypted with Caesar algorithm:        \t");
        System.out.println(encryptedText);
        encryptedText = caesarEncryptor.decrypt(encryptedText, 3);
        System.out.print("decrypted back with Caesar algorithm:   \t");
        System.out.println(encryptedText);

        VigenereEncryptor vigenereEncryptor = new VigenereEncryptor('а','я');
        encryptedText = vigenereEncryptor.encrypt(text, 3, "лемон");
        System.out.print("encrypted with Vigenere algorithm:      \t");
        System.out.println(encryptedText);
        encryptedText = vigenereEncryptor.decrypt(encryptedText, 3, "лемон");
        System.out.print("decrypted back with Vigenere algorithm: \t");
        System.out.println(encryptedText);


        String big_text = reader.read(alice_filepath);
        System.out.print("input text:                             \t");
        System.out.println(big_text);
        caesarEncryptor = new CaesarEncryptor((char)1,(char)1400);
        encryptedText = caesarEncryptor.encrypt(big_text, 3);
        System.out.print("encrypted with Caesar algorithm:        \t");
        System.out.println(encryptedText);
        encryptedText = caesarEncryptor.decrypt(encryptedText, 3);
        System.out.print("decrypted back with Caesar algorithm:   \t");
        System.out.println(encryptedText);

        vigenereEncryptor = new VigenereEncryptor((char)1,(char)5000);
        encryptedText = vigenereEncryptor.encrypt(big_text, 3, "лемон");
        System.out.print("encrypted with Vigenere algorithm:      \t");
        System.out.println(encryptedText);
        encryptedText = vigenereEncryptor.decrypt(encryptedText, 3, "лемон");
        System.out.print("decrypted back with Vigenere algorithm: \t");
        System.out.println(encryptedText);

    }
}
