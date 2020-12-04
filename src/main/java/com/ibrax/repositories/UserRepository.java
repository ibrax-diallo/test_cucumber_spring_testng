package com.ibrax.repositories;

import com.ibrax.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
    boolean existsByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
