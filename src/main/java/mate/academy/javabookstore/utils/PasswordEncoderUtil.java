package mate.academy.javabookstore.utils;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderUtil {
    private final PasswordEncoder passwordEncoder;

    public String encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return encodedPassword;
    }
}
