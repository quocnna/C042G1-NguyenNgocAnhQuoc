package case_study.controller;

import case_study.common.Enum;
import case_study.common.Validation;
import case_study.exception.BirthdayException;
import case_study.exception.EmailException;
import case_study.exception.NameException;
import case_study.model.*;
import case_study.service.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void DisplayMainMenu() throws Exception {
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show information of Customers");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show information Bookings");
        System.out.println("7. Add New Employee");
        System.out.println("8. Show information of Employees");
        System.out.println("9. Find a Customer On Cabinet");
        int numberChoice = getNumberChoice();
        do {
            switch (numberChoice) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showCustomers();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showBookings();
                    break;
                case 7:
                    //addNewEmployee();
                    break;
                case 8:
                    //showEmployees();
                    break;
                case 9:
                    findCustomerOnCabinet();
                    break;
                case 10:
                    System.exit(0);
            }
        }
        while (numberChoice < 1 || numberChoice > 9);
    }

    private static void findCustomerOnCabinet() throws Exception {
        scanner.nextLine();
        System.out.print("Choice one Customer Name for search: ");
        String idCustomer = scanner.nextLine();
        System.out.println(CabinetManager.findCustomer(idCustomer));
    }

    private static void addNewBooking() throws Exception {
        showCustomers();
        scanner.nextLine();
        System.out.print("Choice one ID Customer for booking: ");
        String idCustomer = scanner.nextLine();
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        int numberChoice = getNumberChoice();
        do {
            switch (numberChoice) {
                case 1:
                    showVillas();
                    scanner.nextLine();
                    System.out.print("Choice one ID Villa for booking: ");
                    String idVilla = scanner.nextLine();
                    booking(idCustomer, idVilla);
                    break;
                case 2:
                    showHouses();
                    scanner.nextLine();
                    System.out.print("Choice one ID House for booking: ");
                    String idHouse = scanner.nextLine();
                    booking(idCustomer, idHouse);
                    break;
                case 3:
                    showRooms();
                    scanner.nextLine();
                    System.out.print("Choice one ID Room for booking: ");
                    String idRoom = scanner.nextLine();
                    booking(idCustomer, idRoom);
                    break;
                case 4:
                    DisplayMainMenu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (numberChoice < 1 && numberChoice > 5);
    }

    private static Customer addNewCustomer() throws Exception {
        HashMap<String, String> hashMap = inputFields(Customer.class);
        Customer customer = new Customer(Integer.parseInt(hashMap.get("Id")), hashMap.get("Full Name"), hashMap.get("Birthday"), hashMap.get("Gender"),
                hashMap.get("Phone"), hashMap.get("Email"), Enum.getTypeCustomer(hashMap.get("Type Customer")), hashMap.get("Address"), null);

        ServiceManager ser = new ServiceManager(new CustomerManager());
        ser.Write(customer);
        return customer;
    }

    private static void addNewService() throws Exception {
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");
        int numberChoice = getNumberChoice();
        do {
            switch (numberChoice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    DisplayMainMenu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (numberChoice < 1 && numberChoice > 5);
    }

    private static Room addNewRoom() throws Exception {
        HashMap<String, String> hashMap = inputFields(Room.class);
        Room room = new Room(hashMap.get("Id"), hashMap.get("Name"), Double.parseDouble(hashMap.get("Area Used")), Double.parseDouble(hashMap.get("Price")),
                Integer.parseInt(hashMap.get("Max People")), Enum.getTypeRent(hashMap.get("Type Rent")), Service.TypeBed.EXTRA_BED, getServiceFree());

        ServiceManager ser = new ServiceManager(new RoomManager());
        ser.Write(room);
        return room;
    }

    private static House addNewHouse() throws Exception {
        HashMap<String, String> hashMap = inputFields(House.class);
        House house = new House(hashMap.get("Id"), hashMap.get("Name"), Double.parseDouble(hashMap.get("Area Used")), Double.parseDouble(hashMap.get("Price")),
                Integer.parseInt(hashMap.get("Max People")), Enum.getTypeRent(hashMap.get("Type Rent")), Service.TypeBed.EXTRA_BED, Villa.TypeRoom.DELUXE, hashMap.get("Description"), Integer.parseInt(hashMap.get("Number Of Floor")));

        ServiceManager ser = new ServiceManager(new HouseManager());
        ser.Write(house);
        return house;
    }

    private static Villa addNewVilla() throws Exception {
        HashMap<String, String> hashMap = inputFields(Villa.class);
        Villa villa = new Villa(hashMap.get("Id"), hashMap.get("Name"), Double.parseDouble(hashMap.get("Area Used")), Double.parseDouble(hashMap.get("Price")),
                Integer.parseInt(hashMap.get("Max People")), Enum.getTypeRent(hashMap.get("Type Rent")), Service.TypeBed.EXTRA_BED, Villa.TypeRoom.DELUXE, hashMap.get("Description"), Double.parseDouble(hashMap.get("Area Pool")), Integer.parseInt(hashMap.get("Number Of Floor")));

        ServiceManager ser = new ServiceManager(new VillaManager());
        ser.Write(villa);
        return villa;
    }

    private static void showBookings() throws Exception {
        ServiceManager<Booking> ser = new ServiceManager<>(new BookingManager());
        ser.Read();
    }

    private static void showServices() throws Exception {
        System.out.println("1. Show All Villa");
        System.out.println("2. Show All House");
        System.out.println("3. Show All Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        int numberChoice = getNumberChoice();
        do {
            switch (numberChoice) {
                case 1:
                    showVillas();
                    break;
                case 2:
                    showHouses();
                    break;
                case 3:
                    showRooms();
                    break;
                case 4:
                    showVillasNotDuplicate();
                    break;
                case 5:
                    showHousesNotDuplicate();
                    break;
                case 6:
                    showRoomsNotDuplicate();
                    break;
                case 7:
                    DisplayMainMenu();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (numberChoice < 1 && numberChoice > 5);
    }

    private static void showVillasNotDuplicate() throws Exception {
        ServiceManager<Villa> sr = new ServiceManager<>(new VillaManager());
        List<String[]> villas = sr.Read();
        TreeSet<String> villaName = new TreeSet<>();
        for (int i = 0; i < villas.size(); i++)
            if (i != 0)
                villaName.add(villas.get(i)[1]);

        System.out.println("Name Villa" + "\n");
        villaName.stream().forEach(e -> System.out.println(e + "\n"));
    }

    private static void showHousesNotDuplicate() throws Exception {
        ServiceManager<House> sr = new ServiceManager<>(new HouseManager());
        List<String[]> houses = sr.Read();
        TreeSet<String> houseName = new TreeSet<>();
        for (int i = 0; i < houses.size(); i++)
            if (i != 0)
                houseName.add(houses.get(i)[1]);

        System.out.println("Name House" + "\n");
        houseName.stream().forEach(e -> System.out.println(e + "\n"));
    }

    private static void showRoomsNotDuplicate() {
        System.out.println("show room not duplicate");
    }

    private static void showRooms() throws Exception {
        ServiceManager<Room> ser = new ServiceManager<>(new RoomManager());
        ser.Read();
    }

    private static void showHouses() throws Exception {
        ServiceManager<House> ser = new ServiceManager<>(new HouseManager());
        ser.Read();
    }

    private static void showVillas() throws Exception {
        ServiceManager<Villa> ser = new ServiceManager<>(new VillaManager());
        ser.Read();
    }

    private static List<String[]> showCustomers() throws Exception {
        ServiceManager<Customer> ser = new ServiceManager<>(new CustomerManager());
        return ser.Read();
    }

    private static void booking(String idCustomer, String idService) throws Exception {
        ServiceManager<Booking> ser = new ServiceManager<>(new BookingManager());
        ser.Write(new Booking(idCustomer, idService));
    }

    private static List<ServiceAccompanied> getServiceFree() {
        return null;
    }

    private static HashMap<String, String> inputFields(Class cls) throws BirthdayException, EmailException, NameException {
        HashMap result = new HashMap<String, String>();
        List<Field> fields = getAllFields(cls);
        scanner.nextLine();
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i).getName();
            Pattern pattern = Pattern.compile("(^.)");
            Matcher matcher = pattern.matcher(fieldName);
            if (matcher.find()) {
                String tmp = fieldName.replaceAll("(\\p{javaUpperCase})", " $1");
                String firstChar = matcher.group(1);
                fieldName = tmp.replaceAll("(^.)", firstChar.toUpperCase());
            }
            String value = "";
            if (cls.equals(Villa.class) || cls.equals(House.class) || cls.equals(Room.class)) {
                do {
                    System.out.printf("Input %s: ", fieldName);
                    value = scanner.nextLine();
                } while (!Validation.ValidateService(fieldName, value));
            } else {
                do {
                    System.out.printf("Input %s: ", fieldName);
                    value = scanner.nextLine();
                } while (!Validation.ValidateCustomer(fieldName, value));
            }

            result.put(fieldName, value);
        }
        return result;
    }

    private static List<Field> getAllFields(Class clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }
        List<Field> result = new ArrayList<>(getAllFields(clazz.getSuperclass()));
        List<Field> filteredFields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toList());
        result.addAll(filteredFields);
        return result;
    }

    private static int getNumberChoice() {
        System.out.print("Please input your choice: ");
        return scanner.nextInt();
    }
}
