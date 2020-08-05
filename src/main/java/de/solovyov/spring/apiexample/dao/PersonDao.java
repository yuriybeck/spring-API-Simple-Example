package de.solovyov.spring.apiexample.dao;

import de.solovyov.spring.apiexample.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author yuriysolovyov
 */
public interface PersonDao {

    int insertPerson(UUID id, Person person);
    
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return this.insertPerson(id, person);
    }
    
    List<Person> selectAllPeople();
    
    Optional<Person> selectPersonById(UUID id);
    
    int deletPersonById(UUID id);
    
    int updatePersonById(UUID id, Person person);
}
