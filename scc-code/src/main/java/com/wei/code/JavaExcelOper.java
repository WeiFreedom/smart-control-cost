package com.wei.code;

import com.wei.code.domain.Icd10;
import com.wei.code.domain.Icd_9_cm3;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaExcelOper {
    /**
     * 保存icd10诊断到excel
     *
     * @param list
     * @throws IOException
     */
    public static void savaIcd10(List<Icd10> list) throws IOException {
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        //创建工作表的行
        HSSFRow row = sheet.createRow(0);//设置第一行，从零开始
        row.createCell(0).setCellValue("IcdId");
        row.createCell(1).setCellValue("IcdPid");
        row.createCell(2).setCellValue("IcdCode");
        row.createCell(3).setCellValue("IcdName");
        row.createCell(4).setCellValue("Partnum");
        row.createCell(5).setCellValue("Codelength");
        row.createCell(6).setCellValue("Isclinical");
        row.createCell(7).setCellValue("Isusing");
        row.createCell(8).setCellValue("Remark");
        row.createCell(9).setCellValue("InitializationState");
        row.createCell(10).setCellValue("AddUserId");
        row.createCell(11).setCellValue("AddUserName");
        row.createCell(12).setCellValue("AddTime");
        row.createCell(13).setCellValue("LastUpdateUserId");
        row.createCell(14).setCellValue("LastUpdateUserName");
        row.createCell(15).setCellValue("LastUpdateTime");
        row.createCell(16).setCellValue("Level");
        row.createCell(17).setCellValue("Children");
        row.createCell(18).setCellValue("ApplyExplain");
        row.createCell(19).setCellValue("IcdAttachment");
        row.createCell(20).setCellValue("ClassCode");
        row.createCell(21).setCellValue("ClassName");
        row.createCell(22).setCellValue("DiagnoseCode");
        row.createCell(23).setCellValue("DiagnoseName");
        row.createCell(24).setCellValue("Open");
        row.createCell(25).setCellValue("IsParent");
        row.createCell(26).setCellValue("Mid");
        row.createCell(27).setCellValue("Subflag");
        row.createCell(28).setCellValue("ConfirmStatus");
        row.createCell(29).setCellValue("VerCode");
        row.createCell(30).setCellValue("VerName");
        row.createCell(31).setCellValue("ResourceAttachment");
        row.createCell(32).setCellValue("RefDefine");
        row.createCell(33).setCellValue("DiagnosticBasis");
        row.createCell(34).setCellValue("Version");
        row.createCell(35).setCellValue("ComfirmUserId");
        row.createCell(36).setCellValue("ComfirmUserName");
        row.createCell(37).setCellValue("ComfirmTime");
        row.createCell(38).setCellValue("Mcode");

        for (int index = 0; index < list.size(); index++) {
            HSSFRow rowIndex = sheet.createRow(index+1);

            Icd10 icd10 = list.get(index);
            rowIndex.createCell(0).setCellValue(icd10.getIcdId());
            rowIndex.createCell(1).setCellValue(icd10.getIcdPid());
            rowIndex.createCell(2).setCellValue(icd10.getIcdCode());
            rowIndex.createCell(3).setCellValue(icd10.getIcdName());
            rowIndex.createCell(4).setCellValue(icd10.getPartnum());
            rowIndex.createCell(5).setCellValue(icd10.getCodelength());
            rowIndex.createCell(6).setCellValue(icd10.getIsclinical());
            rowIndex.createCell(7).setCellValue(icd10.getIsusing());
            rowIndex.createCell(8).setCellValue(icd10.getRemark());
            rowIndex.createCell(9).setCellValue(icd10.getInitializationState());
            rowIndex.createCell(10).setCellValue(icd10.getAddUserId());
            rowIndex.createCell(11).setCellValue(icd10.getAddUserName());
            rowIndex.createCell(12).setCellValue(icd10.getAddTime());
            rowIndex.createCell(13).setCellValue(icd10.getLastUpdateUserId());
            rowIndex.createCell(14).setCellValue(icd10.getLastUpdateUserName());
            rowIndex.createCell(15).setCellValue(icd10.getLastUpdateTime());
            rowIndex.createCell(16).setCellValue(icd10.getLevel());
            rowIndex.createCell(17).setCellValue(icd10.getChildren());
            rowIndex.createCell(18).setCellValue(icd10.getApplyExplain());
            rowIndex.createCell(19).setCellValue(icd10.getIcdAttachment());
            rowIndex.createCell(20).setCellValue(icd10.getClassCode());
            rowIndex.createCell(21).setCellValue(icd10.getClassName());
            rowIndex.createCell(22).setCellValue(icd10.getDiagnoseCode());
            rowIndex.createCell(23).setCellValue(icd10.getDiagnoseName());
            rowIndex.createCell(24).setCellValue(icd10.getOpen());
            rowIndex.createCell(25).setCellValue(icd10.getIsParent());
            rowIndex.createCell(26).setCellValue(icd10.getMid());
            rowIndex.createCell(27).setCellValue(icd10.getSubflag());
            rowIndex.createCell(28).setCellValue(icd10.getConfirmStatus());
            rowIndex.createCell(29).setCellValue(icd10.getVerCode());
            rowIndex.createCell(30).setCellValue(icd10.getVerName());
            rowIndex.createCell(31).setCellValue(icd10.getResourceAttachment());
            rowIndex.createCell(32).setCellValue(icd10.getRefDefine());
            rowIndex.createCell(33).setCellValue(icd10.getDiagnosticBasis());
            rowIndex.createCell(34).setCellValue(icd10.getVersion());
            rowIndex.createCell(35).setCellValue(icd10.getComfirmUserId());
            rowIndex.createCell(36).setCellValue(icd10.getComfirmUserName());
            rowIndex.createCell(37).setCellValue(icd10.getComfirmTime());
            rowIndex.createCell(38).setCellValue(icd10.getMcode());
        }

        workbook.setSheetName(0, "sheet1");//设置sheet的Name
        //文档输出
        FileOutputStream out = new FileOutputStream("C:\\Users\\32927\\Desktop\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".xls");
        workbook.write(out);
        out.close();

    }

    public static void savaOper(List<Icd_9_cm3> list) throws Exception{
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        //创建工作表的行
        HSSFRow row = sheet.createRow(0);//设置第一行，从零开始
        row.createCell(0).setCellValue("OperationId");
        row.createCell(1).setCellValue("OperationPid");
        row.createCell(2).setCellValue("OperationCode");
        row.createCell(3).setCellValue("OperationName");
        row.createCell(4).setCellValue("Partnum");
        row.createCell(5).setCellValue("Codelength");
        row.createCell(6).setCellValue("Isclinical");
        row.createCell(7).setCellValue("Isusing");
        row.createCell(8).setCellValue("Remark");
        row.createCell(9).setCellValue("InitializationState");
        row.createCell(10).setCellValue("AddUserId");
        row.createCell(11).setCellValue("AddUserName");
        row.createCell(12).setCellValue("AddTime");
        row.createCell(13).setCellValue("LastUpdateUserId");
        row.createCell(14).setCellValue("LastUpdateUserName");
        row.createCell(15).setCellValue("LastUpdateTime");
        row.createCell(16).setCellValue("Level");
        row.createCell(17).setCellValue("ApplyExplain");
        row.createCell(18).setCellValue("OperationAttachment");
        row.createCell(19).setCellValue("ClassCode");
        row.createCell(20).setCellValue("ClassName");
        row.createCell(21).setCellValue("DiagnoseCode");
        row.createCell(22).setCellValue("DiagnoseName");
        row.createCell(23).setCellValue("Open");
        row.createCell(24).setCellValue("IsParent");
        row.createCell(25).setCellValue("Mid");
        row.createCell(26).setCellValue("Subflag");
        row.createCell(27).setCellValue("ConfirmStatus");
        row.createCell(28).setCellValue("Children");
        row.createCell(29).setCellValue("VerCode");
        row.createCell(30).setCellValue("VerName");
        row.createCell(31).setCellValue("RefDefine");
        row.createCell(32).setCellValue("Version");
        row.createCell(33).setCellValue("ComfirmUserId");
        row.createCell(34).setCellValue("ComfirmUserName");
        row.createCell(35).setCellValue("ComfirmTime");
        row.createCell(36).setCellValue("Mcode");

        for (int index = 0; index < list.size(); index++) {
            HSSFRow rowIndex = sheet.createRow(index+1);

            Icd_9_cm3 icd10 = list.get(index);
            rowIndex.createCell(0).setCellValue(icd10.getOperationId());
            rowIndex.createCell(1).setCellValue(icd10.getOperationPid());
            rowIndex.createCell(2).setCellValue(icd10.getOperationCode());
            rowIndex.createCell(3).setCellValue(icd10.getOperationName());
            rowIndex.createCell(4).setCellValue(icd10.getPartnum());
            rowIndex.createCell(5).setCellValue(icd10.getCodelength());
            rowIndex.createCell(6).setCellValue(icd10.getIsclinical());
            rowIndex.createCell(7).setCellValue(icd10.getIsusing());
            rowIndex.createCell(8).setCellValue(icd10.getRemark());
            rowIndex.createCell(9).setCellValue(icd10.getInitializationState());
            rowIndex.createCell(10).setCellValue(icd10.getAddUserId());
            rowIndex.createCell(11).setCellValue(icd10.getAddUserName());
            rowIndex.createCell(12).setCellValue(icd10.getAddTime());
            rowIndex.createCell(13).setCellValue(icd10.getLastUpdateUserId());
            rowIndex.createCell(14).setCellValue(icd10.getLastUpdateUserName());
            rowIndex.createCell(15).setCellValue(icd10.getLastUpdateTime());
            rowIndex.createCell(16).setCellValue(icd10.getLevel());
            rowIndex.createCell(17).setCellValue(icd10.getApplyExplain());
            rowIndex.createCell(18).setCellValue(icd10.getOperationAttachment());
            rowIndex.createCell(19).setCellValue(icd10.getClassCode());
            rowIndex.createCell(20).setCellValue(icd10.getClassName());
            rowIndex.createCell(21).setCellValue(icd10.getDiagnoseCode());
            rowIndex.createCell(22).setCellValue(icd10.getDiagnoseName());
            rowIndex.createCell(23).setCellValue(icd10.getOpen());
            rowIndex.createCell(24).setCellValue(icd10.getIsParent());
            rowIndex.createCell(25).setCellValue(icd10.getMid());
            rowIndex.createCell(26).setCellValue(icd10.getSubflag());
            rowIndex.createCell(27).setCellValue(icd10.getConfirmStatus());
            rowIndex.createCell(28).setCellValue(icd10.getChildren());
            rowIndex.createCell(29).setCellValue(icd10.getVerCode());
            rowIndex.createCell(30).setCellValue(icd10.getVerName());
            rowIndex.createCell(31).setCellValue(icd10.getRefDefine());
            rowIndex.createCell(32).setCellValue(icd10.getVersion());
            rowIndex.createCell(33).setCellValue(icd10.getComfirmUserId());
            rowIndex.createCell(34).setCellValue(icd10.getComfirmUserName());
            rowIndex.createCell(35).setCellValue(icd10.getComfirmTime());
            rowIndex.createCell(36).setCellValue(icd10.getMcode());
        }

        workbook.setSheetName(0, "sheet1");//设置sheet的Name
        //文档输出
        FileOutputStream out = new FileOutputStream("C:\\Users\\32927\\Desktop\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".xls");
        workbook.write(out);
        out.close();
    }

    public static void savaDrgs(List<String> strs) throws Exception{
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();

        for (int index = 0; index < strs.size(); index++) {
            HSSFRow rowIndex = sheet.createRow(index);
            rowIndex.createCell(0).setCellValue(strs.get(index));
        }

        workbook.setSheetName(0, "sheet1");//设置sheet的Name
        //文档输出
        FileOutputStream out = new FileOutputStream("C:\\Users\\32927\\Desktop\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".xls");
        workbook.write(out);
        out.close();
    }

    public static void savaMcExc(List<Map<String,String>> list) throws Exception{
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();

        for (int index = 0; index < list.size(); index++) {
            HSSFRow rowIndex = sheet.createRow(index);
            rowIndex.createCell(0).setCellValue(list.get(index).get("tc_mc_exc_code"));
            rowIndex.createCell(1).setCellValue(list.get(index).get("tc_diag_code"));
            rowIndex.createCell(2).setCellValue(list.get(index).get("tc_diag_name"));
        }

        workbook.setSheetName(0, "sheet1");//设置sheet的Name
        //文档输出
        FileOutputStream out = new FileOutputStream("C:\\Users\\32927\\Desktop\\drugs\\" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".xls");
        workbook.write(out);
        out.close();
    }
    public static void savaAdrg(Map<String, List<Map<String, String>>> map,List<Map<String, String>> allCondition,
                                String name) throws Exception{
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();//这里也可以设置sheet的Name
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet();
        List<Map<String, String>> list = new LinkedList<>();
        for(Map.Entry<String, List<Map<String, String>>> entry : map.entrySet()){
            List<Map<String, String>> value = entry.getValue();
            list.addAll(value);
        }

        for (int index = 0; index < list.size(); index++) {
            HSSFRow rowIndex = sheet.createRow(index);
            rowIndex.createCell(0).setCellValue(list.get(index).get("tc_adrg_code"));
            rowIndex.createCell(1).setCellValue(list.get(index).get("tc_diag_type"));
            rowIndex.createCell(2).setCellValue(list.get(index).get("tc_diag_code"));
            rowIndex.createCell(3).setCellValue(list.get(index).get("tc_diag_name"));
            rowIndex.createCell(4).setCellValue(list.get(index).get("tc_adrg_condition"));
        }

        workbook.setSheetName(0, "sheet1");//设置sheet的Name

        String filename =name+" "+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(allCondition.size()>0){
            filename = name+ " ";
            for(Map<String, String> item : allCondition){

                for (Map.Entry<String, String> entry: item.entrySet()){
                    filename += entry.getKey() + " " + entry.getValue() + " ";
                }
            }
        }

        //文档输出
        FileOutputStream out = new FileOutputStream("C:\\Users\\32927\\Desktop\\drugs\\" + filename + ".xls");
        workbook.write(out);
        out.close();
    }

    /**
     * 读取
     *
     * @throws IOException
     */
    public static void readIcd10() throws IOException {
        //获取系统文档
        POIFSFileSystem fspoi = new POIFSFileSystem(new FileInputStream("/Users/wangjun/temp/demo1.xls"));
        //创建工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook(fspoi);
        //创建工作表对象
        HSSFSheet sheet = workbook.getSheet("sheet1");
        //得到Excel表格
        HSSFRow row = sheet.getRow(1);
        //得到Excel工作表指定行的单元格
        HSSFCell cell = row.getCell(1);
        System.out.println(cell);
    }
}
