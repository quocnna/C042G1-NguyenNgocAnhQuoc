package examination.model;

public class ProductImport extends Product {
    private double priceImport;
    private String cityImport;
    private double taxImport;

    public ProductImport(){}
    public ProductImport(int id, String code, String name, double price, int quantity, String brand, double priceImport,
                         String cityImport, double taxImport) {
        super(id, code, name, price, quantity, brand);
        this.priceImport = priceImport;
        this.cityImport = cityImport;
        this.taxImport = taxImport;
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
