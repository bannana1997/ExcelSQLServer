package com.popo.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.popo.po.Stu;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

public class ReadExcelHelper {
	 public List<Stu> readXls(InputStream is) throws IOException {
		        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		        Stu student = null;
		        List<Stu> list = new ArrayList<Stu>();
		        // Read the Sheet
		      for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
		           HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
		           if (hssfSheet == null) {
		               continue;
		            }
		            // Read the Row
		          for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
		              HSSFRow hssfRow = hssfSheet.getRow(rowNum);
		              if (hssfRow != null) {
	                   student = new Stu();
		                   HSSFCell id = hssfRow.getCell(0);
		                   HSSFCell name = hssfRow.getCell(1);
	                       HSSFCell sex = hssfRow.getCell(2);
		                   HSSFCell num = hssfRow.getCell(3);
		                   student.setId(Integer.parseInt(getValue(id)));
		                   student.setName(getValue(name));
		                   student.setSex(getValue(sex));
		                   student.setNum(Integer.parseInt(getValue(num)));
		                   list.add(student);
		               }
		              }
		       }
		         return list;
		   }
	 private String getValue(HSSFCell hssfCell) {
		          if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
		             return String.valueOf(hssfCell.getBooleanCellValue());
		       } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
		           return String.valueOf(hssfCell.getNumericCellValue());
		        } else {
		           return String.valueOf(hssfCell.getStringCellValue());
		        }
		     }

}
