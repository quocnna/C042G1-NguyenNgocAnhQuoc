package other.my_exam.model;

public class ProductDTO extends Product {
    private double priceImport;
    private String cityImport;
    private double taxImport;
    private double priceExport;
    private String countryExport;

    public ProductDTO() {
    }

    public ProductDTO(int id, String code, String name, double price, int quantity, String brand, double priceImport, String cityImport, double taxImport, double priceExport, String countryExport) {
        super(id, code, name, price, quantity, brand);
        this.priceImport = priceImport;
        this.cityImport = cityImport;
        this.taxImport = taxImport;
        this.priceExport = priceExport;
        this.countryExport = countryExport;
    }

    public double getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(double priceExport) {
        this.priceExport = priceExport;
    }

    public String getCountryExport() {
        return countryExport;
    }

    public void setCountryExport(String countryExport) {
        this.countryExport = countryExport;
    }

    public double getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(double priceImport) {
        this.priceImport = priceImport;
    }

    public String getCityImport() {
        return cityImport;
    }

    public void setCityImport(String cityImport) {
        this.cityImport = cityImport;
    }

    public double getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(double taxImport) {
        this.taxImport = taxImport;
    }

    @Override
    public void showInfo() {

    }
}
