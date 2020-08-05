package de.solovyov.spring.apiexample.service;

import de.solovyov.spring.apiexample.dao.PersonDao;
import de.solovyov.spring.apiexample.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuriysolovyov
 */
@Service
public class PersonService {
    
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("mysqlDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    
    public int addPerson(Person person) {
        return this.personDao.insertPerson(person);
    }
    
    public List<Person> getAllPeople() {
        return this.personDao.selectAllPeople(); 
    }
    
    public Optional<Person> getPersonById(UUID id) {
        return this.personDao.selectPersonById(id);
    }
    
    public int deletePerson(UUID id) {
        return this.personDao.deletPersonById(id);
    }
    
    public int updatePerson(UUID id, Person person) {
        return this.personDao.updatePersonById(id, person);
    }
}
