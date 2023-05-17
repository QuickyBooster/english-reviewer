package com.quicky.englishreviewer.data.model;

import com.quicky.englishreviewer.security.model.User;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "vocabularycollection")
public class VocabularyCollection {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany()
    @JoinTable(name = "vocabInCollection",
            inverseJoinColumns =  @JoinColumn(name = "vocabulary_id"),
            joinColumns = @JoinColumn(name = "vocabularycollection_id")
    )
    private Set<Vocabulary> setVocabulary = new HashSet<>();

    public VocabularyCollection() {
    }

    public void addVocabulary(Vocabulary vocabulary){
        setVocabulary.add(vocabulary);
        vocabulary.addCollection(this);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public VocabularyCollection(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterator<Vocabulary> getSetVocabulary() {
        return setVocabulary.iterator();
    }

    public void addVocabularies(Vocabulary... vocabularies) {
        for(Vocabulary vocab : vocabularies){
            this.setVocabulary.add(vocab);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
