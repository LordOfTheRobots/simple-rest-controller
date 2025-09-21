package com.example.demo.Repository;

import com.example.demo.Model.UserObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserObj, Integer> {
    Optional<UserObj> findById(Integer id);
}
