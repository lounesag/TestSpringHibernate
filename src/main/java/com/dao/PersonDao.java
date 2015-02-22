package com.dao;

import java.util.List;

import com.model.Person;

public interface PersonDao {

	 /*
     * CREATE and UPDATE
     */
    public void savePerson(Person person); // create and update

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
