package PdfView.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOG1")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String VarName;
	private String TimeString;
	private float VarValue;
	private int Validity;
	private float Time_ms;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVarName() {
		return VarName;
	}
	public void setVarName(String varName) {
		VarName = varName;
	}
	public String getTimeString() {
		return TimeString;
	}
	public void setTimeString(String timeString) {
		TimeString = timeString;
	}
	public float getVarValue() {
		return VarValue;
	}
	public void setVarValue(float varValue) {
		VarValue = varValue;
	}
	public int getValidity() {
		return Validity;
	}
	public void setValidity(int validity) {
		Validity = validity;
	}
	public float getTime_ms() {
		return Time_ms;
	}
	public void setTime_ms(float time_ms) {
		Time_ms = time_ms;
	}
	public Log(String varName, String timeString, float varValue, int validity, float time_ms) {
		super();
		VarName = varName;
		TimeString = timeString;
		VarValue = varValue;
		Validity = validity;
		Time_ms = time_ms;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
