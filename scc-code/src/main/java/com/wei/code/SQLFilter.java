package com.wei.code;

import com.wei.code.domain.RegexObj;

import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class SQLFilter {

    /**
     * 检查正则表达式
     */
    // /* and */
    public static final RegexObj REGEX1 = new RegexObj("(/\\*).*(\\*/)", "Found /* and */");
    /**
     * -- at the end
     */

    public static final RegexObj REGEX2 = new RegexObj("(--.*)$", "-- at end of sql");
    /**
     * ; and at least one " or '
     */
    public static final RegexObj REGEX3 = new RegexObj(";+\"+\'", "One or more ; and at least one \" or \'");
    /**
     * two or more "
     */
    public static final RegexObj REGEX4 = new RegexObj("\"{2,}+", "Two or more \"");
    /**
     * two or more '
     */
    public static final RegexObj REGEX5 = new RegexObj("\'{2,}+", "Two or more \'");
    /**
     * anydigit=anydigit
     */
    public static final RegexObj REGEX6 = new RegexObj("\\d=\\d", "anydigit=anydigit");
    /**
     * # at the end
     */
    public static final RegexObj REGEX7 = new RegexObj("(#.*)$", "# at end of sql");
    /**
     * two or more %
     */
    public static final RegexObj REGEX8 = new RegexObj("%{2,}+", "Two or more \\% signs");
    /**
     * admin and one of [; ' " =] before or after admin
     */
    public static final RegexObj REGEX9 = new RegexObj("([;\'\"\\=]+.*(admin.*))|((admin.*).*[;\'\"\\=]+)",
            "admin (and variations like administrator) and one of [; ' \" =] before or after admin");
    /**
     * ASCII in hex
     */
    public static final RegexObj REGEX10 = new RegexObj("%+[0-7]+[0-9|A-F]+", "ASCII Hex");
    /**
     * 检查字符串
     */
    protected static final String[] STRINGS_TO_CHECK = {"drop", "exec", "update", "delete", "insert", "http", "sql", "mysql",
            "information_schema", "sleep", "version", "declare", "signed", "alter", "create", "shutdown", "grant", "privileges"};
    protected static final RegexObj[] REGEXES = {REGEX1, REGEX2, REGEX3, REGEX4, REGEX5, REGEX6, REGEX7, REGEX9, REGEX10};

    private SQLFilter() {}

    public static boolean sqlRegexChecker(String sqlToCheck, RegexObj regex) {
        return sqlRegexChecker(sqlToCheck, new RegexObj[] {regex}, false);
    }

    public static boolean sqlRegexChecker(String sqlToCheck, RegexObj regex, boolean embed) {
        return sqlRegexChecker(sqlToCheck, new RegexObj[] {regex}, embed);
    }

    public static boolean sqlRegexChecker(String sqlToCheck, RegexObj[] regexArr) {
        return sqlRegexChecker(sqlToCheck, regexArr, false);
    }

    public static boolean sqlStringChecker(String sqlToCheck, String strToCheck) {
        return sqlStringChecker(sqlToCheck, new String[] {strToCheck}, false);
    }

    public static boolean sqlStringChecker(String sqlToCheck, String strToCheck, boolean embed) {
        return sqlStringChecker(sqlToCheck, new String[] {strToCheck}, embed);
    }

    public static boolean sqlStringChecker(String sqlToCheck, String[] strArrToCheck) {
        return sqlStringChecker(sqlToCheck, strArrToCheck, false);
    }

    public static boolean sqlHandler(String sqlString, String[] strArrToCheck, RegexObj[] regexArr) {
        return sqlHandler(sqlString, strArrToCheck, regexArr, false);
    }

    public static boolean sqlHandler(String sqlString) {
        return sqlHandler(sqlString, null, null, true);
    }

    /**
     * @param sqlString SQL字符串
     * @param strArrToCheck 检查字符串数组
     * @param regexArr 检查正则表达式数组
     * @param embed 是否使用内置默认规则
     * @return
     */
    public static boolean sqlHandler(String sqlString, String[] strArrToCheck, RegexObj[] regexArr, boolean embed) {

        boolean pass1 = true;
        boolean pass2 = true;

        pass1 = sqlStringChecker(sqlString, strArrToCheck, embed);
        pass2 = sqlRegexChecker(sqlString, regexArr, embed);

        if (!pass1 || !pass2) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * 字符串SQL注入检查
     *
     * @param sqlToCheck SQL
     * @param strArrToCheck 字符串数组
     * @param embed 是否使用默认内置规则
     * @return
     */
    public static boolean sqlStringChecker(String sqlToCheck, String[] strArrToCheck, boolean embed) {

        boolean pass = true;

        sqlToCheck = sqlToCheck.toLowerCase();

        if (strArrToCheck != null && strArrToCheck.length > 0) {
            for (String keyword : strArrToCheck) {
                if (sqlToCheck.contains(keyword)) {
                    pass = false;
                    break;

                }
            }
        }

        if (embed && pass) {
            // 按照 默认的分隔符为空格，制表符(‘\t’)、换行符(‘\n’)、回车符(‘\r’) , ; 分词
            StringTokenizer st = new StringTokenizer(sqlToCheck, " \t\n\r\f,;", false);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                for (String command : STRINGS_TO_CHECK) {
                    if (word.equals(command)) {
                        pass = false;
                        break;
                    }
                }
            }
        }

        return pass;
    }

    /**
     * 正则表达式sql注入检查
     *
     * @param sqlToCheck SQL
     * @param regexArr 正则表达式数组
     * @param embed 是否使用默认内置规则
     * @return
     */
    public static boolean sqlRegexChecker(String sqlToCheck, RegexObj[] regexArr, boolean embed) {
        boolean pass = true;
        Matcher matcher;
        sqlToCheck = sqlToCheck.toLowerCase();

        if (regexArr != null && regexArr.length > 0) {
            for (RegexObj regex : REGEXES) {
                matcher = regex.getRegexPattern().matcher(sqlToCheck);
                if (matcher.find()) {
                    pass = false;
                    break;
                }
            }
        }
        if (embed && pass) {
            for (RegexObj regex : REGEXES) {
                matcher = regex.getRegexPattern().matcher(sqlToCheck);
                if (matcher.find()) {
                    pass = false;
                    break;
                }
            }
        }

        return pass;
    }
}
