package com.teaCloud.repos;

import com.teaCloud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public UserEntity findByMemberIDAndPassword(Long id, String Password);
    public Optional<User>  findByEmail(String email);
}
