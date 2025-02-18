import java.util.List;
import java.util.Scanner;

public class ElevatorService {

    private final Scanner scanner = new Scanner(System.in);

    private boolean getValidNumber(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("Du måste ange ett heltal: \n");
            return false;
        }
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Talet är inte giltigt. Försök igen: \n");
            return false;
        }
    }

    public int getUserInputInt() {
        while (true) {
            String userInput = scanner.nextLine();
            if (getValidNumber(userInput)) {
                return Integer.parseInt(userInput);
            }
        }
    }

    public void where(Elevator elevator) {
        System.out.println("Hiss " + elevator.getElevatorIndex() + " är på våning: " + elevator.getLevel() + "\n");
    }

    public void goTo(Elevator elevator) {
        while (true) {
            int whatLevel = getUserInputInt();

            if (whatLevel >= elevator.getMinLevel() && whatLevel <= elevator.getMaxLevel()) {
                if (whatLevel == elevator.getLevel()) {
                    System.out.println("Hiss " + elevator.getElevatorIndex() + " är redan på den våningen \n");
                    break;
                } else if (whatLevel < elevator.getLevel()) {
                    System.out.println("Hiss " + elevator.getElevatorIndex() + " åker ner till våning: " + whatLevel + "\n");
                    elevator.setLevel(whatLevel);
                    break;
                } else {
                    System.out.println("Hiss " + elevator.getElevatorIndex() + " åker upp till våning: " + whatLevel + "\n");
                    elevator.setLevel(whatLevel);
                    break;
                }
            } else {
                System.out.println("Du måste ange en våning mellan: " + elevator.getMinLevel() + " och " + elevator.getMaxLevel() + "\n");
            }
        }
    }

    public Elevator changeElevator(List<Elevator> elevatorList) {

        System.out.println("Välj hiss (1-" + elevatorList.size() + "): \n");

        while (true) {
            int whatElevator = getUserInputInt();

            if (whatElevator >= 1 && whatElevator <= elevatorList.size()) {
                System.out.println("Du har bytt till hiss " + whatElevator + "\n");
                elevatorList.get(whatElevator - 1).setElevatorIndex(whatElevator);
                return elevatorList.get(whatElevator - 1);
            } else {
                System.out.println("Ogiltigt val. Välj mellan hiss (1-" + elevatorList.size() + "): \n");
            }
        }
    }

    public int totalPassengerWeight(Elevator elevator) {
        int totalWeight = 0;

        List<Passenger> passengerList = elevator.getPassengerList();

        if (passengerList == null || passengerList.isEmpty()) {
            return totalWeight;
        }

        for (Passenger passenger : passengerList) {
            totalWeight += passenger.getPassengerWeight();
        }
        return totalWeight;
    }

    public void returnTotalPassengerWeight(Elevator elevator) {
        if (totalPassengerWeight(elevator) == 0) {
            System.out.println("Det är inga passagerare på hissen \n");
        } else {
            System.out.println("Passagerarna väger totalt: " + totalPassengerWeight(elevator) + " kg \n");
        }
    }

    public void totalAmountOfPassengers(Elevator elevator) {
        System.out.println("Det är " + elevator.getPassengerList().size() + " passagerare på hissen \n");
    }

    public void addPassenger(Elevator elevator) {
        int whatElevatorIndex = elevator.getElevatorIndex();

        int totalWeight = totalPassengerWeight(elevator);
        int minWeight = 30;
        int maxWeight = 130;

        Passenger passenger = new Passenger(minWeight, maxWeight);

        if (elevator.getPassengerList().size() < elevator.getMaxPassengers()) {
            if (totalWeight + passenger.getPassengerWeight() <= elevator.getMaxWeight()) {
                System.out.println("Du har lagt till en ny passagerare som väger " + passenger.getPassengerWeight() + " kg \n");
                elevator.addPassenger(passenger);
            } else {
                System.out.println("Hiss " + whatElevatorIndex + " får max väga: " + elevator.getMaxWeight() + " kg. Just nu väger hissen " + totalPassengerWeight(elevator) + " kg \n");
            }
        } else {
            System.out.println("Du får inte ha fler än " + elevator.getMaxPassengers() + " passagerare på hiss " + whatElevatorIndex + "\n");
        }
    }

    public void removePassenger(Elevator elevator) {
        if (elevator.getPassengerList().isEmpty()) {
            System.out.println("Det är inga passagerare på hissen \n");
            return;
        }
        System.out.println("Du har tagit bort en passagerare \n");
        elevator.getPassengerList().remove(elevator.getPassengerList().size() - 1);
    }
}
