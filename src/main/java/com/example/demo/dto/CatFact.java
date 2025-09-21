package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatFact {
    private List<String> data;
    public String getData(){
        return !data.isEmpty() ? data.getFirst() : null;
    }
}
