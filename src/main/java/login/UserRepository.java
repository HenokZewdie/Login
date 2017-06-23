package login;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Meeliana on 6/22/2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUName(String name);
}
