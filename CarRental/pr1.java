package Project.CarRental;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class pr1 {
    public static void main(String[] args) {
        CarRentalSystem rs=new CarRentalSystem();
        Car car1=new Car("0001","SUV","Toyota",100.00);
        Car car2=new Car("0002","Accord","Honda",60.00);
        Car car3=new Car("0003","Mustang","Ford",1108.00);
    
        rs.addcar(car1);
        rs.addcar(car2);
        rs.addcar(car3);
        rs.addcar(new Car("0004","G Wagon","Mercedez",360.00));

        rs.menu();


    }

}

class CarRentalSystem {
    
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals= new ArrayList<>();
    }

    public void addcar(Car car){
        cars.add(car);
    }

    public void addcustomer(Customer cust){
        customers.add(cust);
    }

    public void rentCar(Car car, Customer cust,int days){
        if(car.isAvailabel()){
            car.rent();
            rentals.add(new Rental(car,cust,days));
        }
        else System.out.println("Car is not available for Rent!!");
    }

    public void returnCar(Car car){
        boolean bool=false;
        for(Rental rent:rentals){
            if(rent.getCar()==car){
                bool=true;
                rentals.remove(rent);
                car.returnCar();
                System.out.println("Car returned successfully");
                break;
            }
        }
        if(!bool)System.out.println("Error!!");
    }

    public void menu(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\nWelcome, How can I help you.. \n1.Rent car \n2.Return car \n3.Exit");
            System.out.println("\nEnter your choice: ");

            int num=sc.nextInt();
            sc.nextLine();

            if(num==1){
                System.out.println("\n== Rent a Car ==\n");
                System.out.println("Enter your name: ");
                String CustName=sc.nextLine();

                System.out.println("\nAvailable Cars:");
                for(Car car:cars){
                    if(car.isAvailabel())
                    System.out.println(car.getCarId()+" "+car.getModel()+" "+car.getBrand());
                }
                System.out.println("\n== Choose the car ==\n");
                System.out.println("Enter carId of car you want: ");
                String s=sc.nextLine();

                System.out.println("Enter the number of days for rental: ");
                int day=sc.nextInt();

                System.out.println("Enter your Aadhar Number: ");
                int ad=sc.nextInt();
                sc.nextLine();

                Customer newCust=new Customer(CustName,"CUS"+(customers.size()+1), ad, day);
                addcustomer(newCust);

                Car c=null;
                for(Car car:cars){
                    if(car.getCarId().equals(s) && car.isAvailabel()){
                        c=car;
                    }
                }
                if(c!=null){
                    System.out.println("\n== Car Rental Details ==\n");
                    System.out.println("Customer ID: "+newCust.getid());
                    System.out.println("Customer Name: "+newCust.getName());
                    System.out.println("CAR: "+c.getBrand()+" "+c.getModel());
                    System.out.println("Rental days: "+ day);
                    System.out.println("Total Price: $"+ c.CalculatePrice(day));

                    System.out.println("Confirm RENTAL(YES/NO): ");
                    String ans=sc.nextLine();

                    if(ans.equalsIgnoreCase("yes")){
                        rentCar(c, newCust, day);
                        System.out.println("\nCar Rented successfully.!!");
                        break;
                    }
                    else System.out.println("\nRental Canceled");
                }
                else System.out.println("Entered ID is wrong OR car is not available");
            }

            else if(num==2){

            }

            else if(num==3){
                System.out.println("\nThank you");
                break;
            }
            else System.out.println("\nInvalid Response \nTry again");
        }
    }
}

class Car{
    private String carId;
    private String Model;
    private String Brand;
    private double price_pr_day;
    private boolean isAvailabel;

    public Car(String carid, String model, String brand, double price){
        this.carId=carid;
        this.Model=model;
        this.Brand=brand;
        this.price_pr_day=price;
        this.isAvailabel=true;

    }

    public String getCarId(){
        return carId;
    }

    public String getModel(){
        return Model;
    }

    public String getBrand(){
        return Brand;
    }

    public double CalculatePrice(int day){
        return price_pr_day*day;
    }

    public boolean isAvailabel(){
        return isAvailabel;
    }

    public void rent(){
        isAvailabel=false;
    }

    public void returnCar(){
        isAvailabel=true;
    }

}

class Customer{
    private String name;
    private String Id;
    private int Aadhar;
    private int phone;

    public Customer(String name,String id,int adhar,int phone){
        this.name=name;
        this.Id=id;
        this.Aadhar=adhar;
        this.phone=phone;
    }

    public String getName(){
        return name;
    }

    public String getid(){
        return Id;
    }

}

class Rental{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car,Customer cust, int days){
        this.car=car;
        this.customer=cust;
        this.days=days;
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getdays(){
        return days;
    }
}