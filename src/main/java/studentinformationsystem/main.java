package studentinformationsystem;
import java.util.*;
import studentinformationsystem.*;
public class main {
	public static void main (String[]args) throws Exception {
		Scanner sc=new Scanner(System.in);
		dao d=new studaoimple();
		while(true) {
		
		System.out.println("Enter case no :");
		int caseno = sc.nextInt();
		sc.nextLine();
		
		switch(caseno) {
		
		case 1:
		
		System.out.println("enter student rollno:");
		int rollno=sc.nextInt();
		sc.nextLine();
		System.out.println("enter student name:");
		String name=sc.nextLine();
		
		System.out.println("enter student gender:");
		String gender=sc.nextLine();
		
		System.out.println("enter student age:");
		int age=sc.nextInt();
		
		studentinfo s1 = new studentinfo(rollno,name,gender,age);
		d.insertstudent(s1);
		 break;
		
		case 2:
			System.out.println("Enter rollno:");
			int sroll=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter update name:");
			String upname = sc.nextLine();
			
			studentinfo s2 = new studentinfo();
		     s2.setrollno(sroll);
		     s2.setsname(upname);
			d.updatestudent(s2);
			
			break;
			
		case 3:
			System.out.println("Enter rollno:");
			int droll = sc.nextInt();
			sc.nextLine();
			
			studentinfo s3 = new studentinfo();
			s3.setrollno(droll);
			d.deleteStudent(s3);
			
			break;
			
		case 4:
			System.out.println("Enter rollno");
			int groll=sc.nextInt();
			sc.nextLine();
			studentinfo s4=new studentinfo();
			s4.setrollno(groll);
		    d.getStudentByrollno(s4);
		    break;
		    
		case 5:
			studaoimple dao = new studaoimple();

		    List<studentinfo> list = dao.getAllStudents();

		    if (list.isEmpty()) {
		        System.out.println("No records found...");
		    } else {
		        for (studentinfo s : list) {

		            System.out.println(
		                    s.getrollno() + " " +
		                    s.getsname() + " " +
		                    s.getsgender() + " " +
		                    s.getsage()
		            );
		        }
		    }

		    break;
		    
		case 6:
			System.out.println("Enter subid");
			String subid=sc.nextLine();
			sc.nextLine();
			System.out.println("enter subject name:");
			String subname=sc.nextLine();
			sc.nextLine();
			System.out.println("enter max marks :");
			int maxmarks=sc.nextInt();
			
			System.out.println("enter pass marks:");
			int passmarks=sc.nextInt();
			
			subjectinfo sub=new subjectinfo(subid,subname,maxmarks,passmarks);
		    d.insertsubjects(sub);
		    
		    break;
		    
		case 7:
			System.out.println("Enter subid");
			String Usubid=sc.next();
			sc.nextLine();
			
			System.out.println("Update subname");
			String Usname=sc.next();
			
			subjectinfo subject=new subjectinfo();
			subject.setsubid(Usubid);
			subject.setsubname(Usname);
			d.updatesubjects(subject);
			break;
			
		case 8:
			System.out.println("Enter subid");
			String Dsubid=sc.next();
			sc.nextLine();
			
			subjectinfo su =new subjectinfo();
			su.setsubid(Dsubid);
			d.deletesubjects(su);
			break;
			
		case 9:
			System.out.println("Enter subid");
			String Gsubid=sc.next();
			sc.nextLine();
			
			subjectinfo si=new subjectinfo();
			si.setsubid(Gsubid);
			d.getsubjectBysubid(si);
			break;
			
		case 10:
			studaoimple daoimp = new studaoimple();
			List<subjectinfo> l=daoimp.getAllSubjects();
			if(l.isEmpty()) {
				System.out.println("no records found");
				
			}else {
				for(subjectinfo s:l) {
					System.out.println(s.getsubid()+" "+s.getsubname()+" "+
				s.getmaxmarks()+" "+s.getpassmarks());
				}
			}
			break;
			
		case 11:
		    System.out.println("Enter rollno");
		    int rollno1 = sc.nextInt();
		    sc.nextLine();

		    System.out.println("enter subid:");
		    String subid1 = sc.nextLine();

		    System.out.println("enter marks:");
		    int marks = sc.nextInt();

		    System.out.println("Enter Exam Type (MID/FINAL):");
		    String exam = sc.next();

		    marksinfo mark = new marksinfo(rollno1, subid1, marks);
		    mark.setexamtype(exam);

		    d.insertmarks(mark);
		    break;
		    
		case 12:
		    System.out.println("Enter rollno:");
		    int Urollno = sc.nextInt();
		    sc.nextLine();

		    System.out.println("Enter subject id:");
		    String usubid = sc.nextLine();

		    System.out.println("Enter updated marks:");
		    int m = sc.nextInt();

		    marksinfo marks1 = new marksinfo();
		    marks1.setrollno(Urollno);
		    marks1.setsubid(usubid);
		    marks1.setmarks(m);

		    d.updatemarks(marks1);

		    break;
			
			
		case 13:
		

		    System.out.println("Enter RollNo:");
		    int rollno4 = sc.nextInt();

		    studaoimple da = new studaoimple();
		    List<marksinfo> list1 = da.getMarksByRollNo(rollno4);

		    if(list1.isEmpty()) {
		        System.out.println("No records found");
		    } else {
		        System.out.println("ROLLNO   SUBJECT_ID   MARKS");

		        for(marksinfo m1 : list1) {
		            System.out.println(
		                m1.getrollno() + "       " +
		                m1.getsubid() + "        " +
		                m1.getmarks()
		            );
		        }
		    }

		    break;
		    
		case 14:
		    studaoimple DAO = new studaoimple();
		    DAO.getstudentreport();
		    break;
		    
		case 15:
		    studaoimple DAO1 = new studaoimple();
            DAO1.getinfowithranks();
            break;
            
		case 16:
			studaoimple DAO2 =new studaoimple();
			DAO2.get1standlastranks();
			break;
			
		case 17:
			studaoimple DAO3=new studaoimple();
			DAO3.getfailedstudents();
			break;
			
		case 18:
			System.out.print("Enter Roll Number: ");
	        int roll = sc.nextInt();

		    studaoimple DAO18 = new studaoimple();
	        DAO18.getresult(roll);

		}
		
		}
		
	}

}
