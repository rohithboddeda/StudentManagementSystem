package studentinformationsystem;
import java.util.*;
import studentinformationsystem.studentinfo;
import studentinformationsystem.subjectinfo;
import studentinformationsystem.marksinfo;

public interface dao {
	void insertstudent(studentinfo s) throws Exception;
	void updatestudent(studentinfo s) throws Exception;
	void deleteStudent(studentinfo s3)throws Exception;
    studentinfo getStudentByrollno(studentinfo s)throws Exception;
    List<studentinfo> getAllStudents() throws Exception;
    
    void insertsubjects(subjectinfo s1) throws Exception;
    void updatesubjects(subjectinfo s2) throws Exception;
    void deletesubjects(subjectinfo s3) throws Exception;
    subjectinfo getsubjectBysubid(subjectinfo s4) throws Exception;
    List<subjectinfo> getAllSubjects() throws Exception;
    
    void insertmarks(marksinfo m)throws Exception;
    void updatemarks(marksinfo m) throws Exception;
    List<marksinfo> getMarksByRollNo(int rollno) throws Exception;
    
    void getstudentreport()throws Exception;
    
    void getinfowithranks()throws Exception;
    
    void get1standlastranks()throws Exception;
    
    void getfailedstudents()throws Exception;
    
    void getresult(int roll)throws Exception;

}
