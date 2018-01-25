package hu.karma.practice01.karmalogin.repository;

import hu.karma.practice01.karmalogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(@Param("id") int id);

    @Override
    User save(User newUser);

    User findByUsername(@Param("username") String username);
}
