import java.util.Random;

public class Passenger {
    private final int passengerWeight;

    public Passenger(int minWeight, int maxWeight) {
        this.passengerWeight = randomPassengerWeight(minWeight, maxWeight);
    }

    public int randomPassengerWeight(int minWeight, int maxWeight) {
        Random random = new Random();
        return random.nextInt(minWeight, maxWeight + 1);
    }

    public int getPassengerWeight() {
        return passengerWeight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerWeight=" + passengerWeight +
                '}';
    }
}
