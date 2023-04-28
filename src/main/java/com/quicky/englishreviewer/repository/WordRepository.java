package com.quicky.englishreviewer.repository;

import com.quicky.englishreviewer.model.Word;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WordRepository extends ListCrudRepository<Word,String> {

//    List<Word> findByWordiContaining(String key);
    List<Word> findWordByWordiContains(String key)  ;
}
