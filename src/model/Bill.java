package model;

import java.util.Date;
import java.util.List;

public class Bill {
	private long id;
	private String fullName;
	private String tel;
	private Date dated;
	private int total;
	private List<BillDetail> details;
	public Bill(long id, String fullName, String tel) {
		this(id, fullName, tel, null, 0);
	}
	public Bill(long id, String fullName, String tel, Date dated, int total) {
		this.id = id;
		this.fullName = fullName;
		this.tel = tel;
		this.dated = dated;
		this.total = total;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public List<BillDetail> getDetails() {
		return details;
	}
	public void setDetails(List<BillDetail> details) {
		this.details = details;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
