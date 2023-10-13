<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head><style>
#clock h2 {
position:relative;
display:block;
color:green;
tetx-align:center;
margin-right:0px ;
font-weight:700;
text-transform:uppercase;
letter-spacing:0.4em;
font-size:0.8em;
}
#clock #time{ 
display:flex;
}
#clock #time div{
position:relative;
margin:0 5px;
-webkit-box-reflect:below 1px linear-gradient(transparent,#0004);
}
#clock #time div span{
position:relative;
dispaly:block;
width:70px;
height:60px;
background:#2196f3;
color:#fff;
font-weight:300;
display:flex;
justify-content:center;
align-items:center;
font-size:3em;
z-index:10;
box-shadow: 0 0 0 1px rgba(0,0,0,.2);

}
#clock #time div span:nth-child(2){
height:30px;
font-size:0.7em;
letter-spacing:500;
z-index:9;
box-shadow:none;
background:#127fd6;
text-transform:uppercase;
}
#clock #time div:last-child span{
background:#ff006a;
}
#clock #time div:last-child span:nth-child(2){
background:#ec0062;
}
</style>
<style>
body{
	margin:0;
	color:#444;
	background-color:#98c2c2;
	font:300 18px/18px Roboto, sans-serif;
	transition:background .4s ease-in-out 0s;
}
*,:after,:before{box-sizing:border-box}
.pull-left{float:left}
.pull-right{float:right}
.clearfix:after,.clearfix:before{content:'';display:table}
.clearfix:after{clear:both;display:block}

