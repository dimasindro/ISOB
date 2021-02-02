package by.belotskiy.encryption.encryptor;

public class CaesarEncryptor {

    protected char firstChar;
    protected char lastChar;

    public CaesarEncryptor(char firstChar, char lastChar){
        if(firstChar > lastChar){
            char temp = firstChar;
            firstChar = lastChar;
            lastChar = temp;
        }
        this.firstChar = firstChar;
        this.lastChar = lastChar;
    }

    public String encrypt(String text, int shift) {
        int CHAR_INDEX_SHIFT = firstChar;
        int ALPHABET_SIZE = lastChar - firstChar + 1;

        StringBuilder encryptedText = new StringBuilder();
        for(char ch : text.toCharArray()){
            if((ch >= firstChar && ch <= lastChar)){
                ch -= CHAR_INDEX_SHIFT;
                ch += shift;
                ch %= ALPHABET_SIZE;
                ch += CHAR_INDEX_SHIFT;
            }
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }
    public String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }
}
