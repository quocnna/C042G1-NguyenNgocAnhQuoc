package model;

public final class Setting {
    private static Setting INSTANCE;
    private String language="Vietnam";
    private int pageSize= 15;
    private boolean isSpamFilter= false;
    private String singature="singature";

    public static Setting getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Setting();
        }

        return INSTANCE;
    }
    private Setting(){}

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return isSpamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        isSpamFilter = spamFilter;
    }

    public String getSingature() {
        return singature;
    }

    public void setSingature(String singature) {
        this.singature = singature;
    }
}
