<%@ page language="java" import="java.util.*" import="java.text.*" import="java.lang.Thread.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/css; charset=utf-8" />
<title>StudentsManSys</title>
<script type="text/javascript">
	//使用js 
		function check(){
                        if (file_form.file.value=="") {
                            window.alert('请选择文件');
                            return false;
                        }
                        if (file_form.file.value.substring(file_form.file.value
                             .lastIndexOf(".") + 1, file_form.file.value.length)
                             .toLowerCase() !== "xls" && file_form.file.value.substring(file_form.file.value
                             .lastIndexOf(".") + 1, file_form.file.value.length)
                             .toLowerCase() !== "xlsx") {
                            window.alert("文件格式不正确，excel文件！");
                            return false;
                        }              
		}
</script>
<style type="text/css">

.divbody{ 
margin:0px; 
padding:0px;
}

.divtime {
float:right;
width:20%; 
}
.div {
float:left;
width:100%; 
height:100%;
background-color:#DDDDDD;
font-family:Verdana,Arial,Helvetica,sans-serif;
}
.picture {
float:left;
font-family: arial, sans-serif; 
width:40%; 
margin:0; 
margin:0px 0;
}
/* common styling */
.title {
float:left;
font-family: arial, sans-serif; 
width:100%;
height:50px;
margin:0; 
margin:0px 0;
}
/* set up the overall width of the menu div, the font and the margins */
.menu {
float:right;
font-family: arial, sans-serif; 
width:535px; 
margin:0; 
margin:0px 0;
}
/* remove the bullets and set the margin and padding to zero for the unordered list */
.menu ul {
padding:0; 
margin:0;
list-style-type: none;
}
/* float the list so that the items are in a line and their position relative so that the drop down list will appear in the right place underneath each list item */
.menu ul li {
float:left; 
position:relative;
}
/* style the links to be 104px wide by 30px high with a top and right border 1px solid white. Set the background color and the font size. */
.menu ul li a, .menu ul li a:visited {
margin-top:5px;
display:block; 
text-align:center; 
text-decoration:none; 
width:104px; 
height:30px; 
color:#000; 
border:1px solid #fff;
border-width:1px 1px 0 0;
background:#7B68EE; 
line-height:30px; 
font-size:11px;
}
/* make the dropdown ul invisible */
.menu ul li ul {
display: none;
}
/* specific to non IE browsers */
/* set the background and foreground color of the main menu li on hover */
/* 当鼠标移动到li元素上时，它下面的a标签将会按照这个样式进行渲染 */
.menu ul li:hover a {
margin-top:0px;
width:108px; 
height:34px; 
color:#fff; 
background:#b3ab79;
}
/* make the sub menu ul visible and position it beneath the main menu list item */
.menu ul li:hover ul {
display:block; 
position:absolute; 
top:31px; 
left:0; 
width:105px;
}
/* style the background and foreground color of the submenu links */
/* 当鼠标移动到li元素上时，它下面的a标签将会按照这个样式进行渲染 */
.menu ul li:hover ul li a { 
display:block; 
background:#faeec7; 
color:#000;
}
/* style the background and forground colors of the links on hover */
.menu ul li:hover ul li a:hover {
background:#dfc184; 
color:#000;
}
</style>
</head>
<body class="divbody" bgcolor="white">

<div class="div" style="margin-top: 0px;"> <font size="7" color="black" face="Arial"> 联通Excel导入导出操作平台 </font>

<div class="menu" style="margin-top: 20px;"> 
<ul>
<li><a class="hide" href="content.jsp" target="Right"><font color="white" >首页</a>
</li>
<li><a class="hide" href="UsersClServlet?pageNow1=1&flag=fenye1" target="Right"><font color="white" >学生信息</a>
    <ul>
    <li><a href="addStudent.jsp" title="Modify student information" target="Right">添加学生信息</a></li>
    </ul>
</li>
<li><a class="hide" href="dormitoryMain.jsp" target="Right"><font color="white" >宿舍管理</a>
    <ul>
    <li><a href="UsersClServlet?pageNow2=1&flag=fenye2" title="Brief information query" target="Right">简要信息查询</a></li>
    </ul>
</li>
<li><a class="hide" href="visitorMain.jsp" target="Right"><font color="white" >来访登记</a>
    <ul>
    <li><a href="visitor.jsp" title="Visitor information and message" target="Right">来访者登记信息及留言</a></li>
    <li><a href="UsersClServlet?pageNow4=1&flag=fenye4" title="Check all visitor records" target="Right">查询所有来访者记录</a></li>
    </ul>
</li>
<li><a class="hide" href="UsersClServlet?pageNow3=1&flag=fenye3" target="Right"><font color="white" >宿舍评分</a>
</li>
</div>
<div id="localtime" class="divtime" style="margin-top: 30px;"></div>
<script type="text/javascript">
function showLocale(objD)
{
  var str,colorhead,colorfoot;
  var yy = objD.getYear();
   if(yy<1900) yy = yy+1900;
  var MM = objD.getMonth()+1;
   if(MM<10) MM = '0' + MM;
  var dd = objD.getDate();
   if(dd<10) dd = '0' + dd;
  var hh = objD.getHours();
   if(hh<10) hh = '0' + hh;
  var mm = objD.getMinutes();
   if(mm<10) mm = '0' + mm;
  var ss = objD.getSeconds();
   if(ss<10) ss = '0' + ss;
  var ww = objD.getDay();
   if ( ww==0 ) colorhead="<font color=\"#FF0000\">";
   if ( ww > 0 && ww < 6 ) colorhead="<font color=\"#373737\">";
   if ( ww==6 ) colorhead="<font color=\"#008000\">";
   if (ww==0) ww="星期日";
   if (ww==1) ww="星期一";
   if (ww==2) ww="星期二";
   if (ww==3) ww="星期三";
   if (ww==4) ww="星期四";
   if (ww==5) ww="星期五";
   if (ww==6) ww="星期六";
   colorfoot="</font>"
    str = colorhead + yy + "年" + MM + "月" + dd + "日" + hh + ":" + mm + ":" + ss + " " + ww + colorfoot;
   //alert(str);
            return str;
}
function tick()
{
  var today;
  today = new Date();
  document.getElementById("localtime").innerHTML = showLocale(today);
  window.setTimeout("tick()", 1000);
}
tick();
</script>
</div>
<frameset>
<iframe src="Integratedquery.jsp" border="0" noresize frameborder="1" name="Left" scrolling="no" align="left" width="329" height="619" > </iframe>
<iframe src="content.jsp" border="0"  noresize frameborder="1" name="Right" scrolling="no" align="right" height="619" width="1010"> </iframe>
</frameset>
</body>

</html>