package com.popo.jdbc;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelPoi {
	public  void ReadExcel(String strpath) {
        String fileToBeRead = "C:\\Users\\Administrator\\Desktop\\demo.xls";
        System.out.println(strpath);
        Workbook workbook;
        try {
            if (fileToBeRead.indexOf(".xlsx") > -1) {
                workbook = new XSSFWorkbook(new FileInputStream(fileToBeRead));
            } else {
                workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
            }
            // HSSFWorkbook workbook = new HSSFWorkbook(new
            // FileInputStream(fileToBeRead)); //2003 ������Excel�������ļ�������
            // XSSFWorkbook workbook = new XSSFWorkbook(new
            // FileInputStream(fileToBeRead)); //2007,2010 ������Excel�������ļ�������
            Sheet sheet = workbook.getSheet("Sheet1"); // �����Թ����������
            int rows = sheet.getPhysicalNumberOfRows();// ��ȡ����
            int columns = 0;
            for (int r = 0; r < rows; r++) { // ѭ������������
                if (r == 0) {
                    // �ڵ�һ�б����м�����п��,��Ϊ�������п��ܻ��п�ֵ
                    columns = sheet.getRow(r).getLastCellNum();
                    continue;
                }
                // String value = "";
                StringBuilder sb = new StringBuilder();
                Row row = sheet.getRow(r); // ��ȡ��Ԫ����ָ�����ж���
                if (row != null) {
                    // int cells = row.getPhysicalNumberOfCells();// ��ȡһ���еĵ�Ԫ����

                    // int cells = row.getLastCellNum();// ��ȡһ�������Ԫ��ı�ţ���1��ʼ��
                    for (short c = 0; c < columns; c++) { // ѭ���������еĵ�Ԫ��
                        Cell cell = row.getCell((short) c);
                        if (cell != null) {
                            // value += getCellValue(cell) + ",";
                            sb.append(PoiUtil.getCellValue(cell)).append(" ");
                        }
                    }
                }
                // String[] str = value.split(",");
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
