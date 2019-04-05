package com.popo.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.popo.jdbc.DBhelper;
import com.popo.jdbc.GetData;
import com.popo.po.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@WebServlet("/Excelservlet")
public class Excelservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Excelservlet() {
		super();
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");//响应正文的MIME类型，表示Excel

       ServletOutputStream out = response.getOutputStream();//响应输出流对象

        HSSFWorkbook wb = new HSSFWorkbook();             //创建Excel表格

        HSSFSheet  sheet = wb.createSheet("学生信息表");//创建工作簿

        sheet.setColumnWidth(100, 10000);                          //设置列宽

        HSSFRow titleRow = sheet.createRow(0);            //创建Excel中的标题行

        HSSFCell titleCell1 =titleRow .createCell(0);          //在行中创建第1个单元格

        titleCell1.setCellValue("ID");               //设置第1个单元格的值

        HSSFCell titleCell2= titleRow.createCell(1);           //在行中创建第2个单元格

        titleCell2.setCellValue("姓名");                      //设置第2个单元格的值

        HSSFCell titleCell3 =titleRow .createCell(2);          //在行中创建第3个单元格

        titleCell3.setCellValue("性别");                      //设置第3个单元格的值
        
        HSSFCell titleCell4= titleRow.createCell(3);             //在行中创建第4个单元格
        titleCell4.setCellValue("编号");                         //设置第4个单元格的值
        
        List<Stu> list = new ArrayList<Stu>();
        try {
			list = new GetData().getAllByDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
  for(int i = 0; i < list.size(); i++){
	  
        HSSFRow valueRow = sheet.createRow(i+1);         //创建第2行

        HSSFCell nameCell = valueRow.createCell(0);              //在第2行中创建单元格

        nameCell.setCellValue(list.get(i).getId());

        HSSFCell pwdCell = valueRow.createCell(1);

        pwdCell.setCellValue(list.get(i).getName());

        HSSFCell sexCell = valueRow.createCell(2);

        sexCell.setCellValue(list.get(i).getSex());

        HSSFCell ageCell = valueRow.createCell(3);

        ageCell.setCellValue(list.get(i).getNum());

        HSSFCellStyle cellStyle = wb.createCellStyle();
  }
        wb.write(out);                              //将响应流输入到Excel表格中
        response.addHeader("Content-Disposition", "attachment;filename=demo.xls");//文件临时保存在demo.xls中
        out.flush();

        out.close();

  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

