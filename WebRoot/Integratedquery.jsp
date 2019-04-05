<%@ page language="java" pageEncoding="utf-8"%>
<html>
	<head>
		<title>查询</title>
		 <link href="css/bootstrap.min.css" rel="stylesheet">
		<style type="text/css">
	
.div{ 
margin:0px; 
padding:0px;
}
  .div1{

     position:absolute;
       left:0px;
      top:0px;
      width:100%;
      height:100%;
   text-align:center;
  }
  .div2{
     position:relative;
       left:0px;
      top:60px;

  }
  .divstyle{
	border-left:1px solid #000;
	border-right:1px solid #000;
	border-top:1px solid #000;
	border-bottom:1px solid #000;
	width: 100%;
	height: 190px;
	}
	 .divstyletop{
	border-left:1px solid #000;
	border-right:1px solid #000;
	border-top:1px solid #000;
	border-bottom:1px solid #000;
	width: 100%;
	height: 100px;
	}
</style>
<script type="text/javascript">
	<!-- 
	//使用js 
		function check(){
			if(form1.keywords.value==""&&form1.conditions.value==""){
			window.alert("请输入查询关键字和相应条件！");
			return false;
			}
			if(form1.keywords.value==""){
			window.alert("请输入查询关键字！");
			return false;
			}
			if(form1.conditions.value==""){
		    window.alert("请选择相应的条件！");
		    return false;
		 	}
		 	return true;
		}
	-->
	</script>
	</head>
	<body class="div" bgcolor="white">
<div class="divstyletop">
<form id="file_form" action="ExcelImport"  method="post" enctype="multipart/form-data"  onSubmit="return check();">
<table align="center">
<tr>
<td> <input type="file" name="file" id="file_input" /> </td>
<td><input type="submit" value="上传Execl" id="upFile-btn"></td>
</tr>
</table>
</form>
<form action="ExcelUpload" method="post">
<table align="center">
<tr>
<td><input type="submit" value="下载Excel"></td>
</tr>
</table>
</form>
</div>
	<div style="height: 100px;"></div>
	<center>
	<div class="divstyle">
	<div class="div1" align=center style="margin-top: 200px;"><h4>任务查询</h4></div><p></p>
	<div class="div2" style="margin-top: 0px;">
<form name="form1" method="post" action="UsersClServlet?flag=fenye5&pageNowstu=1&pageNowdor=1&pageNowvis=1" target="Right">
	<table><tr><td style="width:35%">关键字:</td><td><input type="text" class="form-control" name="keywords" style="width:90%" required /></td></tr>
	<tr><td style="width:35%">选条件:</td><td><select class="form-control" style="width:98%" name="conditions" required>
	<option value="" selected>请选择</option>
	 <option value="name">姓名</option>
	 <option value="major">专业</option>
	 <option value="phone">电话</option>
	 <option value="dorNo">宿舍编号</option>
	 </select></td></tr>
	 </table>	<p></p>
		<div align=center><input type="submit" class="btn btn-info" value="查询" style="width:40%;" onclick="return check()"/></div>
		</form>
		</div>
		</div>
</center>
		</div>
	</body>
</html>
