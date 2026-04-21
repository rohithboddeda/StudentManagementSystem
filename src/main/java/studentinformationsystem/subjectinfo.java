package studentinformationsystem;

public class subjectinfo {
	private String subid;
	private String subname;
	private int maxmarks;
	private int passmarks;
	
	public subjectinfo() {
		
	}
	public subjectinfo(String subid,String subname,int maxmarks,int passmarks) {
		this.subid=subid;
		this.subname=subname;
		this.maxmarks=maxmarks;
		this.passmarks=passmarks;
	}
	public String getsubid() {
		return subid;
	}
	public void setsubid(String subid) {
		this.subid=subid;
	}
	public String getsubname() {
		return subname;
		
	}
	public void  setsubname(String subname) {
		this.subname=subname;
	}
	public int getmaxmarks() {
		return maxmarks;
	}
	public void setmaxmarks(int maxmarks) {
		this.maxmarks=maxmarks;
	}
	public int getpassmarks() {
		return passmarks;
	}
	public void setpassmarks(int passmarks) {
		this.passmarks=passmarks;
	}
	public String toString() {
	    return "Subject [subid=" + subid + 
	           ", subname=" + subname + 
	           ", maxmarks=" + maxmarks + 
	           ", passmarks=" + passmarks + "]";
	}

}
