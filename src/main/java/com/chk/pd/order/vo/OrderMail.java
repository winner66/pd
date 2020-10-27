package com.chk.pd.order.vo;

import org.apache.commons.lang3.StringUtils;

public class OrderMail {
    public static String content = "<html>" +
            "<head>" +
            "    <title></title>" +
            "    <style type=\"text/css\">" +
            "        table" +
            "        {" +
            "            border-collapse: collapse;" +
            "            margin: 0 auto;" +
            "            text-align: left;" +
            "        }" +
            "        table td, table th" +
            "        {" +
            "            border: 1px solid #cad9ea;" +
            "            color: #666;" +
            "            height: 30px;" +
            "        }" +
            "        table thead th" +
            "        {" +
            "            background-color: #CCE8EB;" +
            "            width: 100px;" +
            "        }" +
            "        table tr:nth-child(odd)" +
            "        {" +
            "            background: #fff;" +
            "        }" +
            "        table tr:nth-child(even)" +
            "        {" +
            "            background: #F5FAFA;" +
            "        }" +
            "    </style>" +
            "</head>" +
            "<body>" +
            "<table width=\"90%\" class=\"table\">" +
            "        <caption>" +
            "            <h2>{{清单}}</h2>" +
            "        </caption>" +
            "    <tr>" +
            "            <td width=\"20%\" style=\"text-align: center;\">" +
            "                联系人" +
            "            </td>" +
            "            <td width=\"80%\">" +
            "                {{联系人}}" +
            "            </td>            " +
            "        </tr>" +
            "        <tr>" +
            "            <td width=\"20%\" style=\"text-align: center;\">" +
            "                联系方式" +
            "            </td>" +
            "            <td>" +
            "                {{联系方式}}" +
            "            </td>            " +
            "        </tr>" +
            "<tr>" +
            "            <td width=\"20%\" style=\"text-align: center;\">" +
            "                公司" +
            "            </td>" +
            "            <td>" +
            "                {{公司}}" +
            "            </td>            " +
            "        </tr>" +
            "<tr>" +
            "            <td width=\"20%\" style=\"text-align: center;\">" +
            "                备注" +
            "            </td>" +
            "            <td>" +
            "                {{备注}}" +
            "            </td>            " +
            "        </tr>" +
            "<tr>" +
            "            <td width=\"20%\" style=\"text-align: center;\">" +
            "                日期" +
            "            </td>" +
            "            <td>" +
            "                {{日期}}" +
            "            </td>            " +
            "        </tr>" +
            "    </table>" +
            "" +
            "    <table width=\"90%\" class=\"table\">" +
            "        <caption>" +
            "            <h3>明细</h3>" +
            "        </caption>" +
            "        <thead>" +
            "            <tr>" +
            "                <th style=\"text-align: center;\">" +
            "                    序号" +
            "                </th>" +
            "                <th style=\"text-align: center;\">" +
            "                    订货标识" +
            "                </th>" +
            "                <th style=\"text-align: center;\">" +
            "                    数量" +
            "                </th>" +
            "                <th style=\"text-align: center;\">" +
            "                    备注" +
            "                </th>" +
            "            </tr>" +
            "        </thead>" +
            "{{清单明细}}" +
            "    </table>" +
            "</body>" +
            "</html>";

    public static void main(String[] args) {
        System.out.println(content);
    }
}
