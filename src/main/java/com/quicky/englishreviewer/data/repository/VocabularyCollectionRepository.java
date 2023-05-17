package com.quicky.englishreviewer.data.repository;

import com.quicky.englishreviewer.data.model.VocabularyCollection;
import org.springframework.data.repository.ListCrudRepository;

public interface VocabularyCollectionRepository extends ListCrudRepository<VocabularyCollection,Long> {
}
