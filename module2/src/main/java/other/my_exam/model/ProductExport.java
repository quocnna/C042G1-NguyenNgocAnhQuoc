package other.my_exam.model;

public class ProductExport extends Product {
    private double priceExport;
    private String countryExport;


    public ProductExport(double priceExport, String countryExport) {
        this.priceExport = priceExport;
        this.countryExport = countryExport;
    }

    public ProductExport(int id, String code, String name, double price, int quantity, String brand, double priceExport, String countryExport) {
        super(id, code, name, price, quantity, brand);
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

    @Override
    public void showInfo() {

    }
}
