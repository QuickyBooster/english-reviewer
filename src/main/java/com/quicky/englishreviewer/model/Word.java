package com.quicky.englishreviewer.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public record Word(
        @Id
        Integer id,
        String wordi,
        Type type,
        String meanen,
        String meanvi,
        String spellingen,
        String spellingus,
        String example,
        String urlen,
        String urlus
) {
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Word)) return false;
                Word word = (Word) o;
                return  wordi.equals(word.wordi) &&
                        type == word.type &&
                        Objects.equals(meanen, word.meanen) &&
                        Objects.equals(meanvi, word.meanvi) &&
                        Objects.equals(spellingen, word.spellingen) &&
                        Objects.equals(spellingus, word.spellingus) &&
                        Objects.equals(example, word.example) &&
                        Objects.equals(urlen, word.urlen) &&
                        Objects.equals(urlus, word.urlus);
        }

        @Override
        public int hashCode() {
                return Objects.hash( wordi, type, meanen, meanvi, spellingen, spellingus, example, urlen, urlus);
        }

}
