package com.zte.sms.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.zte.sms.entity.Student;

public class ExcelUtil {
	
	public static void exportStudent(List<Student> students,OutputStream outputStream){
		
		try {
			//1:创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//2:创建工作表
			HSSFSheet sheet = workbook.createSheet("学生信息");
			//设置行高和列宽
			sheet.setDefaultRowHeightInPoints(20);
			sheet.setDefaultColumnWidth(18);
			//合并单元格
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 5);
			//将第一行的第1-6列合并
			sheet.addMergedRegion(cellRangeAddress);
			//3:创建行
			//a.创建标题行，并设置标题
			//创建第一行
			HSSFRow rowTitle= sheet.createRow(0);
			//设置行高
			rowTitle.setHeightInPoints(40);
			//在该行上创建第一个单元格
			HSSFCell  cellTitle=rowTitle.createCell(0);
			//设置样式
			cellTitle.setCellStyle(createCellStyle(workbook,HSSFColor.RED.index,(short)28));
			
			//设置内容
			cellTitle.setCellValue("南林学生信息表");
			
			
			//b.创建列头行并设置列头
			
			
			
			//输出到硬盘
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//创建单元格样式
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short color, short fontSize) {
		// TODO Auto-generated method stub
		//创建单元格样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		//设置水平和垂直居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(color);
		font.setFontHeightInPoints(fontSize);
	    cellStyle.setFont(font);
		return cellStyle;
	}

}
