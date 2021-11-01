package com.atguigu.springcloud.utils;

import java.io.IOException;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:35
 * @description demo1
 */
public class demo1 {
    public static void main(String [] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String param = "{\n" +
                "    \"projectCode\":\"HU\",\n" +
                "    \"bWNewRetail\":\"false\",\n" +
                "    \"information\": [\n" +
                "       {\n" +
                "           \"money\": 132.00, \n" +
                "           \"prePayTime\": \"12314123\"\n" +
                "       }\n" +
                "     ],\n" +
                "    \"snapshoots\": [\n" +
                "       {\n" +
                "           \"billId\": 132231, \n" +
                "           \"nodeName\": \"xxxxas\"\n" +
                "       },\n" +
                "       {\n" +
                "           \"billId\": 1322222222, \n" +
                "           \"nodeName\": \"xxxxasaaaaaaaa\",\n" +
                "           \"applyDetails\": [\n" +
                "                {\n" +
                "                    \"suppliesId\": \"123123\", \n" +
                "                    \"suppliesName\": \"zzq\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"suppliesId\": \"123123222\", \n" +
                "                    \"suppliesName\": \"zzq222\",\n" +
                "                    \"suppliers\": [\n" +
                "                        {\n" +
                "                            \"supplierNo\": \"zzq123123\", \n" +
                "                            \"supplierName\": \"zzq3333\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"supplierId\":1111,\n" +
                "                            \"supplierNo\": \"123123222222\", \n" +
                "                            \"suppliesName\": \"zzq22444442\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "       }\n" +
                "    ]\n" +
                "}";
        ContractDetailVO vo = JSONUtils.resolverObjectIncludeArrayByJSON(param, ContractDetailVO.class);
        System.out.println(vo);
    }
}
