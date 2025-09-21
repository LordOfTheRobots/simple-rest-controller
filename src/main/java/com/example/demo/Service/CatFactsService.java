package com.example.demo.Service;

import com.example.demo.dto.CatFact;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatFactsService {
    @Autowired
    private JsonMapperService mapperService;
    public CatFact getCatFact(){
        final String uri = "https://meowfacts.herokuapp.com/";
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject(uri, String.class);
        Optional<CatFact> facts = mapperService.parseJson(body, CatFact.class);
        System.out.println(facts.isPresent());
        return facts.orElse(new CatFact(new ArrayList<String>()));
    }
}
