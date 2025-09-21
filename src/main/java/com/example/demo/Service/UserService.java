package com.example.demo.Service;

import com.example.demo.Model.UserObj;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository repository;

    public void saveUser(UserObj userEntity){
        repository.save(userEntity);
    }

    public Optional<UserObj> getUser(Integer id){
        return repository.findById(id);
    }
}
