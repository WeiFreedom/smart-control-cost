package com.wei.code;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JavaPdfOper {


    /**
     * 读取pdf内容
     *
     * @throws Exception
     */
    @Test
    public void readPdfFile() throws Exception {
        String path = "E:\\JavaProject\\smart-constrol-cost\\doc\\";
        String source = "国家医疗保障疾病诊断相关分组（CHS-DRG）细分组（1.0版）.pdf";
        PdfReader reader = new PdfReader(path + source);
        int pageNum = reader.getNumberOfPages();
        for (int index = 52; index <= pageNum; index++) {
            PdfTextExtractor.getTextFromPage(reader, index);
        }
    }

    /**
     * pdf分页
     */
    @Test
    public void pdfSplitPages() throws Exception {
        String path = "F:\\JavaProject\\smart-control-cost\\";
        String source = "国家医疗保障疾病诊断相关分组（CHS-DRG）细分组（1.0版）.pdf";
        // 1133+4
        copyPdf(path + source, path + "1.pdf", "1-1152");
        copyPdf(path + source, path + "2.pdf", "1153-1710");
        System.out.println("copy完成......");
    }

    /**
     * pdf平均分页
     */
    @Test
    public void pdfSplitAverage() throws Exception {
        String path = "F:\\JavaProject\\smart-control-cost\\doc\\";
        String source = "国家医疗保障疾病诊断相关分组（CHS-DRG）细分组（1.0版）.pdf";
        int aerage = 30;

        PdfReader reader = new PdfReader(path + source);
        int pageNum = reader.getNumberOfPages();

        //101 11*9 99 2  1-11 12-
        int startPage = 1;
        int endPage = pageNum;
        int cell = (int)Math.ceil(pageNum/aerage);
        for (int index = 0; index < aerage; index++) {
            if(index==aerage-1){
                endPage = pageNum;
            } else {
                endPage = cell + startPage - 1;
            }
            copyPdf(path + source, path + (index + 1) + ".pdf", startPage + "-" + endPage);
            //System.out.println( startPage + "-" + endPage);
            startPage = endPage + 1;
        }
//        System.out.println("copy完成......");
    }

    /**
     * pdf文档解析
     * @throws Exception
     */
    @Test
    public void analysisPdfFile() throws Exception{
        String[] MDCs = new String[] { "MDCA" ,"MDCB","MDCC", "MDCD", "MDCE",
                "MDCF", "MDCG", "MDCH", "MDCI", "MDCJ",
                "MDCK", "MDCL", "MDCM", "MDCN", "MDCO",
                "MDCP", "MDCQ", "MDCR", "MDCS", "MDCT",
                "MDCU", "MDCV", "MDCW", "MDCX", "MDCY", "MDCZ"};

        String path = "E:\\JavaProject\\smart-constrol-cost\\doc\\";
        String source = "国家医疗保障疾病诊断相关分组（CHS-DRG）细分组（1.0版）.pdf";
        int start = 35;//开始页码
        int end = 70;//结束页码
        PdfReader reader = new PdfReader(path + source);
        Rectangle rect1 = new Rectangle(0, 0, 290, 1297);
        RenderFilter filter1 = new RegionTextRenderFilter(rect1);
        TextExtractionStrategy strategy1 = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter1);

        Rectangle rect2 = new Rectangle(290, 0, 500, 1297);
        RenderFilter filter2 = new RegionTextRenderFilter(rect2);
        TextExtractionStrategy strategy2 = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter2);


        List<String> list = new LinkedList<>();
        for (int index = 19 + start; index <= 19 + end; index++) {
            String content1 = PdfTextExtractor.getTextFromPage(reader, index, strategy1);

            List<String> split1 = Arrays.asList( content1.split("\n"));
            list.addAll(split1);

            String content2 = PdfTextExtractor.getTextFromPage(reader, index, strategy2);

            list.addAll(Arrays.asList( content2.split("\n")));
        }
        //list.stream().forEach(System.out :: println);
        JavaExcelOper.savaDrgs(list);
    }

    /**
     * 复制pdf文档
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @param ranges     复制规则     "1-7"表示复制1到7页、"8-"表示复制从第八页之后到文档末尾
     */
    public void copyPdf(String sourceFile, String targetFile, String ranges) throws Exception {
        PdfReader pdfReader = new PdfReader(sourceFile);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(targetFile));
        pdfReader.selectPages(ranges);
        pdfStamper.close();
    }

    /**
     * 多个PDF合并功能
     *
     * @param files    多个PDF的路径
     * @param savePath 生成的新PDF绝对路径
     */
    public void mergePdfFiles(String[] files, String savePath) {
        if (files.length > 0) {
            try {
                Document document = new Document(new PdfReader(files[0]).getPageSize(1));
                PdfCopy copy = new PdfCopy(document, new FileOutputStream(savePath));
                document.open();
                for (String file : files) {
                    PdfReader reader = new PdfReader(file);
                    int n = reader.getNumberOfPages();
                    for (int j = 1; j <= n; j++) {
                        document.newPage();
                        PdfImportedPage page = copy.getImportedPage(reader, j);
                        copy.addPage(page);
                    }
                }
                document.close();
            } catch (IOException | DocumentException e) {
                e.printStackTrace();
            }
        }
    }


}
