package com.andey.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by jiangbin on 2019/1/3.
 */
@RestController
public class POIUtilsController {

    @GetMapping(value = "/test")
    public void test(HttpServletResponse response) throws  Exception{


        Workbook workbook = new XSSFWorkbook(this.getClass().getResourceAsStream("/1.xlsx"));
        this.getClass().getResourceAsStream("/1.xlsx").close();
        response.setHeader("Content-disposition", "attachment;filename=" + "test.xlsx");
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

//
//    /**
//     * 获取当前行数据
//     * @param cell
//     * @return
//     */
//    @SuppressWarnings("deprecation")
//    private static String getCellValue(Cell cell){
//        String cellValue = "";
//
//        if(cell == null){
//            return cellValue;
//        }
//        //把数字当成String来读，避免出现1读成1.0的情况
//        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
//            cell.setCellType(Cell.CELL_TYPE_STRING);
//        }
//        //判断数据的类型
//        switch(cell.getCellType()){
//            case Cell.CELL_TYPE_NUMERIC://数字
//                cellValue = String.valueOf(cell.getNumericCellValue());
//                break;
//            case Cell.CELL_TYPE_STRING://字符串
//                cellValue = String.valueOf(cell.getStringCellValue());
//                break;
//            case Cell.CELL_TYPE_BOOLEAN://Boolean
//                cellValue = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_FORMULA://公式
//                cellValue = String.valueOf(cell.getCellFormula());
//                break;
//            case Cell.CELL_TYPE_BLANK://空值
//                cellValue = "";
//                break;
//            case Cell.CELL_TYPE_ERROR://故障
//                cellValue = "非法字符";
//                break;
//            default:
//                cellValue = "未知类型";
//                break;
//        }
//        return cellValue;
//    }
//
//    /**
//     * 获得工作簿对象
//     * @param formFile
//     * @return
//     */
//    public static Workbook getWorkBook(MultipartFile formFile){
//        //获得文件名
////		String fileName = formFile.getName();
//        String fileName = formFile.getOriginalFilename();
//        //创建Workbook工作簿对象，表示整个excel
//        Workbook workbook = null;
//        try {
//            //获得excel文件的io流
//            InputStream is = formFile.getInputStream();
//            //根据文件后缀名不同（xls和xlsx）获得不同的workbook实现类对象
//            if(fileName.endsWith(XLS)){
//                //2003
//                workbook = new HSSFWorkbook(is);
//            }else if(fileName.endsWith(XLSX)){
//                //2007
//                workbook = new XSSFWorkbook(is);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return workbook;
//    }


}
