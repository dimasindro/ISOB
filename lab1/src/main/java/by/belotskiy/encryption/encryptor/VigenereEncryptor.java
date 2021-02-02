package by.belotskiy.encryption.encryptor;

public class VigenereEncryptor {

    public CaesarEncryptor caesarEncryptor;

    public VigenereEncryptor(char firstChar, char lastChar){
        caesarEncryptor = new CaesarEncryptor(firstChar, lastChar);
    }

    public String encrypt(String text, int shift, String keyWord) {
        final int CHAR_INDEX_SHIFT = caesarEncryptor.firstChar;
        final int ALPHABET_SIZE = caesarEncryptor.lastChar - caesarEncryptor.firstChar + 1;
        final int KEY_WORD_SIZE = keyWord.length();
        StringBuilder encryptedText = new StringBuilder();
        int i = 1;
        for(char ch : text.toCharArray()){
            if((ch >= caesarEncryptor.firstChar && ch <= caesarEncryptor.lastChar)){
                int kerCharIndex = i % KEY_WORD_SIZE;
                int key = keyWord.charAt(kerCharIndex) - CHAR_INDEX_SHIFT;
                ch -= CHAR_INDEX_SHIFT;
                ch += shift * key;
                ch %= ALPHABET_SIZE;
                ch += CHAR_INDEX_SHIFT;
            }
            encryptedText.append(ch);
            i++;
        }
        return encryptedText.toString();
    }

    public String decrypt(String text, int shift, String keyWord) {
        return encrypt(text, -shift, keyWord);
    }
}
