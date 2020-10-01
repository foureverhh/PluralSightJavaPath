package pojo;

import java.util.List;

public class PageInfo {
    private int pageNumber;
    private int pageSize;
    private long totalPages;
    private List currentPage;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(List currentPage) {
        this.currentPage = currentPage;
    }
}
