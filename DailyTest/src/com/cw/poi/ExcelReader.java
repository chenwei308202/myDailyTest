package com.labi.bsp.util;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	private String filePath;
	
	private Workbook workBook;
	
	private Sheet sheet;
	
	private Row row;
	
	private int sheetNum;
	
	private Logger logger=Logger.getLogger(this.getClass());

	public ExcelReader(String filePath, int sheetNum) {
		this.filePath = filePath;
		this.sheetNum = sheetNum;
	}
	
	public List<Map<String, String>> readExcel(){
		
		logger.info("开始解析execel【"+filePath+"】");
		
		FileInputStream file;
		try {
			
			if (filePath.lastIndexOf(".xlsx")>0) {
				file = new FileInputStream(filePath);
				workBook=new XSSFWorkbook(file);
			}else if (filePath.lastIndexOf(".xls")>0) {
				file = new FileInputStream(filePath);
				workBook=new HSSFWorkbook(file);
			}else {
				throw new RuntimeException("文件格式有误");
			}
			
		} catch (Exception e) {
			throw new RuntimeException("读取文件路径异常", e);
		}
		sheet = workBook.getSheetAt(sheetNum);
		
		row= sheet.getRow(0);
		
		if (row==null) {
			throw new RuntimeException("首行必须为表头");
		}
		
		int colNum= row.getPhysicalNumberOfCells();
		String [] colHeader=new String[colNum];
		
		for (int i = 0; i < colNum; i++) {
			colHeader[i]=getValueFormCell(row.getCell(i));
		}
		
		int lastRowNUm=sheet.getLastRowNum();
		List<Map<String, String>> dataList=new ArrayList<Map<String,String>>();
		
		for (int i = 1; i <= lastRowNUm; i++) {
			row=sheet.getRow(i);
			if (row!=null) {
				Map<String , String> map=new HashMap<String, String>();
				for (int j = 0; j < colNum; j++) {
						Cell cell=row.getCell(j);
					map.put(colHeader[j], getValueFormCell(cell));
				}
				dataList.add(map);
			}
		}
		
		return dataList;
	};
	
	private String getValueFormCell(Cell cell){
		String value="";
		if (cell!=null) {
			
			
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_FORMULA:
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					Date date=	cell.getDateCellValue();
					SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
					value=dateFormat.format(date);
				}else {
					DecimalFormat df = new DecimalFormat("0");  
					value= df.format(cell.getNumericCellValue()); 
				}
				break;
			case HSSFCell.CELL_TYPE_STRING:
				value=cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				double valueDouble= cell.getNumericCellValue();
				value=String.valueOf(valueDouble);
				break;
			default:
				break;
			}
		}
		return value;
	}
	
	
//	public static void main(String[] args) {
//		ExcelReader excelReader=new ExcelReader("f:/达内机构信息 -1.xlsx", 0);
//		excelReader.readExcel();
//	}
}
