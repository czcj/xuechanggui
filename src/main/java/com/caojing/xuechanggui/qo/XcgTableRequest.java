package com.caojing.xuechanggui.qo;

import java.util.List;

public class XcgTableRequest {
    String tableName;
    List<String> names;
    String tableAstart;
    String tableAend;
    String tableBstart;
    String tableBend;

    public String getTableBstart() {
        return tableBstart;
    }

    public void setTableBstart(String tableBstart) {
        this.tableBstart = tableBstart;
    }

    public String getTableBend() {
        return tableBend;
    }

    public void setTableBend(String tableBend) {
        this.tableBend = tableBend;
    }

    public String getTableAstart() {
        return tableAstart;
    }

    public void setTableAstart(String tableAstart) {
        this.tableAstart = tableAstart;
    }

    public String getTableAend() {
        return tableAend;
    }

    public void setTableAend(String tableAend) {
        this.tableAend = tableAend;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
