package com.chatmessenger.backend.chatmessenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatmessenger.backend.chatmessenger.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
