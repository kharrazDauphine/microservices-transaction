package service.business;

import java.util.Date;

public class Rate {
	
	private long id;
	private String src;
	private String dst;
	private Date date;
	private double taux;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	@Override
	public String toString() {
		return "Rate [id=" + id + ", src=" + src + ", dst=" + dst + ", date=" + date + ", taux=" + taux + "]";
	}
	
	
	
}
