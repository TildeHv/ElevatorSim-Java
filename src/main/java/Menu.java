import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    final ElevatorService elevatorService = new ElevatorService();
    final Scanner scanner = new Scanner(System.in);
    private List<Elevator> elevatorList;
    private Elevator elevator;

    public static void main(final String[] args) {
        Menu menu = new Menu();
        menu.elevatorArray();

        menu.elevator = menu.elevatorList.get(0);

        menu.userMenu();
    }

    private void elevatorArray() {
        elevatorList = new ArrayList<>();
        elevatorList.add(new Elevator(0, -2, 10, 10, 900, 1));
        elevatorList.add(new Elevator(5, -5, 8, 5, 700, 1));
    }

    private void userMenu() {
        System.out.println("Du startar nu programmet hissen. Välj om hissen ska åka upp och ner eller om passagerare ska kliva på eller av. \n");

        boolean continueLoop = true;
        while (continueLoop) {
            showMenu();
            int menuChoice = elevatorService.getUserInputInt();
            if (menuChoice >= 0 && menuChoice <= 7) {
                continueLoop = handleMenuChoice(menuChoice);
            } else {
                System.out.println("Du behöver välja ett heltal mellan 0 och 7");
            }
        }
        scanner.close();
    }


    private void showMenu() {
        System.out.println("Välj ett menyval: ");
        System.out.println("0: Byt hiss");
        System.out.println("1: Skriv ut vilken våning hissen är på");
        System.out.println("2: Välj vilken våning hissen ska åka till");
        System.out.println("3: Skriv ut antal passagerare på hissen");
        System.out.println("4: Skriv ut passagerares totala vikt");
        System.out.println("5: Lägg till passagerare");
        System.out.println("6: Ta bort passagerare");
        System.out.println("7: Avsluta programmet\n");
    }

    private boolean handleMenuChoice(int menuChoice) {
        switch (menuChoice) {
            case 0:
                elevator = elevatorService.changeElevator(elevatorList);
                System.out.println("Du är nu i hiss " + elevator.getElevatorIndex() + " på våning " + elevator.getLevel() + "\n");
                break;
            case 1:
                elevatorService.where(elevator);
                break;
            case 2:
                System.out.println("Vilken våning ska hissen åka till?: \n");
                elevatorService.goTo(elevator);
                break;
            case 3:
                elevatorService.totalAmountOfPassengers(elevator);
                break;
            case 4:
                elevatorService.returnTotalPassengerWeight(elevator);
                break;
            case 5:
                elevatorService.addPassenger(elevator);
                break;
            case 6:
                elevatorService.removePassenger(elevator);
                break;
            case 7:
                System.out.println("Programmet avslutas");
                return false;
            default:
                break;
        }
        return true;
    }
}
