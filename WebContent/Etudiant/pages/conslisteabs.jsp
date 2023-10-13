<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@page import="modele.ConsABS" %>
    <%@page import="java.util.ArrayList" %>
<%int i=0; %> 
     <%@page import="javax.servlet.http.HttpSession" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ page import="java.text.SimpleDateFormat" %>
       <%@page import= "java.time.*"%>
      <%@page import ="java.time.format.DateTimeFormatter"%>
       <%@page import ="java.util.Locale"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    border-color:green;
    box-shadow:0 0 8px 0 green;
  }
</style>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/logo.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Liste de mes absences
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
  <div class="wrapper">
    <div class="sidebar" data-color="green" data-background-color="black" data-image="../assets/img/log.jpg">
 <li class="nav-item d-none d-md-block"><a class="nav-link sidebartoggler waves-effect waves-light" href="javascript:void(0)" data-sidebartype="mini-sidebar"><i class="mdi mdi-menu font-24"></i></a></li>   
        <div class="logo"><a class="simple-text logo-normal">
         <img src="../assets/img/logo2 (2).png" style="position:absolute;
         top:6px;
         left:14px;  
         width: 65px;
          height: 65px; ">
          Bienvenue</br>
       ${sessionScope.n}
         <%
                  
              		int opp=(Integer)session.getAttribute("i");
    		       
  			
    		%>
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav ">
          <li class="nav-item  ">
            <a class="nav-link" href="./homeETU.jsp">
               <i class=""><img src="../assets/ima/emploi.png" style=" width: 24px;height: 24px;"></i>
              <p>Mon emploi du temps</p>
            </a>
          </li>
        
            <li class="nav-item active">
            <a class="nav-link" href="http://localhost:8080/gestion/ConsulterListeAbs?opp=<%=opp%>">     
               <i class=""><img src="../assets/ima/abs.png" style=" width: 24px;height: 24px;"></i>
              <p>Mon relevé des absences </p>
            </a>
          </li>
          
          <li class="nav-item ">
            <a class="nav-link" href="http://localhost:8080/gestion/ConsulterListeExclus?opp=<%=opp%>">
              <i class=""><img src="../assets/ima/exclu.png" style=" width: 24px;height: 24px;"></i>
              <p>La liste des exclus</p>
            </a>
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
            <a class="navbar-brand" ><%= dateInFrench %> </a>
             </div>
          
               <div class="collapse navbar-collapse justify-content-end">
               <form class="navbar-form">
              <div class="input-group no-border">
                <input type="text" name="search" id="search" class="form-control" placeholder="Search...">
                <button type="submit" class="btn btn-white btn-round btn-just-icon">
                 <i class=""><img src="../assets/ima/search.png" style=" width: 24px;height: 24px;"></i>
                 <div class="ripple-container"></div>
                </button>
              </div>
            </form>
               
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="./homeETU.jsp">
                  <i class=""><img src="../assets/ima/home.png" style=" width: 24px;height: 24px;"></i>
                </a>
              </li>
           
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <i class=""><img src="../assets/ima/user.png" style=" width: 24px;height: 24px;"></i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                    <a class="dropdown-item" href="http://localhost:8080/gestion/SProfileETU?opp=<%=opp%>">Mon profil</a>
                
                  <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="http://localhost:8080/gestion/Logout">Déconnecter</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
           <div class="content">
           
        <div class="container-fluid">
       
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary" >
                  <h4 class="card-title ">Mes absences</h4>
                  <p class="card-category" > </p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table" id="myTable">
             <thead class=" text-primary">
                        <th>
                          L'absence n°
                        </th>
                        <th>
                          Le jour d'absence
                        </th>
                        <th>
                          La date d'absence
                        </th>
                        <th>
                          L'heure de début
                        </th>
                        <th>
                          L'heure de fin
                        </th>
                        <th>
                         Module
                        </th>
                         <th>
                         Dans le
                        </th>
                        <th>
                         réponse réclamation
                        </th>
                       
                      </thead>
	
                      <tbody>
       
           <c:forEach var="list" items="${sessionScope.liste}">

			<tr>
			
			   
			    <td>  
			     
			   <%
			   i=i+1;
			   out.println(i);%>
			
				 </td>
				 
					
				<td><c:out value="${list.getJour()}"></c:out></td>
				<td><c:out value="${list.getDate()}"></c:out></td>
				<td><c:out value="${list.getHeureD()}"></c:out></td>
				<td><c:out value="${list.getHeureF()}"></c:out></td>
				<td><c:out value="${list.getModule()}"></c:out></td>
				<td><c:out value="${list.getType()}"></c:out></td>
				<td><c:out value="${list.getAnswer()}"></c:out></td>
			
				<td><form  action="http://localhost:8080/gestion/Sjustifier?opp=<%=opp%>" method="POST" enctype="multipart/form-data">
				
				 <input type="hidden" name="ab" value="${list.getIdabsence()}">
				<input class="btn btn-primary btn-round"  type="file" name="p" >
                 
                 <button type="submit"  rel="tooltip" title="justifier" class="btn btn-primary btn-link btn-sm" style="margin-top:-55px;margin-left:280px;color:#357a5b;">
                                   <i class=""><img src="../assets/ima/send.png" style=" width: 24px;height: 24px;"></i>
                              </button>
           

         </form>
           <form action="http://localhost:8080/gestion/Sreclamer?ab=${list.getIdabsence()}&opp=<%=opp %>" method="POST" >
              <textarea type="text" rows = "2" name ="r" style="margin-left: 5.5%;">
           Saisissez votre réclamation...
         </textarea>
      
         <button type="submit"  rel="tooltip" title="réclamer" class="btn btn-primary btn-link btn-sm" style="margin-top:-55px;margin-left:300px;color:#357a5b;">
                                   <i class=""><img src="../assets/ima/send.png" style=" width: 24px;height: 24px;"></i>
                              </button>
           </form>
           
           	</td>
	     	
			</tr>
		
		</c:forEach>
		
		 </tbody>
		</table>
                  </div>
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
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
  <script>

$(document).ready(function(){  
           $('#search').keyup(function(){  
                search_table($(this).val());  
           });  
           function search_table(value){  
                $('#myTable tr').each(function(){  
                     var found = 'false';  
                     $(this).each(function(){  
                          if($(this).text().toLowerCase().indexOf(value.toLowerCase()) >= 0)  
                          {  
                               found = 'true';  
                          }  
                     });  
                     if(found == 'true')  
                     {  
                          $(this).show();  
                     }  
                     else  
                     {  
                          $(this).hide();  
                     }  
                });  
           }  
      });  
 </script>  
</body>
</html>
