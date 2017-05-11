# Knowledge Graph Evaluation

# 1. User Judgments
## CRUD
use `PersonService` and `QueryService` for CRUD operations
each service need a Repository. you can use MongoDB repository implementations or your own implemetaion of repository intefaces
```java
{
    PersonRepo personRepo=new MongoPersonRepo(dbName, collectionName, host, port);
    PersonService personService=new PersonServiceImpl(personRepo);
    List<Person> allPersons= personService.getAllPerson();
    ...
 }
```
## query
use `QueryService.getUnreadQueryByPersonId(personId)` to get an unread query for a person
run query and show system response to user.
create a `UserResponse` object for each query and persist using `UserResponseService`

# 2. Evaluation
TODO

