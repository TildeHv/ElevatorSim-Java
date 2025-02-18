import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private int level;
    private final int minLevel;
    private final int maxLevel;
    private final int maxPassengers;
    private final int maxWeight;
    private final List<Passenger> passengerList;
    private int elevatorIndex;

    public Elevator(int level, int minLevel, int maxLevel, int maxPassengers, int maxWeight, int elevatorIndex) {
        this.level = level;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.maxPassengers = maxPassengers;
        this.maxWeight = maxWeight;
        this.passengerList = new ArrayList<>();
        this.elevatorIndex = elevatorIndex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public int getElevatorIndex() {
        return elevatorIndex;
    }

    public void setElevatorIndex(int elevatorIndex) {
        this.elevatorIndex = elevatorIndex;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "level=" + level +
                ", minLevel=" + minLevel +
                ", maxLevel=" + maxLevel +
                ", maxPassengers=" + maxPassengers +
                ", maxWeight=" + maxWeight +
                ", passengerList=" + passengerList +
                ", elevatorIndex=" + elevatorIndex +
                '}';
    }
}



