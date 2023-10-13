<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
 <%@ page import = "java.io.*"%>

 <% 
   Connection cn;
	 Statement state;
	ResultSet result;
	 String user="root";
	 String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 String passwd="00000";
	 String classforname="com.mysql.cj.jdbc.Driver";
	
	 int id=Integer.parseInt(request.getParameter("id"));
	 System.out.println("cccmoi "+id);
 try {
	 System.out.println("bb0");
				 Class.forName(classforname);
				    cn =(Connection) DriverManager.getConnection(url,user,passwd);
				    state = cn.createStatement();
				    PreparedStatement stmt = cn.prepareStatement("select justification from justification where idjustification="+id);
				 	ResultSet R = stmt.executeQuery();
					System.out.println("bb1");
									 
									 if (R.next()) {
								     Blob jus=(Blob) R.getBlob("justification");
								     System.out.println("bb2");
									 byte byteArray[]=jus.getBytes(1,(int) jus.length());
									 System.out.println("bb3");
									 response.setContentType("image/gif");
									 System.out.println("bb4");
									 OutputStream os=response.getOutputStream();
									 System.out.println("5");
									 os.write(byteArray);
									 os.flush();
									 os.close();
									 }
									 else {
										 System.out.println("pas de photo");
									 }
								 	 state.close();
							         cn.close(); 
							}    catch (Exception ex) {
							 		      System.out.println(ex.toString()); 

							
							
							}	
 
 %>		