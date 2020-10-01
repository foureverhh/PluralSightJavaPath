package com.foureverhh.pojo;

import java.util.List;

public class PageInfo {
    private int pageSize;
    private int pageNumber;
    private List currentInfo;
    private long total;
    private String sName;
    private String tName;
    private int pageStart;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List getCurrentInfo() {
        return currentInfo;
    }

    public void setCurrentInfo(List currentInfo) {
        this.currentInfo = currentInfo;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", currentInfo=" + currentInfo +
                ", total=" + total +
                ", sName='" + sName + '\'' +
                ", tName='" + tName + '\'' +
                ", pageStart=" + pageStart +
                '}';
    }
}
