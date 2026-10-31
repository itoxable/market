package com.doneby.market.repository;

import com.doneby.market.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByEmail(String email);

    boolean existsByEmail(String email);
}
