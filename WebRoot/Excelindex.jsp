<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载</title>
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
</head>
<body>
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
</body>
</html>
