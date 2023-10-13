<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
      <%@page import="modele.*"  %>
       <%@page import="java.sql.*" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<style>
.bloc {
  display: flex;
  flex-direction: column;
  align-items : center;
  justify-content: center;
  height: 10vh;
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
  width: 320px;
  height: 45px;
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


/* Mise en place de la flèche */
.select::after {
  content: '\276F';
  position: absolute;
  top: 20%;
  right: 0;
  padding: 0 15px;
  background: white;
  pointer-events: none;
  transform: rotate(90deg);
  font-size: 1.5em;
  background: #F9F9F9;
}


.select:hover::after {
  color: #15E81F;
}

select option[value="samedi"] {
  background: #14A31A;
  color: white;
}

select option[value="dimanche"] {
  background: #14B31A;
  color: white;
}

select option[value="lundi"] {
  background: #10C417;
  color: white;
}
select option[value="mardi"] {
  background: #0AD113;
  color: white;
}
select option[value="mercredi"] {
  background: #0ACC13;
  color: white;
}

select option[value="jeudi"] {
  background: #0FF219;
  color: white;
}
select option[value="TD"] {
  background: #4DFF54;
  color: white;
}
select option[value="TP"] {
  background: #4DFF54;
  color: white;
}
select option[value="Cours"] {
  background: #4DFF54;
  color: white;
}
</style>
  <meta charset="UTF-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/logo.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Ajouter une séance
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" /> 
</head>
<body class="">
  <div class="wrapper ">
       <div class="sidebar" data-color="green" data-background-color="black" data-image="../assets/img/q.jpg">
 <li class="nav-item d-none d-md-block"><a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>   
        <div class="logo"><a class="simple-text logo-normal">
         <img src="../assets/img/logo2 (2).png" style="position:absolute;
         top:6px;
         left:14px;  
         width: 65px;
          height: 65px; "">
          Bienvenue</br>
         ${sessionScope.n}
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item  ">
            <a class="nav-link" href="./homeADMIN.jsp">
                <i class=""><img src="../assets/img/ho.png" style=" width: 24px;height: 24px;"></i>
              <p>Home</p>
            </a>
          </li>
        
            <li class="nav-item ">
            <a class="nav-link" href="./EspEtudiant.jsp">
               <i class=""><img src="../assets/img/fol.png" style=" width: 24px;height: 24px;"></i>
              <p>Espace Etudiant</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./EspEnseignant.jsp">
               <i class=""><img src="../assets/img/grp.png" style=" width: 24px;height: 24px;"></i>
              <p>Espace Enseignant</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./EspModule.jsp">
               <i class=""><img src="../assets/img/list.png" style=" width: 24px;height: 24px;"></i>
              <p>Espace Module</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="./EspSeance.jsp">
               <i class=""><img src="../assets/img/he.png" style=" width: 24px;height: 24px;"></i>
              <p>Espace Séance</p>
            </a>
          </li>
           <li class="nav-item ">
             <%
             int opp=(Integer)session.getAttribute("i");
     		
     		session.setAttribute("opid",opp);
    		%>
          
          
      <li class="nav-item ">
            <a class="nav-link" href="http://localhost:8080/gestion/SGererADMIN?opp=${sessionScope.opid}">
            <i class=""><img src="../assets/img/perb.png" style=" width: 24px;height: 24px;"></i>
              <p>User Profile </p>
            </a>
          </li>
     
        </ul>
      </div>
    </div>
            <%
        
          
    		

            String idfor=session.getAttribute("form").toString();
    		session.setAttribute("opid",opp);
  			System.out.println(idfor);
    		%>
          
     
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" >Espace séance</a>
          </div>
      
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="./homeADMIN.jsp">
                  <i class="material-icons">home</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
          
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                 <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                  <a class="dropdown-item" href="#">Mon profil</a>
                  <a class="dropdown-item" href="#">paramétre</a>
                  <div class="dropdown-divider"></div>
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
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Ajouter une séance</h4>
                  <p class="card-category">les informations</p>
                </div>
                <div class="card-body">
                   <form action="http://localhost:8080/gestion/lajoutSEANCE?idfor=<%=idfor %>" method="POST">

            <div class="col-md-0">
                        <div class="form-group">
                         
                          <input type="hidden" name="idf" value="<%=idfor%>" class="form-control"required>
                        </div>
                      </div>
                  
                    
                         <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">l'heure de début</label>
                          <input type="time" name="heureD"class="form-control"required>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">l'heure de fin</label>
                          <input type="time" name="heureF" class="form-control"required>
                        </div>
                      </div>
                    </div>
                       <div class="row">
                       <div class="col-md-6">
                                  <div class="form-group">
                      
                           <label style="color:black;">Jour</label>
                          <div class="bloc">
  <div class="select">
    <select name="j">
     <option  >Choisissez le jour?</option>
     <option  value="samedi">samedi</option>
       <option  value="dimanche">dimanche</option>
         <option  value="lundi">lundi</option>
           <option  value="mardi">mardi</option>
             <option  value="mercredi">mercredi</option>
               <option  value="jeudi">jeudi</option>
               
    </select>
  </div>
                          
                        </div>
                    </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
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
                       String q="SELECT m.abréviation from module m,formation f where m.idformation=f.idformation and f.abréviation='"+idfor+"'";
                       ResultSet R =  state.executeQuery(q);
                    	 %>
                           <label style="color:black;">Module</label>
                          <div class="bloc">
  <div class="select">
    <select name="m">
     <option  >Choisissez le module ?</option>
      <%  while(R.next()){%> 	
         <option value="<%=R.getString("abréviation") %>" style="background: #0F9415; color: white;"><%=R.getString("abréviation") %></option>
     
                     <%  }  %>
    </select>
  </div>
                          
                        </div>
                    </div>    
                    </div>
                    </div>
                     <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Salle/Amphi</label>
                          <input type="text" name="s"class="form-control"required>
                        </div>
                      </div>
                                 <div class="col-md-6">
                        <div class="form-group">
                         <%
                         
                      	 Class.forName(classforname);
                       cn =(Connection) DriverManager.getConnection(url,user,passwd);
                       state = cn.createStatement();
                       String ss="SELECT g.nom from groupe g,formation f where g.idformation=f.idformation and f.abréviation='"+idfor+"'";
                       ResultSet R1 =  state.executeQuery(ss);
                    	 %>
                           <label style="color:black;">Groupe</label>
                          <div class="bloc">
  <div class="select">
    <select name="g">
     <option value="null" >Choisissez le groupe ?</option>
      <%  while(R1.next()){%> 	
         <option value="<%=R1.getString("nom") %>" style="background: #0F9415; color: white;"><%=R1.getString("nom") %></option>
     
                     <%  }  %>
    </select>
  </div>
                          
                        </div>
                    </div>    
                    </div>
                    </div>
                     <div class="row">
                      <div class="col-md-6">
                                  <div class="form-group">
                      
                           <label style="color:black;">Type</label>
                          <div class="bloc">
  <div class="select">
    <select name="t">
     <option  >Choisissez le type?</option>
     <option  value="TD">TD</option>
       <option  value="TP">TP</option>
         <option  value="Cours">COURS</option>
    </select>
  </div>
                          
                        </div>
                    </div>
                      </div>
                       <div class="col-md-6">
                        <div class="form-group">
                         <%
                         
                      	 Class.forName(classforname);
                       cn =(Connection) DriverManager.getConnection(url,user,passwd);
                       state = cn.createStatement();
                       String scc="SELECT nom from section ";
                       ResultSet R7=  state.executeQuery(scc);
                    	 %>
                           <label style="color:black;">Section</label>
                          <div class="bloc">
  <div class="select">
    <select name="sc">
     <option  value="null">Choisissez la section</option>
      <%  while(R7.next()){%> 	
         <option value="<%=R7.getString("nom") %>" style="background: #0F9415; color: white;"><%=R7.getString("nom") %></option>
     
                     <%  }  %>
    </select>
  </div>
                          
                        </div>
                    </div>    
                    </div>
                      
                    </div>
                    
                    
                    <button type="submit" class="btn btn-primary pull-right">Ajouter</button>
                   
                  </form>
                </div>
              </div>
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
</body>

</html>