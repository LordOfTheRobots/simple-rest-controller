package com.example.demo.Controller;

import com.example.demo.Model.UserObj;
import com.example.demo.Service.CatFactsService;
import com.example.demo.Service.JsonMapperService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MainPageController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final CatFactsService factsService;
    @Autowired
    private final JsonMapperService jsonMapperService;

    @GetMapping("/{userId}")
    public String mainPage(@PathVariable Integer userId) throws JsonProcessingException {
        return jsonMapperService.makeJson(userService.getUser(userId).orElse(new UserObj()));
    }

    @PostMapping("/save")
    public ResponseEntity<String> enterName(@RequestBody UserRequest userRequest) throws JsonProcessingException {
        UserObj userEntity = new UserObj();
        userEntity.setName(userRequest.getName());
        System.out.println("getting fact");
        String fact = factsService.getCatFact().getData();
        userEntity.setFact(fact);
        userService.saveUser(userEntity);
        return ResponseEntity.ok("Имя " + userRequest.getName() + " успешно сохранено c фактом " + fact);
    }
}