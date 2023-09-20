package entity;

import statics.Level;

import java.util.Scanner;

public class Driver extends Person {
    private static int AUTO_ID = 10000;
    private int id;
    private Level level;

    private int totalRound;
    private int totalDistance;

    public Driver() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public Driver setLevel(Level level) {
        this.level = level;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public Driver setTotalRound(int totalRound) {
        this.totalRound = totalRound;
        return this;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public Driver setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
        return this;
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-8s | %-20s | %-20s | %-24s | %-8s | %-26s |\n", this.id, this.name, this.address, this.phoneNumber, this.level.value, this.totalRound);
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập loại bằng lái, chọn 1 trong các loại sau đây: ");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. D");
        System.out.println("5. E");
        System.out.println("6. F");
        int type = new Scanner(System.in).nextInt();
        switch (type) {
            case 1:
                this.setLevel(Level.A);
                break;
            case 2:
                this.setLevel(Level.B);
                break;
            case 3:
                this.setLevel(Level.C);
                break;
            case 4:
                this.setLevel(Level.D);
                break;
            case 5:
                this.setLevel(Level.E);
                break;
            case 6:
                this.setLevel(Level.F);
                break;
        }
    }

    public void displayTotalDistance() {
        System.out.printf("%-20s | %-12s |\n", this.name, this.totalDistance);
    }
}
