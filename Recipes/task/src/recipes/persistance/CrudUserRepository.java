package recipes.persistance;

import org.springframework.data.repository.CrudRepository;
import recipes.businesslayer.User;

import java.util.Optional;

public interface CrudUserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    boolean existsUserByEmail(String email);
}
