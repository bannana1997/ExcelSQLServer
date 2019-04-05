package com.popo.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.popo.po.Stu;

public class Helper {
	// 读取单元格的值
    private String getValue(Cell cell) {
        String result = "";

        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            result = cell.getBooleanCellValue() + "";
            break;
        case Cell.CELL_TYPE_STRING:
            result = cell.getStringCellValue();
            break;
        case Cell.CELL_TYPE_FORMULA:
            result = cell.getCellFormula();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            // 可能是普通数字，也可能是日期
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                result = DateUtil.getJavaDate(cell.getNumericCellValue())
                        .toString();
            } else {
                result = cell.getNumericCellValue() + "";
            }
            break;
        }
        return result;
    }
    /***
     * 这种方法支持03，和07版本的excel读取
     * 但是对于合并的单元格，除了第一行第一列之外，其他部分读取的值为空
     * @param is
     * @throws SQLException 
     * @throws IOException 
     */
    public void importXlsx(Workbook wb) throws SQLException, IOException {
    	int flagint = 0;
    	InsertData insertData = new InsertData();
    	List<Stu> list = new ArrayList<Stu>();
    	Stu student = new Stu();
    	if(insertData.createBrandDatabase()){
        try {
            for (int i = 0, len = wb.getNumberOfSheets(); i < len; i++) {
                Sheet sheet = wb.getSheetAt(i);
                for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                    if (sheet == null) {
                        return;
                    }
                    Row row = sheet.getRow(j);
                    if(row==null){
                        return;
                    }
                    // 读取每一个单元格
                    for (int k = 0; k < row.getLastCellNum(); k++) {
                    	flagint = k;
                        Cell cell = row.getCell(k);
                        if (cell != null) {
                        	if(flagint==0){
                        	    student.setId(new Double(Double.parseDouble(getValue(cell))).intValue());
                        	}else if (flagint==1){
                        		student.setName(getValue(cell));
                        	}else if (flagint==2){
                        		student.setSex(getValue(cell));
                        	}else if (flagint==3){
                        		student.setNum(new Double(Double.parseDouble(getValue(cell))).intValue());
                        	}

                        }
                        System.out.println(getValue(cell));                        
                    }
                    System.out.println("------");
                    list.add(student);
                    insertData.InsertAllToDb(list);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	}
    }

}
