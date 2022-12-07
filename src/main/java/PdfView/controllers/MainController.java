package PdfView.controllers;

import java.io.IOException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.itextpdf.text.DocumentException;

import PdfView.UserPdfExporter;
import PdfView.dao.LogRepository;
import PdfView.dao.PersonRepository;
import PdfView.entities.Log;
import PdfView.entities.Person;

import java.time.format.DateTimeFormatter; 
@Controller
public class MainController {
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private LogRepository logRepo;
	
	@GetMapping("/users")
	public String userFunc() {
		return "home";
	}	
	
	@GetMapping("/home")
	public String Home() {
		return "show";
	}
	
	@PostMapping("/users/export/pdf")
	public String exportPdf(HttpServletResponse response,@RequestParam("varName") String name,
			@RequestParam("timems") String t,@RequestParam("time1") String time1,@RequestParam("time2") String time2)throws DocumentException, IOException {
		System.out.println("Generating pdf"+name); 	
		response.setContentType("application/pdf");
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	        LocalDateTime now=LocalDateTime.now();
	        String currentDateTime = dateFormatter.format(now);
	          
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
//		Iterable<Log> it_logs=this.logRepo.findAll();
//		List<Log> logs=new ArrayList<>();
//		it_logs.forEach(logs::add);
//	        double time=Double.parseDouble(t);
//	        System.out.println(time);
	    Set<Log> l=this.logRepo.findBetweenTimestringAndTimeString(time1, time2);
	    System.out.println(l);
	    List<Log> logs=new ArrayList<>(l);
		int n=logs.size();
		UserPdfExporter exporter=new UserPdfExporter(logs,n);
		exporter.export(response);
		return "redirect:/show";
		
	}
	
}
