package com.quicky.englishreviewer.data.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quicky.englishreviewer.data.model.Vocabulary;
import com.quicky.englishreviewer.data.repository.VocabularyRepository;
import com.quicky.englishreviewer.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final VocabularyRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(VocabularyRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/data.json")) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Vocabulary>>() {
                }));
            }
        }

    }
}

