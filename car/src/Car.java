import java.util.Scanner;
public class Car {
    private int id;
    private String brand;
    private double speed;
    private int milage;
    private String owner;
    private int value;

    public Car(int id, String brand, String owner, int value) {
        this.id = id;
        this.brand = brand;
        this.owner = owner;
        this.value = value;
    }

    public void speedUp(double increase) {
        speed = Math.min(speed + increase, 220.0);
    }

    public void slowDown(double decrease) {
        speed = Math.max(speed - decrease, 0.0);
    }

    public void stop() {
        speed = 0.0;
    }

    public int getID() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMilage() {
        return milage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner != null && !owner.isEmpty()) {
            this.owner = owner;
        }
    }

    public int getValue() {
        return value;
    }
    public void driveForTime(int timeInHours) {
        double distance = speed * timeInHours;
        milage += (int) distance;

        updateValue();
    }
    private void updateValue() {
        if (brand.equalsIgnoreCase("Toyota")) {
            value = 15000 + milage / 10;
        } else if (brand.equalsIgnoreCase("BMW")) {
            value = 25000 + milage / 8;
        } else {
            value = 10000 + milage / 12;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi, give information regarding your car.");
        System.out.println("Car id: ");
        int id = scan.nextInt();
        System.out.println("Car brand: ");
        String brand = scan.next();
        System.out.println("Car owner: ");
        String owner = scan.next();
        System.out.println("Car value: ");
        int value = scan.nextInt();
        Car myCar = new Car(id, brand, owner, value);
        String engine = "on";
        while (engine.equalsIgnoreCase("on")){
            System.out.println("What now?");
            System.out.println("1. Drive\n2. Speed up\n3. Slow down\n4. Stop\n5. Basic car information\n6. Change owner\n7. Car milage\n8. Turn off engine");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    myCar.driveForTime(2);
                    System.out.println("Current milage: "+myCar.getMilage());
                    break;
                case 2:
                    myCar.speedUp(50.0);
                    myCar.driveForTime(2);
                    System.out.println("Current speed: " + myCar.getSpeed());
                    break;
                case 3:
                    myCar.slowDown(20.0);
                    myCar.driveForTime(2);
                    System.out.println("Current speed: " + myCar.getSpeed());
                    break;
                case 4:
                    myCar.stop();
                    myCar.driveForTime(2);
                    System.out.println("Current speed: " + myCar.getSpeed());
                    break;
                case 5:
                    System.out.println("Car id: "+myCar.getID());
                    System.out.println("Car brand: "+ myCar.getBrand());
                    System.out.println("Car owner: "+ myCar.getOwner());
                    System.out.println("Car value: " + myCar.getValue());
                    break;
                case 6:
                    System.out.println("New owner: ");
                    String newOwner = scan.next();
                    myCar.setOwner(newOwner);
                    break;
                case 7:
                    System.out.println("Current milage: " + myCar.getMilage());
                    break;
                case 8:
                    engine.equalsIgnoreCase("off");
            }
        }

    }
}