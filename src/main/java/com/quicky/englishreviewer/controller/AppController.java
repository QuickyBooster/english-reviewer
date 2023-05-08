package com.quicky.englishreviewer.controller;

import com.quicky.englishreviewer.model.Word;
import com.quicky.englishreviewer.repository.WordRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/home")
@RestController
public class AppController {

    private final WordRepository repository;

    public AppController(WordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Word> findAll() {
        return repository.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody Word newWord) {
        if (repository.findWordByWordiContains(newWord.wordi()).size()!=0) {
            for (Word word : repository.findWordByWordiContains(newWord.wordi())) {
                if (word.wordi().equals(newWord.wordi())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "already has one");
                }
            }
        }
        repository.save(newWord);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{key}")
    public void delete(@Valid @PathVariable String key) {
        if(repository.findWordByWordiContains(key).size()==0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        for (Word word : repository.findWordByWordiContains(key)) {
            if (word.wordi().equals(key)) {
                repository.delete(word);
                break;
            }
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/change/{key}")
    public void update(@Valid @RequestBody Word newWord, @PathVariable String key) {
        if (repository.findWordByWordiContains(key).size()==0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "word not found");
        }
        for (Word word : repository.findWordByWordiContains(key)) {
            if (word.wordi().equals(newWord.wordi()) || word.wordi().equals(key)) {
                repository.delete(word);
                break;
            }
        }
        repository.save(newWord);
    }

}
