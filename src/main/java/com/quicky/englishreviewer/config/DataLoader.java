package com.quicky.englishreviewer.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quicky.englishreviewer.model.Word;
import com.quicky.englishreviewer.repository.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final WordRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(WordRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/data.json")) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Word>>() {
                }));
            }
        }
    }
}

