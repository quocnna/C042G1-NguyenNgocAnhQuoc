package common;

public class Paging {
    private int currentPage;
    private int pageSizeItems=5;
    private int totalPages;
    private int totalItems;
    private int  totalItemsPage;
    private String sortField;
    private String sortDir;
    private String searchBy;
    private String searchVal;

    public Paging(){ }
    public Paging(int currentPage, String sortField, String sortDir){
        this.currentPage = currentPage;
        this.sortField = sortField;
        this.sortDir = sortDir;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSizeItems() {
        return pageSizeItems;
    }

    public void setPageSizeItems(int pageSizeItems) {
        this.pageSizeItems = pageSizeItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public int getTotalItemsPage() {
        return totalItemsPage;
    }

    public void setTotalItemsPage(int totalItemsPage) {
        this.totalItemsPage = totalItemsPage;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getSearchVal() {
        return searchVal;
    }

    public void setSearchVal(String searchVal) {
        this.searchVal = searchVal;
    }

    public void setPaging(int totalItems, int totalItemsPage, String searchBy, String searchVal){
        int totalPages = (int) Math.ceil((double) totalItems / this.pageSizeItems);
        this.totalItems= totalItems;
        this.totalPages= totalPages;
        this.totalItemsPage= totalItemsPage;
        this.searchBy= searchBy;
        this.searchVal= searchVal;
    }
}
