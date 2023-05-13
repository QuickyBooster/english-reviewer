package com.quicky.englishreviewer.data.controller;

import com.quicky.englishreviewer.data.model.Vocabulary;
import com.quicky.englishreviewer.data.repository.VocabularyRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/home")
@RestController
public class AppController {

    private final VocabularyRepository repository;

    public AppController(VocabularyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Vocabulary> findAll() {
        return repository.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody Vocabulary newWord) {
        if (repository.findWordByWordContains(newWord.getWord()).size()!=0) {
            for (Vocabulary word : repository.findWordByWordContains(newWord.getWord())) {
                if (word.getWord().equals(newWord.getWord())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "already has one");
                }
            }
        }
        repository.save(newWord);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{key}")
    public void delete(@Valid @PathVariable String key) {
        if(repository.findWordByWordContains(key).size()==0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        for (Vocabulary word : repository.findWordByWordContains(key)) {
            if (word.getWord().equals(key)) {
                repository.delete(word);
                break;
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/change/{key}")
    public void update(@Valid @RequestBody Vocabulary newWord, @PathVariable String key) {
        if (repository.findWordByWordContains(key).size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "word not found");
        }
        for (Vocabulary word : repository.findWordByWordContains(key)) {
            if (word.getWord().equals(newWord.getWord()) || word.getWord().equals(key)) {
                repository.delete(word);
                break;
            }
        }
        repository.save(newWord);
    }

}
