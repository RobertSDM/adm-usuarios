package mai.administracaousuarios.project.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.ArrayList;

public class Encrypt {
    public static ArrayList<String> encryptPassword(String password){
        String salt = KeyGenerators.string().generateKey();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPass = encoder.encode(password + salt);

        ArrayList<String> _return = new ArrayList<String>(2);
        _return.add(encryptedPass);
        _return.add(salt);

        return _return;
    }

    public static Boolean validatePassword(String sentPassword, String salt, String originalPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(sentPassword + salt, originalPassword);
    }
}
