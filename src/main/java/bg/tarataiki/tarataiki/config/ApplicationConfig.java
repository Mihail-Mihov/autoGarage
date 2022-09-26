package bg.tarataiki.tarataiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.text.PasswordView;
import java.net.PasswordAuthentication;

@Configuration
public class ApplicationConfig {

    public PasswordEncoder passwordEncoder(){
        return new Argon2PasswordEncoder(); //pbkdf2
    }
}
