package org.codelabor.example.validation.dao;

import org.codelabor.example.validation.dto.PersonDto;

public interface PersonDao {
	int insertPerson(PersonDto personDto);
}
