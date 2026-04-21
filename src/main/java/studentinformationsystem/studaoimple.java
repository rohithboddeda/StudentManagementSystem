package studentinformationsystem;
import java.util.*;



import java.sql.*;
import studentinformationsystem.connect;
import studentinformationsystem.studentinfo;
import studentinformationsystem.subjectinfo;
import studentinformationsystem.marksinfo;


public  class studaoimple implements dao {
	
   
	
	public void insertstudent(studentinfo s)  throws Exception {
		String query ="INSERT INTO STUDENT_INFO VALUES(?,?,?,?) ";
        Connection con = connect.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        	ps.setInt(1, s.getrollno());
        	ps.setString(2,s.getsname());
        	ps.setString(3,s.getsgender());
        	ps.setInt(4, s.getsage());
        	
        	ps.executeUpdate();
        	System.out.println("student inserted");
        	con.close();
        }
		
		
	

	@Override
	public void updatestudent(studentinfo s) throws Exception {
		String query ="UPDATE STUDENT_INFO SET S_NAME=? WHERE ROLL_NO=? ";
		Connection con=connect.getConnection();
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1, s.getsname());
		ps.setInt(2, s.getrollno());
		
		ps.executeUpdate();
		System.out.println("update succesfully");
		con.close();
	}

	@Override
	public void deleteStudent(studentinfo s) throws Exception {
		String query ="DELETE FROM STUDENT_INFO WHERE ROLL_NO=?";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,s.getrollno());
		
		ps.executeUpdate();
		System.out.println("student deleted succesfully:");
		con.close();
		
	}

	@Override
	public  studentinfo getStudentByrollno(studentinfo s) throws Exception {
		String query ="SELECT * FROM STUDENT_INFO WHERE ROLL_NO=?";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,s.getrollno());
		

		
		ResultSet rs=ps.executeQuery();
		System.out.println("student below");
		if(rs.next()) {
		s.setrollno(rs.getInt(1));
		s.setsname(rs.getString(2));
		s.setsgender(rs.getString(3));
		s.setsage(rs.getInt(4));
		
		System.out.println("roll_no:"+s.getrollno());
		}
		con.close();
		return s;
		
	}

	@Override
	public List<studentinfo> getAllStudents() throws Exception {
		String query ="SELECT * FROM STUDENT_INFO";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		List<studentinfo> studentList = new ArrayList<>();

	    while (rs.next()) {

	        studentinfo s = new studentinfo();

	        s.setrollno(rs.getInt("ROLL_NO"));
	        s.setsname(rs.getString("S_NAME"));
	        s.setsgender(rs.getString("S_GENDER"));
	        s.setsage(rs.getInt("S_AGE"));

	        studentList.add(s);
	    }

	    con.close();

	    return studentList;
	}




	@Override
	public void insertsubjects(subjectinfo s1) throws Exception {
		String query="INSERT INTO SUBJECTS VALUES(?,?,?,?)";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,s1.getsubid());
		ps.setString(2,s1.getsubname());
		ps.setInt(3,s1.getmaxmarks());
		ps.setInt(4,s1.getpassmarks());
		
		ps.executeUpdate();
		System.out.println("subject details inserted");
		con.close();
	}




	@Override
	public void updatesubjects(subjectinfo s2) throws Exception {
		String query="UPDATE SUBJECTS SET SUB_NAME=? WHERE SUBJECT_ID=?";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1,s2.getsubname());
		ps.setString(2,s2.getsubid());
		
		ps.executeUpdate();
		System.out.println("updated succesfully");
		con.close();
	}




	@Override
	public void deletesubjects(subjectinfo s3) throws Exception {
		String query="DELETE FROM SUBJECTS WHERE SUB_ID=? ";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,s3.getsubid());
		
		ps.executeUpdate();
		System.out.println("Deleted Succesfully");
		con.close();
	}




	@Override
	public subjectinfo getsubjectBysubid(subjectinfo s4) throws Exception {
		String query ="SELECT * FROM SUBJECTS WHERE SUBJECT_ID=?";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,s4.getsubid());
		

		
		ResultSet rs=ps.executeQuery();
		System.out.println("subject below");
		if(rs.next()) {
		s4.setsubid(rs.getString(1));
		s4.setsubname(rs.getString(2));
		s4.setmaxmarks(rs.getInt(3));
		s4.setpassmarks(rs.getInt(4));
		
		System.out.println("subid:"+s4.getsubid());
		}
		con.close();
		return s4;
		
	}




	@Override
	public List<subjectinfo> getAllSubjects() throws Exception {
		String query ="SELECT * FROM SUBJECTS";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		List<subjectinfo> subjectList = new ArrayList<>();

	    while (rs.next()) {

	        subjectinfo s = new subjectinfo();

	        s.setsubid(rs.getString("SUBJECT_ID"));
	        s.setsubname(rs.getString("SUB_NAME"));
	        s.setmaxmarks(rs.getInt("MAX_MARKS"));
	        s.setpassmarks(rs.getInt("PASS_MARKS"));

	        subjectList.add(s);
	    }

	    con.close();

	    return subjectList;
	    
	    
	}
	public void insertmarks(marksinfo m)throws Exception{
		String query="INSERT INTO MARKS_TABLE VALUES(?,?,?,?)";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,m.getrollno());
		ps.setString(2,m.getsubid());
		ps.setInt(3,m.getmarks());
		ps.setString(4, m.getexamtype());
		
		
		ps.executeUpdate();
		System.out.println("marks inserted");
		con.close();
	}




	@Override
	public void updatemarks(marksinfo m) throws Exception {
		String query="UPDATE MARKS_TABLE SET MARKS=? WHERE ROLL_NO=? AND SUB_ID=?";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setInt(1,m.getmarks());
		ps.setInt(2,m.getrollno());
		
		ps.executeUpdate();
		System.out.println("updated succesfully");
		con.close();
		
	}




	@Override
	public List<marksinfo> getMarksByRollNo(int rollno) throws Exception {
		String query = "SELECT * FROM MARKS_TABLE WHERE ROLL_NO=?";
	    Connection con = connect.getConnection();
	    PreparedStatement ps = con.prepareStatement(query);

	    ps.setInt(1, rollno);   

	    ResultSet rs = ps.executeQuery();

	    List<marksinfo> list = new ArrayList<>();

	    while(rs.next()) {
	        marksinfo m = new marksinfo();

	        m.setrollno(rs.getInt("ROLL_NO"));
	        m.setsubid(rs.getString("SUBJECT_ID"));  
	        m.setmarks(rs.getInt("MARKS"));
	        m.setexamtype(rs.getString("EXAM_TYPE"));

	        list.add(m);
	    }

	    con.close();

	    return list;
	}




	@Override
	public void getstudentreport() throws Exception {
		String query="SELECT S.ROLL_NO,S.S_NAME,SU.SUBJECT_ID,SU.SUB_NAME,M.MARKS,M.EXAM_TYPE "
				+ "FROM STUDENT_INFO S,SUBJECTS SU,MARKS_TABLE M "
				+ "WHERE S.ROLL_NO=M.ROLL_NO AND SU.SUBJECT_ID=M.SUBJECT_ID";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		
		ResultSet rs=ps.executeQuery();
		
		System.out.println("ROLL_NO   NAME   SUBJECT_ID   SUBJECT_NAME  MARKS");
		
		while(rs.next()) {
			System.out.println(rs.getInt("ROLL_NO")+"     "+
		                       rs.getString("S_NAME")+"     "+
					            rs.getString("SUBJECT_ID")+"       "+
		                        rs.getString("SUB_NAME")+"         "+
					            rs.getInt("MARKS")+"        "+
		                        rs.getString("EXAM_TYPE"));
		}
		con.close();
		
	}




	@Override
	public void getinfowithranks() throws Exception {
		String query="SELECT S.ROLL_NO, S.S_NAME, " +
				"SUM(M.MARKS) TOTAL, " +
				"ROUND(AVG(M.MARKS),2) AVERAGE, " +
				"RANK() OVER (ORDER BY SUM(M.MARKS) DESC) RANK " +
				"FROM MARKS_TABLE M, STUDENT_INFO S " +
				"WHERE S.ROLL_NO = M.ROLL_NO " +
				"GROUP BY S.ROLL_NO, S.S_NAME";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		System.out.println("ROLL_NO     S_NAME    TOTAL    AVERAGE   RANK");
		
		while(rs.next()) {
		    System.out.println(
		        rs.getInt("ROLL_NO") + "      " +
		        rs.getString("S_NAME") + "      " +
		        rs.getInt("TOTAL") + "    " +
		        rs.getDouble("AVERAGE") + "      " +
		        rs.getInt("RANK"));
		}
		con.close();
		
	}




	@Override
	public void get1standlastranks() throws Exception {
		String query="WITH DATA AS ( " +
				"SELECT S.ROLL_NO, S.S_NAME, " +
				"SUM(M.MARKS) TOTAL, " +
				"ROUND(AVG(M.MARKS),2) AVERAGE, " +
				"RANK() OVER (ORDER BY SUM(M.MARKS) DESC) RANK " +
				"FROM MARKS_TABLE M, STUDENT_INFO S " +
				"WHERE S.ROLL_NO = M.ROLL_NO " +
				"GROUP BY S.ROLL_NO, S.S_NAME ) " +
				"SELECT * FROM DATA " +
				"WHERE RANK = 1 OR RANK = (SELECT MAX(RANK) FROM DATA)";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		System.out.println("ROLL_NO     S_NAME    TOTAL    AVERAGE   RANK");
		
		while(rs.next()) {
		    System.out.println(
		        rs.getInt("ROLL_NO") + "      " +
		        rs.getString("S_NAME") + "      " +
		        rs.getInt("TOTAL") + "    " +
		        rs.getDouble("AVERAGE") + "      " +
		        rs.getInt("RANK"));
		}
		con.close();
		
	}




	@Override
	public void getfailedstudents() throws Exception {
		String query="SELECT S.ROLL_NO, S.S_NAME, SU.SUBJECT_ID, SU.SUB_NAME, M.MARKS " +
				"FROM STUDENT_INFO S, SUBJECTS SU, MARKS_TABLE M " +
				"WHERE S.ROLL_NO = M.ROLL_NO " +
				"AND SU.SUBJECT_ID = M.SUBJECT_ID " +
				"AND SU.PASS_MARKS > M.MARKS";
		Connection con=connect.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		System.out.println("ROLL_NO    S_NAME    SUBJECT_ID   SUB_NAME   MARKS ");
		
		while(rs.next()) {
		    System.out.println(
		        rs.getInt("ROLL_NO") + "       " +
		        rs.getString("S_NAME") + "     " +
		        rs.getString("SUBJECT_ID") + "      " +
		        rs.getString("SUB_NAME") + "         " +
		        rs.getInt("MARKS")
		    );
		}
		con.close();
		
	}




	@Override
	public void getresult(int roll) throws Exception {
		Connection con=connect.getConnection();
		 CallableStatement cs = con.prepareCall("{call SP_PROJECTS(?,?,?,?)}");

       
         cs.setInt(1,roll);

       
         cs.registerOutParameter(2, java.sql.Types.VARCHAR); 
         cs.registerOutParameter(3, java.sql.Types.NUMERIC); 
         cs.registerOutParameter(4, java.sql.Types.NUMERIC); 

         cs.execute();

         
         String result = cs.getString(2);
         int total = cs.getInt(3);
         double percent = cs.getDouble(4);

         
         System.out.println("Total: " + total);
         System.out.println("Percentage: " + percent);
         System.out.println("Result: " + result);

         con.close();
		
	}
		

	}
	




	
	
	
	    
		
		



	
	
	
 
	


