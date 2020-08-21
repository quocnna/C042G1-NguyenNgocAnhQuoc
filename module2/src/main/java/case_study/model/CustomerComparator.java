package case_study.model;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int diff = o1.getFullName().compareTo(o2.getFullName());
        if(diff == 0 ) {
            String[] o1Date = o1.getBirthday().split("/");
            String[] o2Date = o2.getBirthday().split("/");
            return Integer.parseInt(o1Date[2]) - Integer.parseInt(o2Date[2]);
        }
        return diff;
    }
}
