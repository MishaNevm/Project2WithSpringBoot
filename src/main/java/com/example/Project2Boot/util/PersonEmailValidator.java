package com.example.Project2Boot.util;


import com.example.Project2Boot.models.Person;
import com.example.Project2Boot.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class PersonEmailValidator implements Validator {

    private final PersonService personService;

    public PersonEmailValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        List<Person> personList = personService.findAllByEmail(person.getEmail());
        System.out.println(personList);
        if (!personList.isEmpty() && !personList.get(0).getEmail().equals(person.getEmail())) {
            errors.rejectValue("email", "", "This email is already in use");
        }
    }
}
