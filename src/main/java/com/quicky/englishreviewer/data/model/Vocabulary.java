package com.quicky.englishreviewer.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
    @GeneratedValue
    @Id
    Long id;
    String word;
    Type type;
    String meanen;
    String meanvi;
    String spellingen;
    String spellingus;
    String example;
    String urlen;
    String urlus;

    public Vocabulary(String word, Type type, String meanen, String meanvi, String spellingen, String spellingus, String example, String urlen, String urlus) {
        this.word = word;
        this.type = type;
        this.meanen = meanen;
        this.meanvi = meanvi;
        this.spellingen = spellingen;
        this.spellingus = spellingus;
        this.example = example;
        this.urlen = urlen;
        this.urlus = urlus;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", type=" + type +
                ", meanen='" + meanen + '\'' +
                ", meanvi='" + meanvi + '\'' +
                ", spellingen='" + spellingen + '\'' +
                ", spellingus='" + spellingus + '\'' +
                ", example='" + example + '\'' +
                ", urlen='" + urlen + '\'' +
                ", urlus='" + urlus + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String vocabulary) {
        this.word = vocabulary;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMeanen() {
        return meanen;
    }

    public void setMeanen(String meanen) {
        this.meanen = meanen;
    }

    public String getMeanvi() {
        return meanvi;
    }

    public void setMeanvi(String meanvi) {
        this.meanvi = meanvi;
    }

    public String getSpellingen() {
        return spellingen;
    }

    public void setSpellingen(String spellingen) {
        this.spellingen = spellingen;
    }

    public String getSpellingus() {
        return spellingus;
    }

    public void setSpellingus(String spellingus) {
        this.spellingus = spellingus;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getUrlen() {
        return urlen;
    }

    public void setUrlen(String urlen) {
        this.urlen = urlen;
    }

    public String getUrlus() {
        return urlus;
    }

    public void setUrlus(String urlus) {
        this.urlus = urlus;
    }

    public Vocabulary() {
    }
}
