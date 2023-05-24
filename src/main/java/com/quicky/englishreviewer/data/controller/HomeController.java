package com.quicky.englishreviewer.data.controller;

import com.quicky.englishreviewer.data.model.Vocabulary;
import com.quicky.englishreviewer.data.service.VocabularyRepositoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RequestMapping("/home")
@Controller
public class HomeController {

    private final VocabularyRepositoryService service;

    public HomeController(VocabularyRepositoryService service) {
        this.service = service;
    }

    @GetMapping("")
    public Iterable<Vocabulary> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String insert(@RequestBody @Valid Vocabulary newWord) {
        if (service.isRepeated(newWord)){
            for (Vocabulary word : service.findByWord(newWord.getWord()).stream().toList()) {
                if (word.getWord().equals(newWord.getWord())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "already has one");
                }
            }
        }
        service.save(newWord);
        return "redirect:/";
    }
}
