package PdfView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import PdfView.dao.PersonRepository;


@SpringBootApplication
public class PdfViewApplication  {

	@Autowired
	private PersonRepository personRepo;
	public static void main(String[] args) {
		SpringApplication.run(PdfViewApplication.class, args);
		System.out.println("application has started running"); 
	}
	

}
