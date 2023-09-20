package entity;

import java.util.Scanner;

public class Route implements Inputable, Displayable {
    private static int AUTO_ID = 100;
    private int routeId;
    private int distance;
    private int numberOfStops;

    public Route() {
        this.routeId = AUTO_ID;
        AUTO_ID++;
    }

    public int getRouteId() {
        return routeId;
    }

    public Route setRouteId(int routeId) {
        this.routeId = routeId;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Route setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public Route setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
        return this;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập khoảng cách của chuyến: ");
        this.distance = new Scanner(System.in).nextInt();
        System.out.println("Nhập số trạm dừng: ");
        this.numberOfStops = new Scanner(System.in).nextInt();
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-16s | %-16s | %-16s |\n", this.routeId, this.distance, this.numberOfStops);
    }
}
