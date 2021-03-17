package com.wei.code;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wei.code.domain.Disease;
import com.wei.code.domain.Icd10;
import com.wei.code.domain.Icd_9_cm3;
import com.wei.code.jdbc.JdbcTemplateUtils;
import com.wei.code.jdbc.JdbcUtils;
import com.wei.code.utils.PinyinUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JavaHttpRequest {

    /**
     * 保存icd10
     * @throws Exception
     */
    @Test
    public void icd10Request() throws Exception {
        String url = "http://code.nhsa.gov.cn:8000/jbzd/public/toStdIcdTreeList.html";
        // 添加form参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        String result = httpPost(url, nameValuePairs);
        if (result == null || result == "") {
            System.out.println("大分类查询个寂寞");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();

        List<Icd10> sava = new ArrayList<>();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Icd10.class);
        String sql = "insert into tb_contry_icd10 (icdId,icdPid,icdCode,icdName,partnum,codelength,isclinical,isusing,remark,initializationState,\n" +
                "addUserId,addUserName,addTime,lastUpdateUserId,lastUpdateUserName,lastUpdateTime,level,\n" +
                "children,applyExplain,icdAttachment,classCode,className,diagnoseCode,\n" +
                "diagnoseName,open,isParent,mid,subflag,confirmStatus,verCode,\n" +
                "verName,resourceAttachment,refDefine,diagnosticBasis,version,comfirmUserId,\n" +
                "comfirmUserName,comfirmTime,mcode) values (:icdId,:icdPid,:icdCode,:icdName,:partnum,:codelength,:isclinical,:isusing,:remark,:initializationState,\n" +
                ":addUserId,:addUserName,:addTime,:lastUpdateUserId,:lastUpdateUserName,:lastUpdateTime,:level,\n" +
                ":children,:applyExplain,:icdAttachment,:classCode,:className,:diagnoseCode,\n" +
                ":diagnoseName,:open,:isParent,:mid,:subflag,:confirmStatus,:verCode,:verName,\n" +
                ":resourceAttachment,:refDefine,:diagnosticBasis,:version,:comfirmUserId,\n" +
                ":comfirmUserName,:comfirmTime,:mcode)\n";
        List<Icd10> list = mapper.readValue(result, javaType);
        for (Icd10 map : list){
            sava.add(map);
        }

        for (Icd10 map : list) {
            nameValuePairs.clear();
            nameValuePairs.add(new BasicNameValuePair("icdId", map.getIcdId()));
            result = httpPost(url, nameValuePairs);
            if (result == null || result == "") {
                System.out.println("二级分类查询个寂寞");
                return;
            }

            //查询三级分类
            List<Icd10> secondarycategories = mapper.readValue(result, javaType);
            for (Icd10 secondarycategory : secondarycategories){
                sava.add(secondarycategory);
            }

            for (Icd10 secondarycategory : secondarycategories) {

                nameValuePairs.clear();
                nameValuePairs.add(new BasicNameValuePair("icdId", secondarycategory.getIcdId()));
                result = httpPost(url, nameValuePairs);
                if (result == null || result == "") {
                    System.out.println("三级分类查询个寂寞");
                    return;
                }
                List<Icd10> subcategories = mapper.readValue(result, javaType);
                for (Icd10 subcategory : subcategories){
                    sava.add(subcategory);
                }

                for (Icd10 subcategory : subcategories) {
                    nameValuePairs.clear();
                    nameValuePairs.add(new BasicNameValuePair("icdId", subcategory.getIcdId()));
                    result = httpPost(url, nameValuePairs);
                    if (result == null || result == "") {
                        System.out.println("小分类查询个寂寞");
                        return;
                    }
                    List<Icd10> icd10s = mapper.readValue(result, javaType);
                    for (Icd10 icd10 : icd10s) {
                        sava.add(icd10);
                    }
                }
            }
        }
        JavaExcelOper.savaIcd10(sava);
    }

    /**
     * 保存icd-9-cm-3
     * @throws Exception
     */
    @Test
    public void icd9cm3Request() throws Exception{
        String url = "http://code.nhsa.gov.cn:8000/jbzd/public/toStdOperationTreeList.html";
        // 添加form参数
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        String result = httpPost(url, nameValuePairs);
        if (result == null || result == "") {
            System.out.println("大分类查询个寂寞");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();

        List<Icd_9_cm3> sava = new ArrayList<>();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Icd_9_cm3.class);

        List<Icd_9_cm3> list = mapper.readValue(result, javaType);
        for (Icd_9_cm3 map : list){
            sava.add(map);
        }
        for (Icd_9_cm3 map : list) {
            nameValuePairs.clear();
            nameValuePairs.add(new BasicNameValuePair("operationId", map.getOperationId()));
            result = httpPost(url, nameValuePairs);
            if (result == null || result == "") {
                System.out.println("二级分类查询个寂寞");
                return;
            }

            //查询三级分类
            List<Icd_9_cm3> secondarycategories = mapper.readValue(result, javaType);
            for (Icd_9_cm3 secondarycategory : secondarycategories){
                sava.add(secondarycategory);
            }

            for (Icd_9_cm3 secondarycategory : secondarycategories) {

                nameValuePairs.clear();
                nameValuePairs.add(new BasicNameValuePair("operationId", secondarycategory.getOperationId()));
                result = httpPost(url, nameValuePairs);
                if (result == null || result == "") {
                    System.out.println("三级分类查询个寂寞");
                    return;
                }
                List<Icd_9_cm3> subcategories = mapper.readValue(result, javaType);
                for (Icd_9_cm3 subcategory : subcategories){
                    sava.add(subcategory);
                }

                for (Icd_9_cm3 subcategory : subcategories) {
                    nameValuePairs.clear();
                    nameValuePairs.add(new BasicNameValuePair("operationId", subcategory.getOperationId()));
                    result = httpPost(url, nameValuePairs);
                    if (result == null || result == "") {
                        System.out.println("小分类查询个寂寞");
                        return;
                    }
                    List<Icd_9_cm3> icd10s = mapper.readValue(result, javaType);
                    for (Icd_9_cm3 icd10 : icd10s) {
                        sava.add(icd10);
                    }
                }
            }
        }
        JavaExcelOper.savaOper(sava);
    }

    /**
     * 更新数据库拼音字段
     */
    @Test
    public void selectOne(){
        List<Disease> query = JdbcUtils.query("select * from tb_disease where tc_diag_code = '00.01'");
    }
    @Test
    public void updatePinyin(){
        List<Disease> query = JdbcUtils.query("select * from tb_disease where tc_diag_pinyin is null");
        for(Disease disease : query){
            String pinyin = PinyinUtils.getUpperCase(disease.getTc_diag_name(),false);
            disease.setTc_diag_pinyin(pinyin);
            JdbcTemplateUtils.update("update tb_disease set tc_diag_pinyin = ? where tc_diag_code = ? and tc_diag_type=?",
                    disease.getTc_diag_pinyin(),disease.getTc_diag_code(),disease.getTc_diag_type());
        }
    }

    public String httpPost(String url, List<NameValuePair> nameValuePairs) throws Exception {
        //模拟创建一个浏览器用户
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        if (nameValuePairs != null && nameValuePairs.size() > 0) {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        }
        //使用httpclient进行连接
        CloseableHttpResponse response = client.execute(httppost);
        //查询成功
        String content = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(content);
        } else {
            System.out.println("返回失败: " + response.getStatusLine().getStatusCode());
        }
        //每次请求等待2秒
        Thread.sleep(1000);
        return content;
    }

}
