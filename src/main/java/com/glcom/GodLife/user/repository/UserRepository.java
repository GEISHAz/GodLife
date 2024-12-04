package com.glcom.GodLife.user.repository;


import com.glcom.GodLife.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUserEmail(String userEmail);
    boolean existsByNickName(String nickName);
}
