package com.service;

import java.util.List;

import com.model.Person;

public interface PersonService {
	 /*
     * CREATE and UPDATE
     */
    public void savePerson(Person book);

    /*
     * READ
     */
    public List<Person> listPersons();
    public Person getPerson(Long id);

    /*
     * DELETE
     */
    public void deletePerson(Long id);

}
