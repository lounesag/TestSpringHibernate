package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Person;
import com.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = { "/", "/listPersons" })
	public String listPersons(Map<String, Object> map) {

		map.put("person", new Person());
		map.put("personList", personService.listPersons());
		return map.toString();
	}

	 @RequestMapping("/get/{personId}")
     public String getPerson(@PathVariable Long personId, Map<String, Object> map) {

            Person person = personService.getPerson(personId);
            map.put("person", person);
            return map.toString();
     }

     @RequestMapping(value = "/save", method = RequestMethod.POST)
     public String savePerson(@ModelAttribute("person") Person person) {

            personService.savePerson(person);
            /*
             * Note that there is no slash "/" right after "redirect:"
             * So, it redirects to the path relative to the current path
             */
            return "ok";
     }

     @RequestMapping("/delete/{personId}")
     public String deletePerson(@PathVariable("personId") Long id) {
            personService.deletePerson(id);
            /*
             * redirects to the path relative to the current path
             */
            // return "redirect:../listBooks";

            /*
             * Note that there is the slash "/" right after "redirect:"
             * So, it redirects to the path relative to the project root path
             */
            return "delete ok";
     }
}
