package PdfView.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PdfView.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	@Query(value="select * from person",nativeQuery=true)
	public List<Person> getAllPersons();
	
	
	//let us write a query to get person by his/her name
	@Query(value="select * from person where p_city=?1",nativeQuery=true)
	public List<Person> getPersonByName(String name);
}
