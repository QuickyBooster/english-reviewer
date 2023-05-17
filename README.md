Overview: Personal project using Java. This project is about storage English word like a dictionary. I am continuing to scale it up and use more technologies such as Spring Security, as well as building the front-end.

# ENGLISH-REVIEWER

## + DESIRED FUNCTION
- give a random word, if answered true, remove it from the list, else continue with 
the next word, till a random time, meet that word again
- add word to the list
- give a name of the list, maybe give a tag to a word, pick the tag, we can 
review all the words have that tag
- delete selected word if you want
- view the word list, by tag, by ascending, descending,... and have some options
such as edit, delete
- add new word 
- can check the word with oxford dictionary or google translate
- account

## + DATA
### Vocabulary
- [Long] [key] id
- [String] word
- [enum] type(n,v,adj,adv)
- [String] the meaning in english & vietnamese
- [String] the spelling
- [String] examples using word (it connects with the meaning)
- [String] link media us
- [String] link media en
- [Set\<VocabularyCollection>] collections
### User
- [Long] [key] id
- [String] username
- [String] password (encrypted)
- [String] roles
- [Set\<VocabularyCollection>] collections
### VocabularyCollection
- [Long] [key] id
- [User] user
- [Set\<Vocabulary>] setVocabulary
### VocabInCollection
- [Long] vocabulary_id
- [Long] vocabularycollection_id
### VocabularyRepository implement ListCrudRepository<Word,Long>
### UserRepository implement ListCrudRepository<User,Long>
### VocabularyCollectionRepository implement ListCrudRepository<VocabularyCollection,Long>
### SecurityUser implement UserDetails
### [Enum] Type
- NOUN
- VERB
- ADJECTIVE
- ADVERB




	
