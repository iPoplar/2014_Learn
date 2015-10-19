package cn.bmy.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelEx {
 
    /**   
     *   ����һ��Excel�ļ�POI
     *   @param   inputFile   ����ģ���ļ�·��   
     *   @param   outputFile   �����ļ�����ڷ�����·��   
     *   @param   dataList   ����������   
     *   @throws   Exception   
     *   @roseuid:   
     */ 

   public static void exportExcelFile(String inputFile,String outputFile,List dataList) throws Exception{
  //��ģ���ļ�����poi   
  POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(inputFile));
  //����ģ�幤����   
  HSSFWorkbook templatewb = new HSSFWorkbook(fs);
  //ֱ��ȡģ���һ��sheet����   
  HSSFSheet templateSheet = templatewb.getSheetAt(1);
  //�õ�ģ��ĵ�һ��sheet�ĵ�һ�ж���   Ϊ�˵õ�ģ����ʽ   
  HSSFRow templateRow = templateSheet.getRow(0);

  //HSSFSheet   timplateSheet   =   templatewb.getSheetAt(1);   
  //ȡ��Excel�ļ���������   
  int columns = templateSheet.getRow((short) 0).getPhysicalNumberOfCells();
  //  Debug.println("columns   is   :   " + columns);  //=========================
  //������ʽ����   
  HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];

  //һ���Դ��������е���ʽ����������   
  for (int s = 0; s < columns; s++) {
   //�õ�����ʵ��   
   styleArray[s] = templatewb.createCellStyle();
  }
	/*&nbsp
	ѭ����ÿһ����Ԫ����и�ֵ     
	*/  //��λ��   
  for (int rowId = 1; rowId < dataList.size(); rowId++) {
   //����ȡ��rowId������   ÿһ��������valueList   
   List valueList = (List) dataList.get(rowId - 1);
   //��λ��   
   for (int columnId = 0; columnId < columns; columnId++) {
    //����ȡ����Ӧ��colunmId�е�ֵ   
    //ÿһ����Ԫ���ֵ   
    String dataValue = (String) valueList.get(columnId);
    //ȡ��colunmId�еĵ�style   
    //ģ��ÿһ�е���ʽ   
    HSSFCellStyle style = styleArray[columnId];
    //ȡģ���colunmId�еĵ�Ԫ�����   
    //ģ�嵥Ԫ�����   
    HSSFCell templateCell = templateRow.getCell((short) columnId);
    //����һ���µ�rowId��   �ж���   
    //�½����ж���     
    HSSFRow hssfRow = templateSheet.createRow(rowId);
    //�����µ�rowId��   columnId��   ��Ԫ�����   
    //�½��ĵ�Ԫ�����   
    HSSFCell cell = hssfRow.createCell((short) columnId);
    //�����Ӧ��ģ�嵥Ԫ��   ��ʽΪ������   
    if (templateCell.getCellStyle().getLocked() == false) {
     //���ô���styleΪ������   
     style.setLocked(false);
     //���õ��µĵ�Ԫ����   
     cell.setCellStyle(style);
    }
    //������ʽΪ����   
    else {
     //���ô���styleΪ����   
     style.setLocked(true);
     //���õ��µ�Ԫ����   
     cell.setCellStyle(style);
    }
    //���ñ���   
    //TODO
    //cell.setEncoding(HSSFCell.ENCODING_UTF_16);
    //Debug.println("dataValue   :   "   +   dataValue);   
    //����ֵ   ͳһΪString   
    cell.setCellValue(dataValue);
   }
  }
  //����������   
  FileOutputStream fOut = new FileOutputStream(outputFile);
  //��ģ�������д������ļ���   
  templatewb.write(fOut);
  fOut.flush();

  //�����������ر��ļ�   
  fOut.close();

 } 
    
    /**
     * ��������ΪXLS��ʽ
     * @param fos ����Excel�ļ�Path
     * @param bo Ҫ���������
     */
    public static void  writeExcelBo(String fos, java.util.List info)
    {
     jxl.write.WritableWorkbook wwb;
     try
     {
      wwb= Workbook.createWorkbook(new File(fos));
      jxl.write.WritableSheet studentInfo= wwb.createSheet("����Ƽ�Э��2014���±�", 10);
      studentInfo.addCell(new jxl.write.Label(0, 1, "ѧ��֤��"));
      studentInfo.addCell(new jxl.write.Label(1, 1, "����"));
      studentInfo.addCell(new jxl.write.Label(2, 1, "רҵ"));
      studentInfo.addCell(new jxl.write.Label(3, 1, "��ϵ��ʽ"));
      studentInfo.addCell(new jxl.write.Label(4, 1, ""));
      int StuentSize=info.size();
      Student student = new Student();
      for (int i= 0; i < StuentSize; i++)
      {
    	  student = (Student) info.get(i);
    	  studentInfo.addCell(new jxl.write.Label(0, i+2, "" + student.getId()));
    	  studentInfo.addCell(new jxl.write.Label(1, i+2, "" + student.getName()));
    	  studentInfo.addCell(new jxl.write.Label(2, i+2, "" + student.getMajor()));
    	  studentInfo.addCell(new jxl.write.Label(3, i+2, "" + student.getPhone()));

      }
     
      studentInfo.addCell(new jxl.write.Label(0, 0, "����Ƽ�Э��2014����������"));
      wwb.write();
      // �ر�Excel����������
      wwb.close();
     } catch (IOException e){
     } catch (RowsExceededException e){
      
     } catch (WriteException e){
     }
    }
    
}