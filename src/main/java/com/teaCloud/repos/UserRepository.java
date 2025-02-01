package com.teaCloud.repos;

import com.teaCloud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public UserEntity findBymemberIdAndPassword(Long id, String Password);
}
