package PdfView.entities;

import javax.persistence.Column;
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
	@Column(name = "var_name")
	private String varName;
	@Column(name = "time_string")
	private String timeString;
	@Column(name = "var_value")
	private float varValue;
	@Column(name = "validity")
	private int validity;
	@Column(name = "time_ms")
	private double timems;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public float getVarValue() {
		return varValue;
	}
	public void setVarValue(float varValue) {
		this.varValue = varValue;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public double getTime_ms() {
		return timems;
	}
	public void setTime_ms(double time_ms) {
		this.timems = time_ms;
	}
	public Log(String varName, String timeString, float varValue, int validity, double time_ms) {
		super();
		this.varName = varName;
		this.timeString = timeString;
		this.varValue = varValue;
		this.validity = validity;
		this.timems = time_ms;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
