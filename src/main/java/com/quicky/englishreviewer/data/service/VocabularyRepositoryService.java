package com.quicky.englishreviewer.data.service;

import com.quicky.englishreviewer.data.model.Vocabulary;
import com.quicky.englishreviewer.data.repository.VocabularyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VocabularyRepositoryService {
    private final VocabularyRepository volRepos;

    public VocabularyRepositoryService(VocabularyRepository volRepos) {
        this.volRepos = volRepos;
    }

    public Iterable<Vocabulary> findAll() {
        return volRepos.findAll();
    }

    public Optional<Vocabulary> findById(Long id) {
        return volRepos.findById(id);
    }

    public Optional<Vocabulary> findByWord(String s){
        return volRepos.findVocabulariesByWordContains(s);
    }

    public Vocabulary save(Vocabulary vol) {
        return volRepos.save(vol);
    }

    public void delete(Vocabulary vol) {
        volRepos.delete(vol);
    }

    public boolean isRepeated(Vocabulary word){
        return volRepos.findVocabulariesByWordContains(word.getWord()).stream().toList().size()!=0;
    }
}
