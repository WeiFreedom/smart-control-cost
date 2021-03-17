package com.wei.code;

import com.wei.code.jdbc.JdbcTemplateUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;

public class JavaTextOper {

    /**
     * 读取排除表
     */
    @Test
    public void readExclusionTable() throws Exception {
        String basePath = "C:\\Users\\32927\\Desktop\\drugs";
        // String basePath = "C:\\Users\\32927\\Desktop";
        String tableStartName = "表 7";
        String tablePrefixName = "tb7_";
        String skipString = "主要诊断";

        List<Map<String, String>> result = new ArrayList<>();

        File directory = new File(basePath);
        if (directory.isDirectory()) {//如果是一个文件夹
            // 获取文件夹下面所有的文件
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.exists() && file.getName().startsWith(tableStartName)) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String tempStr;
                    String restDiagName = "";
                    Map<String, String> map = new HashMap<>();
                    Map<String, String> old = new HashMap<>();
                    while ((tempStr = reader.readLine()) != null) {
                        if (tempStr.startsWith(tableStartName)) {//如果以 表 7开始 那么跳过
                            continue;
                        }
                        if ("".equals(tempStr.trim())) {//主要过滤第一行 和最后一行
                            continue;
                        }
                        String[] strs = tempStr.trim().split(" ");
                        old = new HashMap<>();
                        if (map.size() > 0) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                old.put(entry.getKey(), entry.getValue());
                            }
                        }
                        if (strs.length == 1) {//如果不能被空格分隔 那么可能是页码 也可能是诊断完整名称
                            if (isNumber(strs[0])) {//如果是数字
                                continue;
                            } else if (strs[0].contains(skipString)) {
                                continue;
                            } else {
                                restDiagName = strs[0];
                                old.put("tc_diag_name", old.get("tc_diag_name") + restDiagName);
                                result.add(old);
                                map.clear();
                            }
                        } else if (strs.length > 1) {
                            map = new HashMap<>();
                            map.put("tc_mc_exc_code", tablePrefixName + file.getName().substring(0, file.getName().lastIndexOf(".")).substring(4));
                            map.put("tc_diag_code", strs[0]);
                            if (strs.length > 2) {
                                map.put("tc_diag_name", strs[1] + " " + strs[2]);
                            } else {
                                map.put("tc_diag_name", strs[1]);
                            }

                            if (old.size() > 0) {
                                result.add(old);
                            }
                        }
                    }
                    if (map.size() > 0) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            result.add(map);
                        }
                    }
                    reader.close();
                }
            }
            JavaExcelOper.savaMcExc(result);
        }
    }

    /**
     * 读取并发症 合并症
     *
     * @throws Exception
     */
    @Test
    public void readMc() throws Exception {
        String fileName1 = "C:\\Users\\32927\\Desktop\\drugs\\并发症或合并症（CC）.txt";
        String fileName2 = "C:\\Users\\32927\\Desktop\\drugs\\严重并发症或合并症（MCC）.txt";
        String tableStartName = "表 7";
        String tablePrefixName = "tb7_";
        char[] chars = new char[]{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A',
                'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                '*', 'x', '+', '.', '-', '/'};

        List<String> contents = new LinkedList<>();

        File file1 = new File(fileName1);
        if (file1.isFile() && file1.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                if ("".equals(tempStr)) {
                    continue;
                }
                if (isNumber(tempStr)) {
                    continue;
                }
                contents.add(tempStr);
            }
        }

        File file2 = new File(fileName2);
        if (file2.isFile() && file2.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file2));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                if ("".equals(tempStr)) {
                    continue;
                }
                if (isNumber(tempStr)) {
                    continue;
                }
                contents.add(tempStr);
            }
        }

        List<Map<String, String>> result = new LinkedList<>();

        for (int index = 0; index < contents.size(); index++) {
            String source = contents.get(index);
            if (source.contains(tableStartName)) {
                int start = source.indexOf(' ');
                int end = source.lastIndexOf(tableStartName);
                String tc_mc_exc_code = tablePrefixName + source.substring(end + tableStartName.length() + 1);
                String tc_diag_code = source.substring(0, start + 1);
                String tc_diag_name = source.substring(start + 1, end).trim();

                Map<String, String> map = new HashMap<>();
                map.put("tc_mc_exc_code", tc_mc_exc_code);
                map.put("tc_diag_code", tc_diag_code);
                map.put("tc_diag_name", tc_diag_name);
                result.add(map);
            } else if (isExitsChars(chars, source.charAt(0))) {
                String next = contents.get(index + 1);
                next = source + next;
                contents.set(index + 1, next);
            }
        }
        JavaExcelOper.savaMcExc(result);
        //result.stream().forEach(System.out::println);

    }

    /**
     * 读取adrg诊断 及主要操作
     *
     * @throws Exception
     */
    @Test
    public void readAdrg() throws Exception {
        String fileName = "C:\\Users\\32927\\Desktop\\drugs\\MDCZ.txt";
        String keyNote1 = "同时包含";
        String keyNote2 = "包含以下";
        String keyNote4 = "和";
        String keyNote5 = "手术";
        String keyNote6 = "操作";
        String keyNote7 = "诊断";
        char[] chars = new char[]{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A',
                'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                '*', 'x', '+', '.', '-', '/'};

        File file = new File(fileName);
        List<String> contents = new LinkedList<>();
        String name = file.getName().substring(0, file.getName().lastIndexOf("."));
        List<String> mdcas = JdbcTemplateUtils.getAdrgCodeList(name);

        // 最终结果
        Map<String, List<Map<String, String>>> analysis = new LinkedHashMap<>();
        for (String mdca : mdcas) {
            analysis.put(mdca, new LinkedList<>());
        }
        analysis.put(name, new LinkedList<>());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            if ("".equals(tempStr)) {//如果是空 跳过
                continue;
            }
            if (isNumber(tempStr)) {//如果是数字 跳过
                continue;
            }
            contents.add(tempStr);
        }

        List<Map<String, String>> selectList = new LinkedList<>();
        int flag = 0;
        String key = "";
        String type = "";
        List<Map<String, String>> allConditions = new ArrayList<>();
        for (int index = 0; index < contents.size(); index++) {
            String content = contents.get(index);
            int next = index + 1;
            if (next < contents.size()) {
                String nextContent = contents.get(next);
                //判断这个字符是上一行没结束的
                if (!keyNote4.equals(nextContent.trim())
                        && !nextContent.trim().startsWith(name)
                        && !nextContent.trim().startsWith(keyNote2)
                        && !nextContent.trim().startsWith(keyNote1)
                        && !nextContent.trim().contains(" ")
                        && mdcas.stream().noneMatch(m -> nextContent.trim().startsWith(m))) {
                    content = content + nextContent;
                    index++;
                }
            }
            final String tempContent = content;

            if (content.trim().startsWith(name)) {
                key = name;
                selectList = analysis.get(name);
                flag = 0;
            }
            if (mdcas.stream().anyMatch(m -> tempContent.trim().startsWith(m))) {
                key = tempContent.substring(0, tempContent.indexOf(" "));
                selectList = analysis.get(key);
                flag = 0;
            }

            if (content.trim().startsWith(keyNote1) || content.trim().startsWith(keyNote2)) {
                if (content.trim().contains(keyNote5) || content.trim().contains(keyNote6)) {
                    type = "03";
                }
                if (content.trim().contains(keyNote7)) {
                    type = "01";
                }
            }
            if (content.trim().startsWith(keyNote1) || content.trim().startsWith(keyNote2)
                    || keyNote4.equals(content.trim())) {
                if (keyNote4.equals(content.trim())) {//和
                    Map<String, String> conditionMap = new LinkedHashMap<>();
                    conditionMap.put(key, flag + "-" + (flag + 1));
                    allConditions.add(conditionMap);
                }
                flag++;
            }

            if (!content.trim().startsWith(name) &&
                    mdcas.stream().noneMatch(m -> tempContent.trim().startsWith(m)) &&
                    isExitsChars(chars, content.trim().charAt(0))) {//如果是诊断开始的
                int startIndex = content.indexOf(" ");
                String tc_diag_code = content.substring(0, startIndex);
                String tc_diag_name = content.substring(startIndex + 1);

                Map<String, String> map = new LinkedHashMap<>();
                map.put("tc_adrg_code", key);
                map.put("tc_diag_type", type);
                map.put("tc_diag_code", tc_diag_code);
                map.put("tc_diag_name", tc_diag_name);
                map.put("tc_adrg_condition", flag + "");

                selectList.add(map);
            }

        }
        //contents.stream().forEach(System.out::println);
        allConditions.stream().forEach(System.out::println);
        JavaExcelOper.savaAdrg(analysis,allConditions,name);
    }

    private boolean isExitsChars(char[] chars, char ch) {
        for (char c : chars) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
