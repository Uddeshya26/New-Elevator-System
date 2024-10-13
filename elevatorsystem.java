import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Elevator{
    enum Direction {
        UP, DOWN
    }

    private Direction direction;
    private ArrayList<Integer> requests = new ArrayList<>();
    private int minFloor;
    private int maxFloor;
    private int currentFloor = 0;
    private int currentCapacity = 0
    private int maxCapacity;

    public Elevator(int minFloor, int maxFloor, int maxCapacity){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.maxCapacity = maxCapacity;
    
    }

    public void startElevator() {
        Scanner scanner = new Scanner(System.in);

        system.out.println("The current fllor is " + currentFloor + "and the number of people in the elevator" + currentCapacity);
        setInitialRequest(scanner);

        Collections.sort(requests);

        while(!requests.isEmpty()){
            if (direction == Direction.UP) {
                setCurrentFloor(requests.get(0)):
            }else if (direction == Direction.DOWN) {
                setCurrentFloor(requests.get(requests.size() - 1));
            }

            currentCapacity = getCurrentCapacity();
            
            while (requests.contains(currentFloor)) {
                requests.remove(Integer.valueOf(currentFloor));
                currentCapacity--;
            }

            setCurrentCapacity(currentCapacity);

            String dir = (diretion == Direction.UP) ? "UP" : "DOWN";

            System.out.println("\n===========================");
            System.out.println("The current floor is " + currentFloor + "and number of people are" + currentCapacity);
            System.out.println("Direction of elevator is " + dir + " and Total capacity of the elevator is " + getMaxCapacity());
            System.out.println("Minimum floor number is " + getMinFloor() + "and Maximum floor number is " + getMaxFloor());
            System.out.println("=============================");

            if (currentFloor == maxFloor) {
                direction = Direction.DOWN;
            } else if (currentFloor == minFloor) {
                direction = Direction.UP;
            }

            if (currentCapacity == 0) {
                setInitialRequest(scanner);
            } else {
                setRequest(scanner);
            }

            Collections.sort(requests);
        }

        scanner.close();
    }

    private void setInitialRequest(Scanner scanner) {
        System.out.println("\nEnter number pf requests: ")
        int numOfRequests = scanner.nextInt();

        System.out.println("Enter destination floor number:");
        int destFloor = scanner.nextInt();
        requests.add(destFloor);
        setCurrentCapacity(currentCapacity + 1);
        setDirection();

        for(int i = 1; i < numOfRequests; i++) {
            destFloor = scanner.nextInt();
            if (isValidRequest(destFloor)) {
                requests.add(destFloor);
                setCurrentCapacity(currentCapacity + 1);
            }
            
            if (currentCapacity == maxCapacity) {
                System.out.println("No more entry. Elevator is full");
                break;
            }
        }
    }
    private void setRequest(Scanner scanner) {
        System.out.println("\nEnter number of requests: ");
        int numOfRequests = scanner.nextInt();

        System.out.println("Enter destination floor number:");
        for (int i = 0; i < numOfRequests; i++) {
            int destFloor = scanner.nextInt();
            if (isValidRequest(destFloor)) {
                requests.add(destFloor);
                setCurrentCapacity(currentCapacity + 1);
            }

            if (currentCapacity == maxCapacity) {
                System.out.println("No more entry. Elevator is full!!");
                break;
            }
        }
    }

    private boolean isValidRequest(int floor) {
        if (currentCapacity >= maxCapacity) {
            System.out.println("Elevator is Full!!");
            return false;
        } else if (direction == Direction.UP && floor < currentFloor) {
            System.out.println("Elevator is going UP.");
            return false;
        } else if (direction == Direction.DOWN && floor > currentFloor) {
            System.out.println("Elevator is going DOWN.");
            return false;
        } else if (floor > maxFloor || floor < minFloor) {
            System.out.println("This floor does not exist.");
            return false;
        } else {
            return true;
        }
    }

    private void setDirection() {
        if (requests.get(0) > currentFloor) {
            direction = Direction.UP;
        } else if (requests.get(0) < currentFloor) {
            direction = Direction.DOWN;
        }
    }
    
    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int cap) {
        this.currentCapacity = cap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter minimum floor number, maximum floor number in the building:");
        int minFloor = scanner.nextInt();
        int maxFloor = scanner.nextInt();

        System.out.println("Enter maximum capacity for the elevator:");
        int maxCapacity = scanner.nextInt();

        Elevator elevator = new Elevator(minFloor, maxFloor, maxCapacity);
        elevator.startElevator();

        scanner.close();
    }
}

