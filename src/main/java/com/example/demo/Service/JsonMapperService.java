package com.example.demo.Service;

import com.example.demo.dto.CatFact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JsonMapperService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> Optional<T> parseJson(String body, Class<T> clazz) {
        try {
            T result = objectMapper.readValue(body, clazz);
            return Optional.ofNullable(result);
        } catch (JsonProcessingException e) {
            System.err.println("JSON parsing error: " + e.getMessage());
            System.err.println("Response body: " + body);
            return Optional.empty();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return Optional.empty();
        }
    }

    public String makeJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
