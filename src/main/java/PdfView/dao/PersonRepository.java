package PdfView.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PdfView.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	@Query(value="SELECT [id]\r\n"
			+ "      ,[p_city]\r\n"
			+ "      ,[p_name]\r\n"
			+ "  FROM [dbo].[person]\r\n"
			+ "GO",nativeQuery=true)
	public List<Person> getAllPersons();
	
	//let us a generate an automatic query
	public List<Person> findBypName(String name);
	
	//let us write a query to get person by his/her name
	@Query(value="SELECT [id]\r\n"
			+ "      ,[p_city]\r\n"
			+ "      ,[p_name]\r\n"
			+ "  FROM [dbo].[person]\r\n"
			+ "  WHERE p_name='Shilp Patel'\r\n"
			+ "GO",nativeQuery=true)
	public List<Person> getPersonByName(String name);
}
