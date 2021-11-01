package com.atguigu.springcloud.utils;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:32
 * @description ExcelImportModel
 */
public class ExcelImportModel {
    private int excelIndex;
    private String key;
    private boolean result = true;
    private String msg;

    public ExcelImportModel() {
    }

    public ExcelImportModel(int index, String key, boolean result, String msg) {
        this.excelIndex = index;
        this.key = key;
        this.result = result;
        this.msg = msg;
    }

    public int getExcelIndex() {
        return excelIndex;
    }

    public void setExcelIndex(int excelIndex) {
        this.excelIndex = excelIndex;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

