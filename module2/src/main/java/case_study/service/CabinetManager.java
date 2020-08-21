package case_study.service;

import case_study.model.Customer;

import java.util.List;
import java.util.Stack;

public class CabinetManager {
    private static Stack<String> customersName;
    static {
        customersName = new Stack<>();
        ServiceManager<Customer> sr = new ServiceManager<>(new CustomerManager());
        List<String[]> customers = null;
        try {
            customers = sr.Read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < customers.size(); i++)
            if (i != 0)
                customersName.add(customers.get(i)[1]);
    }

    public static boolean findCustomer(String name) {
         if( customersName.search(name)>0)
             return true;
         return false;
    }
}