.calendar{width:300px;font-size:100%;margin-left: 750px;cursor:default;position:relative;}
.calendar .header{height:80px;position:relative;color:#fff}
.calendar .header .text{position:absolute;top:0;left:0;right:0;bottom:0;background-color:#308ff0;padding:15px;transform:rotateX(90deg);transform-origin:bottom;backface-visibility:hidden;transition:.4s ease-in-out 0s;box-shadow:0 6px 20px 0 rgba(0,0,0,.19), 0 8px 17px 0 rgba(0,0,0,.2);opacity:0}
.calendar .header .text>span{text-align:center;padding:26px;display:block}
.calendar .header.active .text{transform:rotateX(0deg);opacity:1}
.months{width:100%;height:260px;position:relative}
.months .hr{height:1px;margin:15px 0;background:#ccc}
.month{padding:15px;width:inherit;height:inherit;background:#fff;position:absolute;backface-visibility:hidden;transition:all .4s ease-in-out 0s;box-shadow:0 6px 20px 0 rgba(0,0,0,.19),0 8px 17px 0 rgba(0,0,0,.2)}
.months[data-flow="left"] .month{transform:rotateY(-180deg)}
.months[data-flow="right"] .month{transform:rotateY(180deg)}
.table{width:100%;font-size:10px;font-weight:400;display:table}
.table .row{display:table-row}
.table .row.head{color:#308ff0;text-transform:uppercase}
.table .row .cell{width:14.28%;padding:5px;text-align:center;display:table-cell}
.table .row .cell.disable{color:#ccc}
.table .row .cell span{display:block;width:28px;height:28px;line-height:28px;transition:color,background .4s ease-in-out 0s}
.table .row .cell.active span{color:#fff;background-color:#308ff0}
.months .month[data-active="true"]{transform:rotateY(0)}
.header [data-action]{color:inherit;position:absolute;top:50%;margin-top:-20px;width:40px;height:40px;z-index:1;opacity:0;transition:all .4s ease-in-out 0s}
.header [data-action]>i{width:20px;height:20px;display:block;position:absolute;left:50%;top:50%;margin-top:-10px;margin-left:-10px}
.header [data-action]>i:before,.header [data-action]>i:after{top:50%;margin-top:-1px;content:'';position:absolute;height:2px;width:20px;border-top:2px solid;border-radius:2px}
.header [data-action*="prev"]{left:15px}
.header [data-action*="next"]{right:15px}
.header [data-action*="prev"]>i:before,.header [data-action*="prev"]>i:after{left:0}
.header [data-action*="prev"]>i:before{top:3px;transform:rotate(-45deg)}
.header [data-action*="prev"]>i:after{top:auto;bottom:3px;transform:rotate(45deg)}
.header [data-action*="next"]>i:before,.header [data-action*="next"]>i:after{right:0}
.header [data-action*="next"]>i:before{top:auto;bottom:3px;transform:rotate(-45deg)}
.header [data-action*="next"]>i:after{top:3px;transform:rotate(45deg)}
.header.active [data-action]{opacity:1}

[data-theme="jan"]{background-color:#90CAF9}
[data-theme="jan"] .row.head{color:#1E88E5}
[data-theme="jan"] .header .text,
[data-theme="jan"] .table .row .cell.active span{background-color:#1E88E5}

[data-theme="feb"]{background-color:#81D4FA}
[data-theme="feb"] .row.head{color:#039BE5}
[data-theme="feb"] .header .text,
[data-theme="feb"] .table .row .cell.active span{background-color:#039BE5}

[data-theme="mar"]{background-color:#80CBC4}
[data-theme="mar"] .row.head{color:#00897B}
[data-theme="mar"] .header .text,
[data-theme="mar"] .table .row .cell.active span{background-color:#00897B}

[data-theme="apr"]{background-color:#C5E1A5}
[data-theme="apr"] .row.head{color:#7CB342}
[data-theme="apr"] .header .text,
[data-theme="apr"] .table .row .cell.active span{background-color:#7CB342}

[data-theme="may"]{background-color:#FFE082}
[data-theme="may"] .row.head{color:#FFB300}
[data-theme="may"] .header .text,
[data-theme="may"] .table .row .cell.active span{background-color:#FFB300}

[data-theme="jun"]{background-color:#FFAB91}
[data-theme="jun"] .row.head{color:#F4511E}
[data-theme="jun"] .header .text,
[data-theme="jun"] .table .row .cell.active span{background-color:#F4511E}

[data-theme="jul"]{background-color:#CE93D8}
[data-theme="jul"] .row.head{color:#8E24AA}
[data-theme="jul"] .header .text,
[data-theme="jul"] .table .row .cell.active span{background-color:#8E24AA}

[data-theme="aug"]{background-color:#B39DDB}
[data-theme="aug"] .row.head{color:#5E35B1}
[data-theme="aug"] .header .text,
[data-theme="aug"] .table .row .cell.active span{background-color:#5E35B1}

[data-theme="sep"]{background-color:#EF9A9A}
[data-theme="sep"] .row.head{color:#E53935}
[data-theme="sep"] .header .text,
[data-theme="sep"] .table .row .cell.active span{background-color:#E53935}

[data-theme="oct"]{background-color:#CE93D8}
[data-theme="oct"] .row.head{color:#8E24AA}
[data-theme="oct"] .header .text,
[data-theme="oct"] .table .row .cell.active span{background-color:#8E24AA}

[data-theme="nov"]{background-color:#BCAAA4}
[data-theme="nov"] .row.head{color:#6D4C41}
[data-theme="nov"] .header .text,
[data-theme="nov"] .table .row .cell.active span{background-color:#6D4C41}

[data-theme="dec"]{background-color:#B0BEC5}
[data-theme="dec"] .row.head{color:#546E7A}
[data-theme="dec"] .header .text,
[data-theme="dec"] .table .row .cell.active span{background-color:#546E7A}</style>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/logo.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Home Administrateur
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
          height: 65px; "">
          Bienvenue</br>
        ${sessionScope.n}
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav ">
          <li class="nav-item active ">
            <a class="nav-link" href="./homeADMIN.jsp">
              <i class="material-icons">home</i>
              <p>Home</p>
            </a>
          </li>
        
            <li class="nav-item ">
            <a class="nav-link" href="./EspEtudiant.jsp">
              <i class="material-icons">folder_shared</i>
              <p>Espace Etudiant</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./EspEnseignant.jsp">
              <i class="material-icons">people_alt</i>
              <p>Espace Enseignant</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./EspModule.jsp">
              <i class="material-icons">library_books</i>
              <p>Espace Module</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./EspSeance.jsp">
              <i class="material-icons">schedule</i>
              <p>Espace Séance</p>
            </a>
          </li>
          
      <li class="nav-item ">
            <a class="nav-link" href="./user.jsp">
              <i class="material-icons">person</i>
              <p>User Profile</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" >Accés Rapide</a></br>
          </div>
          
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="homeADMIN.jsp">
                  <i class="material-icons">home</i>
                 
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
         
           
               <div id="clock">
            <h2>the time now is</h2>
            <div id="time">
            <div><span id="hour">00</span><span>hours</span></div>
            <div><span id="minutes">00</span><span>minutes</span></div>
            <div><span id="seconds">00</span><span>seconds</span></div>
            </div>
            </div>
                        <div class="calendar">
	<div class="header">
		<a data-action="prev-month" href="javascript:void(0)" title="Previous Month"><i></i></a>
		<div class="text" data-render="month-year"></div>
		<a data-action="next-month" href="javascript:void(0)" title="Next Month"><i></i></a>
	</div>
	<div class="months" data-flow="left">
		<div class="month month-a">
			<div class="render render-a"></div>
		</div>
		<div class="month month-b">
			<div class="render render-b"></div>
		</div>
	</div>
</div>
    
           
          </div>
          <div class="row">
            <div class="col-md-4">
              <div class="card card-chart">
                <div class="card-header card-header-success">
                
                   <i class="material-icons">recent_actors<p>coucou</p></i>
                </div>
                <div class="card-body">
                  <h4 class="card-title">Consulter la liste des étudiants</h4>
                 <p class="card-category"></p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons text-danger">vertical_split</i> 
                    <a href="http://localhost:8080/gestion/ConsulterET">Consulter</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-4">
              <div class="card card-chart">
                <div class="card-header card-header-warning">
                    <i class="material-icons">recent_actors<p>coucou</p></i>
                </div>
                <div class="card-body">
                  <h4 class="card-title ">Consulter la liste des enseignant</h4>
                  <p class="card-category"></p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons text-danger">vertical_split</i> 
                    <a href="http://localhost:8080/gestion/ConsulterEns">Consulter</a>
                  </div>
                </div>
              </div>
            </div>
             
            <div class="col-md-4">
              <div class="card card-chart">
                <div class="card-header card-header-danger">
                 <i class="material-icons">recent_actors<p>coucou</p></i>
                </div>
                <div class="card-body">
                  <h4 class="card-title">Consulter la liste des modules</h4>
                  <p class="card-category"> </p>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons text-danger">vertical_split</i> 
                     <a href="http://localhost:8080/gestion/ConsulterMOD" >Consulter</a>
                    
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
            <a >Université Abdelhamid Mehri - Constantine 2. Tous les droits sont réservés.
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
  <script >
var Calendar = function(t) {
    this.divId = t.RenderID ? t.RenderID : '[data-render="calendar"]', this.DaysOfWeek = t.DaysOfWeek ? t.DaysOfWeek : ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"], this.Months = t.Months ? t.Months : ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    var e = new Date;
    this.CurrentMonth = e.getMonth(), this.CurrentYear = e.getFullYear();
    var r = t.Format;
    this.f = "string" == typeof r ? r.charAt(0).toUpperCase() : "M"
};
Calendar.prototype.nextMonth = function() {
    11 == this.CurrentMonth ? (this.CurrentMonth = 0, this.CurrentYear = this.CurrentYear + 1) : this.CurrentMonth = this.CurrentMonth + 1, this.divId = '[data-active="false"] .render', this.showCurrent()
}, Calendar.prototype.prevMonth = function() {
    0 == this.CurrentMonth ? (this.CurrentMonth = 11, this.CurrentYear = this.CurrentYear - 1) : this.CurrentMonth = this.CurrentMonth - 1, this.divId = '[data-active="false"] .render', this.showCurrent()
}, Calendar.prototype.previousYear = function() {
    this.CurrentYear = this.CurrentYear - 1, this.showCurrent()
}, Calendar.prototype.nextYear = function() {
    this.CurrentYear = this.CurrentYear + 1, this.showCurrent()
}, Calendar.prototype.showCurrent = function() {
    this.Calendar(this.CurrentYear, this.CurrentMonth)
}, Calendar.prototype.checkActive = function() {
    1 == document.querySelector(".months").getAttribute("class").includes("active") ? document.querySelector(".months").setAttribute("class", "months") : document.querySelector(".months").setAttribute("class", "months active"), "true" == document.querySelector(".month-a").getAttribute("data-active") ? (document.querySelector(".month-a").setAttribute("data-active", !1), document.querySelector(".month-b").setAttribute("data-active", !0)) : (document.querySelector(".month-a").setAttribute("data-active", !0), document.querySelector(".month-b").setAttribute("data-active", !1)), setTimeout(function() {
        document.querySelector(".calendar .header").setAttribute("class", "header active")
    }, 200), document.querySelector("body").setAttribute("data-theme", this.Months[document.querySelector('[data-active="true"] .render').getAttribute("data-month")].toLowerCase())
}, Calendar.prototype.Calendar = function(t, e) {
    "number" == typeof t && (this.CurrentYear = t), "number" == typeof t && (this.CurrentMonth = e);
    var r = (new Date).getDate(),
        n = (new Date).getMonth(),
        a = (new Date).getFullYear(),
        o = new Date(t, e, 1).getDay(),
        i = new Date(t, e + 1, 0).getDate(),
        u = 0 == e ? new Date(t - 1, 11, 0).getDate() : new Date(t, e, 0).getDate(),
        s = "<span>" + this.Months[e] + " &nbsp; " + t + "</span>",
        d = '<div class="table">';
    d += '<div class="row head">';
    for (var c = 0; c < 7; c++) d += '<div class="cell">' + this.DaysOfWeek[c] + "</div>";
    d += "</div>";
    for (var h, l = dm = "M" == this.f ? 1 : 0 == o ? -5 : 2, v = (c = 0, 0); v < 6; v++) {
        d += '<div class="row">';
        for (var m = 0; m < 7; m++) {
            if ((h = c + dm - o) < 1) d += '<div class="cell disable">' + (u - o + l++) + "</div>";
            else if (h > i) d += '<div class="cell disable">' + l++ + "</div>";
            else {
                d += '<div class="cell' + (r == h && this.CurrentMonth == n && this.CurrentYear == a ? " active" : "") + '"><span>' + h + "</span></div>", l = 1
            }
            c % 7 == 6 && h >= i && (v = 10), c++
        }
        d += "</div>"
    }
    d += "</div>", document.querySelector('[data-render="month-year"]').innerHTML = s, document.querySelector(this.divId).innerHTML = d, document.querySelector(this.divId).setAttribute("data-date", this.Months[e] + " - " + t), document.querySelector(this.divId).setAttribute("data-month", e)
}, window.onload = function() {
    var t = new Calendar({
        RenderID: ".render-a",
        Format: "M"
    });
    t.showCurrent(), t.checkActive();
    var e = document.querySelectorAll(".header [data-action]");
    for (i = 0; i < e.length; i++) e[i].onclick = function() {
        if (document.querySelector(".calendar .header").setAttribute("class", "header"), "true" == document.querySelector(".months").getAttribute("data-loading")) return document.querySelector(".calendar .header").setAttribute("class", "header active"), !1;
        var e;
        document.querySelector(".months").setAttribute("data-loading", "true"), this.getAttribute("data-action").includes("prev") ? (t.prevMonth(), e = "left") : (t.nextMonth(), e = "right"), t.checkActive(), document.querySelector(".months").setAttribute("data-flow", e), document.querySelector('.month[data-active="true"]').addEventListener("webkitTransitionEnd", function() {
            document.querySelector(".months").removeAttribute("data-loading")
        }), document.querySelector('.month[data-active="true"]').addEventListener("transitionend", function() {
            document.querySelector(".months").removeAttribute("data-loading")
        })
    }
};
</script>
 <script>
  function clock(){
	  
	  var hours =document.getElementById('hour');
	  var minutes =document.getElementById('minutes');
	  var seconds =document.getElementById('seconds');
	  
	  var h=new Date().getHours();
	  var m=new Date().getMinutes();
	  var s=new Date().getSeconds();
	  
	  hours.innerHTML=h;
	  minutes.innerHTML=m;
	  seconds.innerHTML=s;
  }
  var interval=setInterval(clock,1000);
  
  
  </script>
</body>

</html>