package logichandle;

import entity.Driver;

import java.util.Scanner;

public class DriverLogic {
    private Driver[] drivers = new Driver[100];

    public Driver[] getDrivers() {
        return drivers;
    }

    public void inputDrivers() {
        System.out.println("Nhập số lượng lái xe: ");
        int numberDriver = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberDriver; i++) {
            System.out.println("Nhập thông tin cho lái xe thứ " + (i + 1));
            Driver driver = new Driver();
            driver.inputInfo();
            saveDriver(driver);
        }
    }

    public void showDrivers() {
        System.out.println("Danh sách lái xe");
        System.out.printf("%-8s | %-20s | %-20s | %-24s | %-8s | %-26s |\n", "Mã lái xe", "Họ tên", "Địa chỉ", "Số điện thoại", "Loại bằng lái xe", "Tổng số lượt trong ngày");
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                drivers[i].displayInfo();
            }
        }
    }

    public void saveDriver(Driver driver) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] == null) {
                drivers[i] = driver;
                break;
            }
        }
    }

    public Driver searchDriverById(int driverId) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null && drivers[i].getId() == driverId) {
                return drivers[i];
            }
        }
        return null;
    }
}
