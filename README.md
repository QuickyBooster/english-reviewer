Overview: Personal project using Java. This project is about storage English word like a dictionary.

# ENGLISH-REVIEWER

## + FUNCTION
- Storage vocabulary in a collection that belong to an only user
- Authentication & authorization by using Spring Security with JPA
- Some technologies: JPA, JDBC, OAuth2, Hibernate

## + DATA
### `Vocabulary`
- [Long] [key] `id`
- [String] `word`
- [Type] `type`
- [String] `meanvi`
- [String] `meanus`
- [String] `spelling`
- [String] `examples`
- [String] `linkus`
- [String] `linken`
- [Set\<VocabularyCollection>] `collections`
### `User`
- [Long] [key] `id`
- [String] `username`
- [String] `password` (encrypted)
- [String] `roles`
- [Set\<VocabularyCollection>] `collections`
### `VocabularyCollection`
- [Long] [key] `id`
- [User] `user`
- [Set\<Vocabulary>] `setVocabulary`
### `VocabInCollection`
- [Long] `vocabulary_id`
- [Long] `vocabularycollection_id`
### `VocabularyRepository` implement ListCrudRepository<Word,Long>
### `UserRepository` implement ListCrudRepository<User,Long>
### `VocabularyCollectionRepository` implement ListCrudRepository<VocabularyCollection,Long>
### `SecurityUser` implement UserDetails
### [Enum] `Type`
- `NOUN`
- `VERB`
- `ADJECTIVE`
- `ADVERB`




	
