package PdfView;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import PdfView.entities.Log;
import PdfView.entities.Person;
public class UserPdfExporter {
	private List<Log> listPersons;
	private int rows;

	public UserPdfExporter(List<Log> listPersons,int rows) {
		super();
		this.listPersons = listPersons;
		this.rows=rows;
	}
	public void writeTableHeader(PdfPTable table) {
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(3);
		
		com.itextpdf.text.Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		cell.setPhrase(new Phrase("Id", font));
        
        table.addCell(cell);
		
		cell.setPhrase(new Phrase("VarName", font));
        
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("TimeString", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Time_ms", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Validity", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("VarValue", font));
        table.addCell(cell);
	}
	public void writeTableData(PdfPTable table) {
		for(Log p:listPersons) {
			table.addCell(String.valueOf(p.getId()));
		    table.addCell(p.getVarName());
            table.addCell(p.getTimeString());
            table.addCell(String.valueOf(p.getTime_ms()));
            table.addCell(String.valueOf(p.getValidity()));
            table.addCell(String.valueOf(p.getVarValue()));
		}
	}
	public void export(HttpServletResponse response) throws DocumentException,IOException {
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		com.itextpdf.text.Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(BaseColor.BLUE);
		Paragraph p=new Paragraph("List Of Users",font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		PdfPTable table = new PdfPTable(rows);
        table.setWidthPercentage(100f);
        float[] widths=new float[rows];
        for(int i=0;i<rows;i++) {
        	widths[i]=3.5f;
        }
        table.setWidths(widths);
        table.setSpacingBefore(4);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
		document.close();
		
	}
}
