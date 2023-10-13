 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@page import="modeleC.*"  %>
         <%@page import="modeleE.*"  %>
           <%@page import="modele.*"  %>
       <%@page import="java.sql.*" %>
       <%@ page import="java.text.SimpleDateFormat" %>
       <%@page import= "java.time.*"%>
      <%@page import ="java.time.format.DateTimeFormatter"%>
       <%@page import ="java.util.Locale"%>
          <%@page import ="java.util.ArrayList"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<style>

textarea[type=text]{
    width:82%;
    border:2px solid #aaa;
    border-radius:4px;
    margin:5px 0;
    outline:none;
    padding:10px;
    box-sizing:border-box;
    transition:.3s;
   
  }
  
  textarea[type=text]:focus{
    border-color:orange;
    box-shadow:0 0 8px 0 orange;
  }

.column100 {
  width: 130px;
  padding-left: 25px;
}

.column100.column1 {
  width: 250px;
  padding-left: 42px;
}

.row100.head th {
  padding-top: 24px;
  padding-bottom: 20px;
}

.row100 td {
  padding-top: 18px;
  padding-bottom: 14px;
}


.table100.ver6 {
  border-radius: 16px;
  overflow: hidden;
  background: #80ff80;
  background: -webkit-linear-gradient(-68deg,#b5e7a0, #66FF66);
  background: -o-linear-gradient(-68deg, #b5e7a0, #66FF66);
  background: -moz-linear-gradient(-68deg, #b5e7a0, #d1eaa3);
  background: linear-gradient(-68deg, #b5e7a0 , #d1eaa3);
  
}

.table100.ver6 table {
  background-color: transparent;
}

.table100.ver6 td {
  font-family: Montserrat-Regular;
  font-size: 15px;
  color: #000000;
  line-height: 1.4;
}

.table100.ver6 th {
  font-family: Montserrat-Medium;
  font-size: 15px;
  color: #000000;
  line-height: 1.4;
  text-transform: uppercase;

  background-color: rgba(255,255,255,0.32);
}

.table100.ver6 .row100:hover td {
  background-color: rgba(255,255,255,0.1);
}

.table100.ver6 .hov-column-ver6 {
  background-color: rgba(255,255,255,0.1);
}


.table100.ver6 .row100 td:hover {
  background-color: rgba(255,255,255,0.2);
}


</style>
<style>
.bloc {
  display: flex;
  flex-direction: column;
  align-items : center;
  justify-content: center;
  height: 5vh;
}

/*Réinitilaisation de la liste déroulante*/
select {
  appearance: none;
  outline: 0;
  border: 0 !important;
  background: #F9F9F9;
  background-image: none;
  box-shadow: none;
  font-size: 1.2em;
}/*Ajout des couleurs de fond pour chaque option */

/* Mise en forme de la div .select*/
.select {
  position: relative;
  width: 90px;
  height: 30px;
  overflow: hidden;
  border-radius: 5px;
  border: 1px solid #CED4DA;
}

/* Mise en forme de la balise select*/
select {
  width: 100%;
  height: 100%;
  margin: 0;
  padding-left: 15px;
  color: #555555;
  cursor: pointer;
}


/ Mise en place de la flèche /
.select::after {
  content: '\276F';
  position: absolute;
  top: 60%;
  right: 0;
  padding: 0 15px;
  background: white;
  pointer-events: none;
  transform: rotate(180deg);
  font-size: 1.5em;
  background: #F9F9F9;
}


.select:hover::after {
  color: #15E81F;
}
</style>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/logo.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Affecter les séances
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" /> 
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" type="text/css"/>
  <link href=../assets/demo/demo.css" rel="stylesheet" type="text/css"/>
</head>
<body class="">
  <div class="wrapper">
   <div class="sidebar" data-color="green" data-background-color="black" data-image="../assets/img/log.jpg">
 <li class="nav-item d-none d-md-block"><a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>   
        <div class="logo"><a class="simple-text logo-normal">
         <img src="../assets/img/logo2 (2).png" style="position:absolute;
         top:6px;
         left:14px;  
         width: 65px;
          height: 65px; ">
          Bienvenue </br>
          ${sessionScope.n}
         <%
                
              		int iden=(Integer)session.getAttribute("i");
                    String prenom =(String)session.getAttribute("n");
                    int idchef=(Integer)session.getAttribute("idc");
                    int idUser = (Integer)session.getAttribute("id");
                    HomeCHEF hc=new HomeCHEF();
               	 ArrayList<Formation> lf=hc.selectFormation(idUser); 
                    
    		%>
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav ">
    
            
            <li class="nav-item ">
              <a class="nav-link" href="#navbar-components" role="button" data-toggle="collapse"aria-expanded="true" aria-controls="navbar-components">
                 <i class=""><img src="../assets/ima/groups.png" style=" width: 24px;height: 24px;"></i>
                <p >Consulter les étudiants</p>
              </a>
               <%                          
         	Connection cn;
   Statement state;
    ResultSet result;
     String user="root";
   	String url="jdbc:mysql://localhost/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   	 String passwd="00000";
   	 String classforname="com.mysql.cj.jdbc.Driver";
   	Class.forName(classforname);
    cn =(Connection) DriverManager.getConnection(url,user,passwd);
    state = cn.createStatement();
    String q="SELECT abréviation,idformation FROM chefdedépartement c,formation f where c.iddépartement=f.iddépartement and idchef="+idchef;
    ResultSet R =  state.executeQuery(q);
 	 %>
              <div class="collapse " id="navbar-components">
                <ul class="nav nav-sm flex-column">
                  <% int co5=1000; while(R.next()){
                	  co5=co5+1;
       %>
                  <li class="nav-item">
                    <a href="#<%=co5%>" class="nav-link" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="<%=co5%>">
                       <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                        
                      <span> <%=R.getString("abréviation") %></span>
                    </a>
                    
                       <div class="collapse " id="<%=co5%>">
                <ul class="nav nav-sm flex-column">
                  <%   jibGroupe jb= new jibGroupe();
          ArrayList<groupe> l =jb.getGroup(R.getInt("idformation"));
          for(groupe g:l){ %>
                      <li class="nav-item ">
                      
                            
                         
                          <a href="http://localhost:8080/gestion/SConsEtu?idgrou=<%=g.getIdgroupe() %>" class="nav-link "><%=g.getNom() %></a>
                         
                        </li>
                        <%} %>   
                      </ul>
                      </div>
                  </li>
                   <%} %>
                </ul>
              </div>
            </li>
            
       
         
         
                   <li class="nav-item ">
             <a class="nav-link" href="#navbar-examples" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="navbar-examples">
                    <i class=""><img src="../assets/ima/rec.png" style=" width: 24px;height: 24px;"></i>
                <p >Gérer les réclamations</p>
              </a>
                                        
         <%  String q1="SELECT abréviation,idformation FROM chefdedépartement c,formation f where c.iddépartement=f.iddépartement and idchef="+idchef;
    ResultSet R1 =  state.executeQuery(q1);
 	 %>
   	
              <div class="collapse "id="navbar-examples">
                <ul class="nav nav-sm flex-column">
                  <% int co7=7000; while(R1.next()){
                	  co7=co7+1;
       %>
                  <li class="nav-item">
                    <a href="#<%=co7%>" class="nav-link" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="<%=co7%>">
                 <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                   
                      <p> <%=R1.getString("abréviation") %></p>
                    </a>
                    
                       <div class="collapse " id="<%=co7%>">
                <ul class="nav nav-sm flex-column">
                  <%   jibGroupe jb= new jibGroupe();
          ArrayList<groupe> l =jb.getGroup(R1.getInt("idformation"));
   for(groupe g:l){ %>
                      <li class="nav-item ">
                      
               
                          
                          <a href="http://localhost:8080/gestion/SConsRc?idgrou=<%=g.getIdgroupe() %>" class="nav-link "><%=g.getNom() %></a>
                         
                        </li>
                        <%} %>   
                      </ul>
                      </div>
                  </li>
                   <%} %>
                </ul>
              </div>
            </li>
            
            <li class="nav-item ">
             <a class="nav-link" href="#navbar-example" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="navbar-example">
                 <i class=""><img src="../assets/ima/jus.png" style=" width: 24px;height: 24px;"></i>
                <p >Gérer les justifications</p>
              </a>
                                        
         <%  String lm="SELECT abréviation,idformation FROM chefdedépartement c,formation f where c.iddépartement=f.iddépartement and idchef="+idchef;
    ResultSet R2 =  state.executeQuery(lm);
 	 %>
   	
              <div class="collapse "id="navbar-example">
                <ul class="nav nav-sm flex-column">
                  <% int co8=7500; while(R2.next()){
                	  co8=co8+1;
       %>
                  <li class="nav-item">
                    <a href="#<%=co8%>" class="nav-link" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="<%=co8%>">
                     <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                  
                      <p> <%=R2.getString("abréviation") %></p>
                    </a>
                    
                       <div class="collapse " id="<%=co8%>">
                <ul class="nav nav-sm flex-column">
                  <%   jibGroupe jb= new jibGroupe();
          ArrayList<groupe> l =jb.getGroup(R2.getInt("idformation"));
   for(groupe g:l){ %>
                      <li class="nav-item ">
                      
                        
                          
                          <a href="http://localhost:8080/gestion/SJust?idgrou=<%=g.getIdgroupe() %>" class="nav-link "><%=g.getNom() %></a>
                         
                        </li>
                        <%} %>   
                      </ul>
                      </div>
                  </li>
                   <%} %>
                </ul>
              </div>
            </li>
       
          
            
            <li class="nav-item">
              <a class="nav-link" href="http://localhost:8080/gestion/Sens?id=<%=idUser%>&name=<%=prenom%>">
                    <i class=""><img src="../assets/ima/ens.png" style=" width: 24px;height: 24px;"></i>
                <p>Mon compte enseignant</p>
              </a>
            </li>
            
            
            
            
             <li class="nav-item active">
         
              <a class="nav-link" href="#navbar-dashboards" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="navbar-dashboards">
                <i class=""><img src="../assets/img/hor.png"  style=" width: 24px;height: 24px;"></i>
                <p>Affecter les séances</p>
              </a>
              <div class="collapse" id="navbar-dashboards">
                <ul class="nav nav-sm flex-column">
                <% for (Formation f:lf){ %>
                  <li class="nav-item">
                    <a href="http://localhost:8080/gestion/SListeENS?iduser=${sessionScope.id}&name=${sessionScope.name}&idformation=<%=f.getIdFormation() %>" class="nav-link">
                     <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                      <p><%=f.getAbreviation()%></p>
                    </a>
                  </li>
                 <%} %>
                </ul>
              </div>
            </li>
              <li class="nav-item ">
         
              <a class="nav-link" href="#navbar-dashboards1" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="navbar-dashboards1">
                 <i class=""><img src="../assets/img/list.png"  style=" width: 24px;height: 24px;"></i>
                <p>Consulter le relevé des absences</p>
              </a>
              <div class="collapse" id="navbar-dashboards1">
                <ul class="nav nav-sm flex-column">
                <% for (Formation f:lf){ %>
                  <li class="nav-item">
                    <a href="#<%=f.getAbreviation()%>" class="nav-link" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="<%=f.getAbreviation()%>">
                       <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                      <p><%=f.getAbreviation()%></p>
                      
                    </a>
                     <div class="collapse " id="<%=f.getAbreviation()%>" >
                     <%ArrayList <Integer> lg=hc.selectGroupe(f.getIdFormation()); %>
                      <ul class="nav nav-sm flex-column">
                     <%  for (Integer g:lg){%>
                        <li class="nav-item">
                          <a href="http://localhost:8080/gestion/SListegroupe?iduser=${sessionScope.id}&name=${sessionScope.name}&idgroupe=<%=g %>" class="nav-link "><%=hc.selectNOMGroupe(g) %></a>
                        </li>
                        <%} %>
                      </ul>
                    </div>
                  </li>
                 <%} %>
                </ul>
              </div>
            </li>
            
                  <li class="nav-item ">
         
              <a class="nav-link" href="#navbar-dashboards2" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="navbar-dashboards2">
                  <i class=""><img src="../assets/img/exclu.png"  style=" width: 24px;height: 24px;"></i>
                <p>Consulter la liste des exlus</p>
              </a>
              <div class="collapse" id="navbar-dashboards2">
                <ul class="nav nav-sm flex-column">
                <% for (Formation f:lf){ %>
                  <li class="nav-item">
                    <a href="#<%=f.getIdFormation()%>" class="nav-link" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="<%=f.getIdFormation()%>">
                      <i class=""><img src="../assets/ima/spec.png" style=" width: 24px;height: 24px;"></i>
                      <p><%=f.getAbreviation()%></p>
                      
                    </a>
                     <div class="collapse " id="<%=f.getIdFormation()%>" >
                     <%ArrayList <Integer> lg=hc.selectGroupe(f.getIdFormation()); %>
                      <ul class="nav nav-sm flex-column">
                     <%  for (Integer g:lg){%>
                        <li class="nav-item">
                          <a href="http://localhost:8080/gestion/SListegroupeEXCLUS?iduser=${sessionScope.id}&name=${sessionScope.name}&idgroupe=<%=g %>&idformation=<%=f.getIdFormation() %>" class="nav-link "><%=hc.selectNOMGroupe(g) %></a>
                        </li>
                        <%} %>
                      </ul>
                    </div>
                  </li>
                 <%} %>
                </ul>
              </div>
            </li>
          
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
          
          <% 	   LocalDateTime localDateTime= new java.util.Date().toInstant()
                  .atZone(ZoneId.systemDefault())
                  .toLocalDateTime();
LocalDate localDate=localDateTime.toLocalDate();
          
         
            
            //Day of week and month in French
            String dateInFrench=localDate.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy",Locale.FRENCH));
            
            String dayInFRench=localDate.format(DateTimeFormatter.ofPattern("EEEE",Locale.FRENCH));
            
            %>
            <a class="navbar-brand" ><%= dateInFrench %> </a></br>
          </div>
          
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
                    <li class="nav-item">
                 <a class="nav-link" href="homeCHEF.jsp">
                   <i class=""><img src="../assets/ima/home.png" style=" width: 24px;height: 24px;"></i>
                 
                </a>
              </li>
           
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                
              
                  <a class="dropdown-item" href="#">Déconnecter</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
       
      <div class="content">
         <div class="container-fluid">
          <div class="row">
          
          <div class="col-md-8 ml-auto mr-auto">
         <div class="table100 ver6 m-b-110">
          
       <table data-vertable="ver6">
       <%   
       ArrayList<Integer> Lmodule=new ArrayList<Integer>(); 
       ListedesAbsences L=new ListedesAbsences();
       
     cn= (Connection)DriverManager.getConnection(url,user,passwd);
           Statement stmt=cn.createStatement();
           int idformation = (Integer)session.getAttribute("idformation");
           int idens = (Integer)session.getAttribute("idens");
      	 ResultSet rs=stmt.executeQuery("select * from module  where idformation="+idformation);
     while(rs.next()){Lmodule.add(rs.getInt("idmodule"));}
       %> 
       
       <thead >
       <tr class="row100 head">
       <th class="column100 column4" data-column="column4"></th>
       <th class="column100 column4" data-column="column4">8:30-10:00</th>
       <th class="column100 column4" data-column="column4">10:00-11:30</th>
       <th class="column100 column3" data-column="column3">11:30-13:00</th>
       <th class="column100 column4" data-column="column4">13:00-14:30</th>
       <th class="column100 column5" data-column="column5">14:30-16:00</th>
       </tr>
      </thead>
        <form action="http://localhost:8080/gestion/SrecupererinfoEmploi?idens=<%=idens%>&idformation=<%= idformation %>&iduser=${sessionScope.iduser}&name=${sessionScope.name}" method="POST">
       <tbody>
       <tr class="row100">
           <td class="column100 column4" data-column="column4"> Dimanche</td>
                      
                 <% 
                 
                 ArrayList<modeleE.Seance> Lseance=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet rs1=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='dimanche' and heured='08:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='dimanche' and heured='08:30'");
           while(rs.next()){
        	   modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        Lseance.add(s); 
        	}} %>     
              <td>   
              
              <div class="bloc"><div class="select"><select name="1"><%if(!rs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %>
              <option value="<%=rs1.getInt("idséance")%>"><%=rs1.getInt("idmodule")%><%= rs1.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:Lseance){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option> <
                             <%} %>
</select></div></div>
           
            
              </td>     
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> Lseance1=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet rs2=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='dimanche' and heured='10:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='dimanche' and heured='10:00'");
           while(rs.next()){
        	   modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        Lseance1.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="2"><%if(!rs2.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=rs2.getInt("idséance")%>"><%=rs2.getInt("idmodule")%><%= rs2.getString("type")%></option>
              <option value="<%=0%>">-</option><%}%> 
              <%for(modeleE.Seance s1:Lseance1){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
             
              </td> 
                 <% 
                 
                 ArrayList<modeleE.Seance> Lseance2=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet rs3=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='dimanche' and heured='11:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='dimanche' and heured='11:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        Lseance2.add(s); 
        	}} %>     
              <td><select  class="select" id="exampleFormControlSelect1" name="3"><%if(!rs3.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=rs3.getInt("idséance")%>"><%=rs3.getInt("idmodule")%><%= rs3.getString("type")%></option>
              <option value="<%=0%>"> </option><%}%> 
              <%for(modeleE.Seance s1:Lseance2){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>    
              
                 <% 
                 
                 ArrayList<modeleE.Seance> Lseance3=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet rs4=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='dimanche' and heured='13:00'");
               System.out.println("hnaaaaaaa");
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='dimanche' and heured='13:00'");
           while(rs.next()){
        	   System.out.println("hnaaaaaaa22");
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        Lseance3.add(s); 
        	}} %>     
              <td><select  class="select" id="exampleFormControlSelect1" name="4"><%if(!rs4.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=rs4.getInt("idséance")%>"><%=rs4.getInt("idmodule")%><%= rs4.getString("type")%></option>
              <option value="<%= 0 %>"></option><%}%> 
              <%for(modeleE.Seance s1:Lseance3){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> Lseance5=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet rs6=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='dimanche' and heured='14:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='dimanche' and heured='14:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        Lseance5.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="5"><%if(!rs6.next()){ %><option value="<%=-1%>">-</option> <%}else{ %><option value="<%=rs6.getInt("idséance")%>"><%=rs6.getInt("idmodule")%><%= rs6.getString("type")%></option>
            <option value="<%=0%>">-</option> <%}%> 
              <%for(modeleE.Seance s1:Lseance5){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
                      
       </tr>
       
       <tr class="row100">
           <td class="column100 column4" data-column="column4"> Lundi</td>
                      
                 <% 
                 
                 ArrayList<modeleE.Seance> LLseance=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Lrs1=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='lundi' and heured='08:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='lundi' and heured='08:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
  LLseance.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="6"><%if(!Lrs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Lrs1.getInt("idséance")%>"><%=Lrs1.getInt("idmodule")%><%=Lrs1.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:LLseance){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>   
                
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> LLseance1=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Lrs2=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='lundi' and heured='10:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='lundi' and heured='10:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        LLseance1.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="7"><%if(!Lrs2.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Lrs2.getInt("idséance")%>"><%=Lrs2.getInt("idmodule")%><%=Lrs2.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:LLseance1){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                            
                            
                             <%} %>
                             
          </select></div></div>




              
              
              </td> 
                 <% 
                 
                 ArrayList<modeleE.Seance> LLseance2=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Lrs3=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='lundi' and heured='11:30'");
                 
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='lundi' and heured='11:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        LLseance2.add(s); 
        	}} %>     
        	
              <td><div class="bloc"><div class="select"><select name="8"><%if(!Lrs3.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option  value="<%=Lrs3.getInt("idséance")%>"><%=Lrs3.getInt("idmodule")%><%=Lrs3.getString("type")%></option>
              <option value="<%=Lrs3.getInt("idséance")%><%=0 %>"></option>
              
              <%}%> 
              
              <%for(modeleE.Seance s1:LLseance2){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                              
                             <%} %>
</select></div></div>
              
              
              </td>    
              
                 <% 
                 
                 ArrayList<modeleE.Seance> LLseance3=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Lrs4=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='lundi' and heured='13:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='lundi' and heured='13:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        LLseance3.add(s); 
        	}} %>     
             <td><div class="bloc"><div class="select"><select name="9"><%if(!Lrs4.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Lrs4.getInt("idséance")%>"><%=Lrs4.getInt("idmodule")%><%=Lrs4.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:LLseance3){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
                             
                             
                             
</select></div></div>
              
              
              </td> 
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> LLseance5=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Lrs6=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='lundi' and heured='14:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='lundi' and heured='14:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        LLseance5.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="10"><%if(!Lrs6.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Lrs6.getInt("idséance")%>"><%=Lrs6.getInt("idmodule")%><%=Lrs6.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:LLseance5){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
                      
       </tr>
       
       <tr class="row100">
           <td class="column100 column4" data-column="column4"> Mardi</td>
                      
                 <% 
                 
                 ArrayList<modeleE.Seance> MLseance=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Mrs1=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mardi' and heured='08:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mardi' and heured='08:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
  MLseance.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="11"><%if(!Mrs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= Mrs1.getInt("idséance")%>"><%=Mrs1.getInt("idmodule")%><%=Mrs1.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MLseance){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MLseance1=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Mrs2=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mardi' and heured='10:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mardi' and heured='10:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MLseance1.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="12"><%if(!Mrs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= Mrs2.getInt("idséance")%>"><%=Mrs2.getInt("idmodule")%><%=Mrs2.getString("type")%></option>
              
              
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MLseance1){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
                 <% 
                 
                 ArrayList<modeleE.Seance> MLseance2=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Mrs3=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mardi' and heured='11:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mardi' and heured='11:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MLseance2.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="13"><%if(!Mrs3.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= Mrs3.getInt("idséance")%>"><%=Mrs3.getInt("idmodule")%><%=Mrs3.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>
              <%for(modeleE.Seance s1:MLseance2){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>    
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MLseance3=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Mrs4=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mardi' and heured='13:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mardi' and heured='13:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MLseance3.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="14"><%if(!Mrs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= Mrs4.getInt("idséance")%>"><%=Mrs4.getInt("idmodule")%><%=Mrs4.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>
              <%for(modeleE.Seance s1:MLseance3){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MLseance5=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Mrs6=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mardi' and heured='14:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mardi' and heured='14:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MLseance5.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="15"><%if(!Mrs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= Mrs6.getInt("idséance")%>"><%=Mrs6.getInt("idmodule")%><%=Mrs6.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>
              <%for(modeleE.Seance s1:MLseance5){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
                      
       </tr>
       
       <tr class="row100">
           <td class="column100 column4" data-column="column4"> Mercredi</td>
                      
                 <% 
                 
                 ArrayList<modeleE.Seance> MELseance=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet MErs1=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mercredi' and heured='08:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mercredi' and heured='08:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
  MELseance.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="16"><%if(!MErs1.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= MErs1.getInt("idséance")%>"><%=MErs1.getInt("idmodule")%><%=MErs1.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MELseance){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MELseance1=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet MErs2=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mercredi' and heured='10:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mercredi' and heured='10:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MELseance1.add(s); 
        	}} %>     
     <td><div class="bloc"><div class="select"><select name="17"><%if(!MErs2.next()){ %><option value="<%=-1%>"></option> <%}else{ %>
     <option value="<%= MErs2.getInt("idséance")%>"><%=MErs2.getInt("idmodule")%><%=MErs2.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>  
              <%for(modeleE.Seance s1:MELseance1){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
                 <% 
                 
                 ArrayList<modeleE.Seance> MELseance2=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet MErs3=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mercredi' and heured='11:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mercredi' and heured='11:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MELseance2.add(s); 
        	}} %>     
              <td><div class="bloc"><div class="select"><select name="18"><%if(!MErs3.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= MErs3.getInt("idséance")%>"><%=MErs3.getInt("idmodule")%><%=MErs3.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MELseance2){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>    
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MELseance3=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet MErs4=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mercredi' and heured='13:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mercredi' and heured='13:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MELseance3.add(s); 
        	}} %>     
             <td><div class="bloc"><div class="select"><select name="19"><%if(!MErs4.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= MErs4.getInt("idséance")%>"><%=MErs4.getInt("idmodule")%><%=MErs4.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MELseance3){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> MELseance5=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet MErs6=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='mercredi' and heured='14:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='mercredi' and heured='14:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        MELseance5.add(s); 
        	}} %>     
            <td><div class="bloc"><div class="select"><select name="20"><%if(!MErs6.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%= MErs6.getInt("idséance")%>"><%=MErs6.getInt("idmodule")%><%=MErs6.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:MELseance5){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
                      
       </tr>
       
          <tr class="row100">
           <td class="column100 column4" data-column="column4"> Jeudi</td>
                      
                 <% 
                 
                 ArrayList<modeleE.Seance> JLseance=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Jrs1=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='jeudi' and heured='08:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='jeudi' and heured='08:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
  JLseance.add(s); 
        	}} %>     
               
              <td><div class="bloc"><div class="select"><select name="21"><%if(!Jrs1.next()){ %><option value="<%=-1%>"></option > <%}else{ %><option value="<%=Jrs1.getInt("idséance")%>"><%=Jrs1.getInt("idmodule")%><%=Jrs1.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
              <%for(modeleE.Seance s1:JLseance){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> JLseance1=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Jrs2=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='jeudi' and heured='10:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='jeudi' and heured='10:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        JLseance1.add(s); 
        	}} %>     
             <td><div class="bloc"><div class="select"><select name="22"><%if(!Jrs2.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Jrs2.getInt("idséance")%>"><%=Jrs2.getInt("idmodule")%><%=Jrs2.getString("type")%></option>
              <option value="<%=0%>"></option><%}%> 
               
              <%for(modeleE.Seance s1:JLseance1){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
                 <% 
                 
                 ArrayList<modeleE.Seance> JLseance2=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Jrs3=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='jeudi' and heured='11:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='jeudi' and heured='11:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        JLseance2.add(s); 
        	}} %>     
            <td><div class="bloc"><div class="select"><select  name="23"><%if(!Jrs3.next()){ %><option value="<%=-1%>"></option> <%}else{ %><option value="<%=Jrs3.getInt("idséance")%>"><%=Jrs3.getInt("idmodule")%><%=Jrs3.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>  
              <%for(modeleE.Seance s1:JLseance2){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>    
              
                 <% 
                 
                 ArrayList<modeleE.Seance> JLseance3=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Jrs4=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='jeudi' and heured='13:00'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='jeudi' and heured='13:00'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        JLseance3.add(s); 
        	}} %>     
                 <td><div class="bloc"><div class="select"><select name="24"><%if(!Jrs4.next()){ %><option value="<%=-1%>"></option > <%}else{ %><option value="<%=Jrs4.getInt("idséance")%>"><%=Jrs4.getInt("idmodule")%><%=Jrs4.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>  
              <%for(modeleE.Seance s1:JLseance3){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td> 
              
              
                 <% 
                 
                 ArrayList<modeleE.Seance> JLseance5=new ArrayList<modeleE.Seance>();
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                 ResultSet Jrs6=stmt.executeQuery("select * from séance where  idenseignant="+idens+"   and jour='jeudi' and heured='14:30'");
               
                 for (Integer idm:Lmodule){
                 Class.forName("com.mysql.jdbc.Driver");
                 cn= (Connection)DriverManager.getConnection(url,user,passwd);
                 stmt=cn.createStatement();
                  rs=stmt.executeQuery("select * from séance where idmodule="+idm+" and idenseignant is null  and jour='jeudi' and heured='14:30'");
           while(rs.next()){
        modeleE.Seance s=new modeleE.Seance(rs.getInt("idséance"),rs.getString("heureD"),rs.getString("heureF"),rs.getInt("idmodule"),rs.getString("type"));
        JLseance5.add(s); 
        	}} %>     
                 <td><div class="bloc"><div class="select"><select name="25"><%if(!Jrs6.next()){ %><option value="<%=-1%>"></option > <%}else{ %><option value="<%=Jrs6.getInt("idséance")%>"><%=Jrs1.getInt("idmodule")%><%=Jrs6.getString("type")%></option>
              <option value="<%=0%>"></option><%}%>  
              <%for(modeleE.Seance s1:JLseance5){ %>
                              <option value ="<%=s1.getIdSeance()%>"><%= L.SelectionnerModule(s1.getIdmodule())%><%= s1.getType()%></option>
                             <%} %>
</select></div></div>
              
              
              </td>     
                      
       </tr>
       
       </tbody>
       </table> 
      
       </div>
      </div>
       <div class="col-md-4 ml-auto mr-auto">
       <input class="btn btn-primary btn-round" type="submit" value="submit">
       </div>
      </form>
      
     
     
      </div>
       </div>
      </div>
      </div>
  <footer class="footer">
        <div class="container-fluid">
          <nav class="float-left">
            <ul>
              <li>
                <a href="https://www.univ-constantine2.dz/presentation-de-luniversite/">
                  Blog
                </a>
              </li>
           </ul>
          </nav>
          <div class="copyright float-right">
           Copyright &copy;
            <script>
              document.write(new Date().getFullYear())
            </script>,
            <a > Faculté des Nouvelles Technologies de l'Information et de la Communication NTIC. <br>
            Adresse :Université Constantine 2 - Abdelhamid Mehri
Ali Mendjeli - BP : 67A, Constantine - Algérie.
        </div>
      </footer>
    </div>
  </div>
  
  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Plugin for the momentJs  -->
  <script src="../assets/js/plugins/moment.min.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="../assets/js/plugins/sweetalert2.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="../assets/js/plugins/jquery.validate.min.js"></script>
  <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="../assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="../assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="../assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="../assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="../assets/js/plugins/jasny-bootstrap.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="../assets/js/plugins/fullcalendar.min.js"></script>
  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="../assets/js/plugins/jquery-jvectormap.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="../assets/js/plugins/nouislider.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="../assets/js/plugins/arrive.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="../assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/material-dashboard.js?v=2.1.2" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../assets/demo/demo.js"></script>
  <script>
    $(document).ready(function() {
      $().ready(function() {
        $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

        if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
          if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
            $('.fixed-plugin .dropdown').addClass('open');
          }

        }

        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        $('.fixed-plugin .img-holder').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).parent('li').siblings().removeClass('active');
          $(this).parent('li').addClass('active');


          var new_image = $(this).find("img").attr('src');

          if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
              $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
              $sidebar_img_container.fadeIn('fast');
            });
          }

          if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
              $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
              $full_page_background.fadeIn('fast');
            });
          }

          if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
          }
        });

        $('.switch-sidebar-image input').change(function() {
          $full_page_background = $('.full-page-background');

          $input = $(this);

          if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
              $sidebar_img_container.fadeIn('fast');
              $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
              $full_page_background.fadeIn('fast');
              $full_page.attr('data-image', '#');
            }

            background_image = true;
          } else {
            if ($sidebar_img_container.length != 0) {
              $sidebar.removeAttr('data-image');
              $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
              $full_page.removeAttr('data-image', '#');
              $full_page_background.fadeOut('fast');
            }

            background_image = false;
          }
        });

        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');

              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
  </script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
</body>
</html>