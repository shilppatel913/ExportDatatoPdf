package PdfView.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import PdfView.entities.Log;

public interface LogRepository extends CrudRepository<Log,Integer> {
		
	//write all the custom queries
	
	//1) get the data
	public Set<Log> findByVarName(String name);
	public Set<Log> findByTimems(double time);
	
	@Query(value = "select *from log1 where time_string between ?1 and ?2"
			,nativeQuery = true)
	public Set<Log> findBetweenTimestringAndTimeString(String time1,String time2);
//	
//	@Query(value="select *from log1",nativeQuery = true)
//	public Set<Log> getAllData();
}
