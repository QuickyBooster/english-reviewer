Overview: Personal project using Java. This project is about storage English word like a dictionary. I am continuing to scale it up and use more technologies such as Spring Security, as well as building the front-end.

		#ENGLISH-REVIEWER

## +functions
-give a random word, if answered true, remove it from the list, else continue with 
the next word, till a random time, meet that word again
-add word to the list
-give a name of the list, maybe give a tag to a word, pick the tag, we can 
review all the words have that tag
-delete selected word if you want
-view the word list, by tag, by ascending, descending,... and have some options
such as edit, delete
-add new word 
-can check the word with oxford dictionary or google translate
-account

## +data
	### Vocabulary
-[Long][key] id
-[String][key] word
=[enum] type(n,v,adj,adv)
-[String] the meaning in english & vietnamese
-[String] the spelling
-[String] examples using word (it connects with the meaning)
-[String] link media us
-[String] link media en
=[Long] idUser
	### User
-[Long][key] id
-[String] username
-[String] password (encrypted)
-[String] roles
	### VocabularyRepository implement ListCrudRepository<Word,String>
	### SecurityUser implement UserDetails
	### Enum Type
NOUN, VERB, ADJECTIVE, ADVERB

#### ("=" means foreign key)



	
