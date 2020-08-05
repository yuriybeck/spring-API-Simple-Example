package de.solovyov.spring.apiexample.dao;

import de.solovyov.spring.apiexample.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yuriysolovyov
 */
@Repository("mysqlDao")
public class PersonDataAccessService implements PersonDao {
    
    private static List<Person> DB = new ArrayList<>() ;

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person ->  person.getId().equals(id))
                .findFirst() ;
    }

    @Override
    public int deletPersonById(UUID id) {
        Optional<Person> foundPerson = this.selectPersonById(id);
        if (foundPerson.isPresent()) {
            return 0;
        }
        
        DB.remove(foundPerson);
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) {
        return this.selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
