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
		response.setContentType("application/vnd.ms-excel");//��Ӧ���ĵ�MIME���ͣ���ʾExcel

       ServletOutputStream out = response.getOutputStream();//��Ӧ���������

        HSSFWorkbook wb = new HSSFWorkbook();             //����Excel���

        HSSFSheet  sheet = wb.createSheet("ѧ����Ϣ��");//����������

        sheet.setColumnWidth(100, 10000);                          //�����п�

        HSSFRow titleRow = sheet.createRow(0);            //����Excel�еı�����

        HSSFCell titleCell1 =titleRow .createCell(0);          //�����д�����1����Ԫ��

        titleCell1.setCellValue("ID");               //���õ�1����Ԫ���ֵ

        HSSFCell titleCell2= titleRow.createCell(1);           //�����д�����2����Ԫ��

        titleCell2.setCellValue("����");                      //���õ�2����Ԫ���ֵ

        HSSFCell titleCell3 =titleRow .createCell(2);          //�����д�����3����Ԫ��

        titleCell3.setCellValue("�Ա�");                      //���õ�3����Ԫ���ֵ
        
        HSSFCell titleCell4= titleRow.createCell(3);             //�����д�����4����Ԫ��
        titleCell4.setCellValue("���");                         //���õ�4����Ԫ���ֵ
        
        List<Stu> list = new ArrayList<Stu>();
        try {
			list = new GetData().getAllByDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
  for(int i = 0; i < list.size(); i++){
	  
        HSSFRow valueRow = sheet.createRow(i+1);         //������2��

        HSSFCell nameCell = valueRow.createCell(0);              //�ڵ�2���д�����Ԫ��

        nameCell.setCellValue(list.get(i).getId());

        HSSFCell pwdCell = valueRow.createCell(1);

        pwdCell.setCellValue(list.get(i).getName());

        HSSFCell sexCell = valueRow.createCell(2);

        sexCell.setCellValue(list.get(i).getSex());

        HSSFCell ageCell = valueRow.createCell(3);

        ageCell.setCellValue(list.get(i).getNum());

        HSSFCellStyle cellStyle = wb.createCellStyle();
  }
        wb.write(out);                              //����Ӧ�����뵽Excel�����
        response.addHeader("Content-Disposition", "attachment;filename=demo.xls");//�ļ���ʱ������demo.xls��
        out.flush();

        out.close();

  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

