package mate.academy.javabookstore.security;

import lombok.RequiredArgsConstructor;
import mate.academy.javabookstore.repository.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .map(SecurityUserAdapter::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Can't find user with email: " + username));
    }
}
