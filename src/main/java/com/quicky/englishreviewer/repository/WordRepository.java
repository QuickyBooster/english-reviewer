package com.quicky.englishreviewer.repository;

import com.quicky.englishreviewer.model.Word;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;


public interface WordRepository extends ListCrudRepository<Word,String> {

    List<Word> findWordByWordiContains(String key)  ;

}
