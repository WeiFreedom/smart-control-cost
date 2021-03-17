package com.wei.code.domain;

import java.util.regex.Pattern;

public class RegexObj {


    public RegexObj(String regexPattern, String description){
        this.regexPattern = Pattern.compile(regexPattern);
        this.description = description;
    }

    /**
     * 正则表达式
     */
    private Pattern regexPattern;
    /**
     * 描述
     */
    private String description;

    public Pattern getRegexPattern() {
        return regexPattern;
    }

    public void setRegexPattern(Pattern regexPattern) {
        this.regexPattern = regexPattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RegexObj{" +
                "regexPattern=" + regexPattern +
                ", description='" + description + '\'' +
                '}';
    }
}
