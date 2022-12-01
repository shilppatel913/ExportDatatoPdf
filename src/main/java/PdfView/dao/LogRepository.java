package PdfView.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import PdfView.entities.Log;

public interface LogRepository extends CrudRepository<Log,Integer> {
		
}
