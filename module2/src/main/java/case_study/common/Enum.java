package case_study.common;

import case_study.model.Customer;
import case_study.model.Service;

public class Enum {
    public static Service.TypeRent getTypeRent(String st) {
        switch (st) {
            case "month":
                return Service.TypeRent.MONTH;
            case "year":
                return Service.TypeRent.YEAR;
            default:
                return Service.TypeRent.DAY;
        }
    }

    public static Customer.TypeCustomer getTypeCustomer(String st) {
        switch (st) {
            case "silver":
                return Customer.TypeCustomer.SILVER;
            case "gold":
                return Customer.TypeCustomer.GOLD;
            case "diamond":
                return Customer.TypeCustomer.DIAMOND;
            default:
                return Customer.TypeCustomer.NORMAL;
        }
    }
}
