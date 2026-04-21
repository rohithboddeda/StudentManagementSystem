package studentinformationsystem;

public class studentinfo {
	private int rollno;
	private String sname;
	private String sgender;
	private int sage;
	
	public studentinfo() {
		
	}
	public studentinfo(int rollno,String sname,String sgender,int sage) {
		this.rollno=rollno;
		this.sname=sname;
		this.sgender=sgender;
		this.sage=sage;
	}
	public int getrollno() {
		return rollno;
	}
	public void setrollno(int rollno) {
		this.rollno=rollno;
	}
	public String getsname() {
		return sname;
	}
	public void setsname(String sname) {
		this.sname=sname;
	}
	public String getsgender() {
		return sgender;
	}
	public void setsgender(String sgender) {
		this.sgender=sgender;
	}
	public int getsage() {
		return sage;
	}
	public void setsage(int sage) {
		this.sage=sage;
	}
	public String toString() {
        return "Studentinfo [=rollno" + rollno +  ", sname=" + sname + ", sgender=" + sgender + ", sage=" + sage + "]";
    }
	public static boolean isEmpty() {
		
		return false;
	}
	

}
