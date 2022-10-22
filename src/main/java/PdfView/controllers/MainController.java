package PdfView.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.itextpdf.text.DocumentException;

import PdfView.UserPdfExporter;
import PdfView.dao.PersonRepository;
import PdfView.entities.Person;

import java.time.format.DateTimeFormatter; 
@RestController
public class MainController {
	@Autowired
	private PersonRepository personRepo;
	
	@GetMapping("/users")
	public ModelAndView userFunc() {
		ModelAndView model=new ModelAndView();
		model.setViewName("home");
		return model;
	}	
	@PostMapping("/users/export/pdf")
	public void exportPdf(HttpServletResponse response,@RequestParam("pName") String name)throws DocumentException, IOException {
		System.out.println("Generating pdf"+name); 	
		response.setContentType("application/pdf");
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	        LocalDateTime now=LocalDateTime.now();
	        String currentDateTime = dateFormatter.format(now);
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
		List<Person> persons=personRepo.getPersonByName(name);
		System.out.println(persons);
		int n=persons.size();
		UserPdfExporter exporter=new UserPdfExporter(persons,n);
		exporter.export(response);
		
		
	}
}
