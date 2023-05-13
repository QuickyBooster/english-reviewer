package com.quicky.englishreviewer.data.repository;

import com.quicky.englishreviewer.data.model.Vocabulary;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;


public interface VocabularyRepository extends ListCrudRepository<Vocabulary,String> {

    List<Vocabulary> findWordByWordContains(String key)  ;

}
