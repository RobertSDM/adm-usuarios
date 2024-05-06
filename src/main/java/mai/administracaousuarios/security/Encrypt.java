package mai.administracaousuarios.security;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.ArrayList;

public class Encrypt {
    public static ArrayList<String> encryptPassword(String password){
        String salt = KeyGenerators.string().generateKey();
        TextEncryptor textEncryptor = Encryptors.text("your_password", salt);
        String encryptedPass = textEncryptor.encrypt(password);

        ArrayList<String> _return = new ArrayList<String>(2);
        _return.add(encryptedPass);
        _return.add(salt);

        return _return;
    }

    public static Boolean validatePassword(String sentPassword, String salt, String originalPassword){
        String encryptedPass = Encryptors.text(sentPassword, salt).toString();

        return encryptedPass.equals(originalPassword);
    }
}
