package com.quicky.englishreviewer.data.repository;

import com.quicky.englishreviewer.data.model.Vocabulary;
import org.springframework.data.repository.ListCrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface VocabularyRepository extends ListCrudRepository<Vocabulary,String> {

    Optional<Vocabulary> findById(Long id);

    Optional<Vocabulary> findVocabulariesByWordContains(String s);
}
