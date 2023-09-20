package logichandle;

import entity.Driver;
import entity.Route;
import entity.RouteDetail;
import entity.ScheduleTable;

import java.util.Arrays;
import java.util.Scanner;

public class ScheduleTableLogic {
    private DriverLogic driverLogic;
    private RouteLogic routeLogic;
    private ScheduleTable[] scheduleTables = new ScheduleTable[100];

    public ScheduleTableLogic(DriverLogic driverLogic, RouteLogic routeLogic) {
        this.driverLogic = driverLogic;
        this.routeLogic = routeLogic;
    }

    public DriverLogic getDriverLogic() {
        return driverLogic;
    }

    public ScheduleTableLogic setDriverLogic(DriverLogic driverLogic) {
        this.driverLogic = driverLogic;
        return this;
    }

    public RouteLogic getRouteLogic() {
        return routeLogic;
    }

    public ScheduleTableLogic setRouteLogic(RouteLogic routeLogic) {
        this.routeLogic = routeLogic;
        return this;
    }

    public ScheduleTable[] getScheduleTables() {
        return scheduleTables;
    }

    public ScheduleTableLogic setScheduleTables(ScheduleTable[] scheduleTables) {
        this.scheduleTables = scheduleTables;
        return this;
    }

    public void assignDriver() {
        System.out.println("Nhập số lượng lái xe muốn phân công: ");
        int numberAssignee = new Scanner(System.in).nextInt();

        for (int i = 0; i < numberAssignee; i++) {
            System.out.println("Nhập thông tin cho lái xe thứ " + (i + 1));
            Driver driver = inputDriverForAssign();
            RouteDetail[] routeDetails = inputRouteDetail(driver);
            ScheduleTable scheduleTable = new ScheduleTable(driver, routeDetails);
            saveSchedule(scheduleTable);
        }
    }

    public void showSchedule() {
        System.out.printf("%-24s | %-24s | %-12s |\n", "Họ tên", "Chặng đường", "Số lượt");
        for (int i = 0; i < scheduleTables.length; i++) {
            if (scheduleTables[i] != null) {
                scheduleTables[i].displayInfo();
            }
        }
    }

    public void showSchedule(ScheduleTable[] scheduleTables) {
        System.out.printf("%-24s | %-24s | %-12s |\n", "Họ tên", "Chặng đường", "Số lượt");
        for (int i = 0; i < scheduleTables.length; i++) {
            if (scheduleTables[i] != null) {
                scheduleTables[i].displayInfo();
            }
        }
    }

    public void showTotalDistanceByDriver() {
        System.out.printf("%-20s | %-12s |\n", "Họ tên", "Tổng số khoảng cách");
        for (int i = 0; i < scheduleTables.length; i++) {
            if (scheduleTables[i] != null) {
                scheduleTables[i].getDriver().displayTotalDistance();
            }
        }
    }

    private void saveSchedule(ScheduleTable scheduleTable) {
        for (int i = 0; i < scheduleTables.length; i++) {
            if (scheduleTables[i] == null) {
                scheduleTables[i] = scheduleTable;
                break;
            }
        }
    }

    private RouteDetail[] inputRouteDetail(Driver driver) {
        System.out.println("Nhập số quãng đường muốn phân công cho lái xe: ");
        int numberRoute = new Scanner(System.in).nextInt();

        RouteDetail[] routeDetails = new RouteDetail[numberRoute];
        int count = 0;

        for (int i = 0; i < numberRoute; i++) {
            System.out.println("Nhập thông tin phân công thứ " + (i + 1));
            int routeId;
            Route route;
            do {
                System.out.println("Nhập quãng đường muốn phân công: ");
                routeId = new Scanner(System.in).nextInt();
                route = routeLogic.searchDriverById(routeId);

                if (route != null) {
                    break;
                }
            } while (true);

            driver.setTotalDistance(driver.getTotalDistance() + route.getDistance());

            System.out.println("Nhập số lượt cho quãng đường: ");
            int round;

            do {
                round = new Scanner(System.in).nextInt();

                if (round > 0 && round < 16) {
                    int sumRound = driver.getTotalRound() + round;
                    if (driver.getTotalRound() == 15) {
                        System.out.println("Đã đủ số lượt trong ngày");
                        break;
                    } else if (sumRound <= 15) {
                        driver.setTotalRound(sumRound);
                        break;
                    } else {
                        int remainingRound = 15 - driver.getTotalRound();
                        System.out.println("Số lượt trong ngày không đủ. Hiện ta còn " + remainingRound + " lượt");
                    }
                } else {
                    System.out.println("Số lượt trong ngày tối đa là 15");
                }
            } while (true);

            RouteDetail routeDetail = new RouteDetail(route, round);
            routeDetails[count] = routeDetail;
            count++;
        }
        return routeDetails;
    }

    private Driver inputDriverForAssign() {
        System.out.println("Nhập mã lái xe cần phân công");
        int driverId;
        Driver driver;
        do {
            driverId = new Scanner(System.in).nextInt();

            driver = driverLogic.searchDriverById(driverId);

            if (driver != null) {
                break;
            }
            System.out.print("Không tồn tại lái xe mang mã " + driverId + ", vui lòng nhập lại: ");
        } while (true);
        return driver;
    }

    public ScheduleTable[] sortScheduleTableByDriverName(ScheduleTable[] scheduleTables) {
        ScheduleTable[] sortedScheduleTable = Arrays.copyOf(scheduleTables, scheduleTables.length);

        for (int i = 0; i < sortedScheduleTable.length - 1; i++) {
            boolean isSwap = false;
            Driver driver = null;
            if (sortedScheduleTable[i] != null) {
                driver = sortedScheduleTable[i].getDriver();
            }

            for (int j = i + 1; j < sortedScheduleTable.length; j++) {
                Driver nextDriver = null;
                if (sortedScheduleTable[j] != null) {
                    nextDriver = sortedScheduleTable[j].getDriver();
                }

                if (driver != null && nextDriver != null && driver.getName().compareTo(nextDriver.getName()) > 0) {
                    swapElement(sortedScheduleTable, i, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }

        return sortedScheduleTable;
    }

    public ScheduleTable[] sortScheduleTableByRoundDesc(ScheduleTable[] scheduleTables) {
        ScheduleTable[] sortedScheduleTable = Arrays.copyOf(scheduleTables, scheduleTables.length);
        for (int i = 0; i < sortedScheduleTable.length - 1; i++) {
            boolean isSwap = false;
            Driver driver = null;
            if (sortedScheduleTable[i] != null) {
                driver = sortedScheduleTable[i].getDriver();
            }
            for (int j = i + 1; j < sortedScheduleTable.length; j++) {
                Driver nextDriver = null;
                if (sortedScheduleTable[j] != null) {
                    nextDriver = sortedScheduleTable[j].getDriver();
                }

                if (driver != null && nextDriver != null && driver.getTotalRound() < nextDriver.getTotalRound()) {
                    swapElement(sortedScheduleTable, i, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }

        return sortedScheduleTable;
    }

    private void swapElement(ScheduleTable[] scheduleTables, int i, int j) {
        ScheduleTable tempScheduleTable = scheduleTables[i];
        scheduleTables[i] = scheduleTables[j];
        scheduleTables[j] = tempScheduleTable;
    }
}
