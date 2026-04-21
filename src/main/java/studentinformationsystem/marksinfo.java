package studentinformationsystem;

public class marksinfo {
	private int rollno;
	private String subid;
	private int marks;
	private String examtype;
	
	public marksinfo() {
		
	}
	public marksinfo(int rollno,String subid,int marks) {
		this.rollno=rollno;
		this.subid=subid;
		this.marks=marks;
	}
	
	public int getrollno() {
		return rollno;
	}
	public void setrollno( int rollno) {
		this.rollno=rollno;
	}
	public String getsubid() {
		return subid;
	}
	public void setsubid(String subid) {
		this.subid=subid;
	}
	public int getmarks() {
		return marks;
	}
	public void setmarks(int marks) {
		this.marks=marks;
	}
	public String getexamtype() {
	    return examtype;
	}

	public void setexamtype(String examtype) {
	    this.examtype = examtype;
	}
	public String toString() {
	   return "marks [rollno=" + rollno + 
	           ", subid=" + subid + 
	           ", marks=" + marks + "]";
	           
	}

}
