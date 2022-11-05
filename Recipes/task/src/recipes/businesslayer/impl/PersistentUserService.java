package recipes.businesslayer.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipes.businesslayer.User;
import recipes.businesslayer.UserService;
import recipes.persistance.CrudUserRepository;

@Service
public class PersistentUserService implements UserService {

    private final CrudUserRepository crudUserRepository;
    private final PasswordEncoder encoder;

    public PersistentUserService(CrudUserRepository crudUserRepository, PasswordEncoder encoder) {
        this.crudUserRepository = crudUserRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return crudUserRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public void createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        crudUserRepository.save(user);
    }

    @Override
    public boolean isUserExists(String email) {
        return crudUserRepository.existsUserByEmail(email);
    }
}
