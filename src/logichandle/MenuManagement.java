package logichandle;

import entity.ScheduleTable;

import java.util.Scanner;

public class MenuManagement {
    private final DriverLogic driverLogic = new DriverLogic();
    private final RouteLogic routeLogic = new RouteLogic();
    private final ScheduleTableLogic scheduleTableLogic = new ScheduleTableLogic(driverLogic, routeLogic);

    public void run() {
        while (true) {
            printMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    driverLogic.inputDrivers();
                    break;
                case 2:
                    driverLogic.showDrivers();
                    break;
                case 3:
                    routeLogic.inputRoutes();
                    break;
                case 4:
                    routeLogic.showRoutes();
                    break;
                case 5:
                    scheduleTableLogic.assignDriver();
                    break;
                case 6:
                    scheduleTableLogic.showSchedule();
                    break;
                case 7:
                    ScheduleTable[] sortScheduleTablesByDriverName = scheduleTableLogic.sortScheduleTableByDriverName(scheduleTableLogic.getScheduleTables());
                    scheduleTableLogic.showSchedule(sortScheduleTablesByDriverName);
                    break;
                case 8:
                    ScheduleTable[] sortScheduleTablesByTotalRound = scheduleTableLogic.sortScheduleTableByRoundDesc(scheduleTableLogic.getScheduleTables());
                    scheduleTableLogic.showSchedule(sortScheduleTablesByTotalRound);
                    break;
                case 9:
                    scheduleTableLogic.showTotalDistanceByDriver();
                    break;
                case 10:
                    return;
            }
        }
    }

    private static int chooseFunction() {
        System.out.println("Xin mời lựa chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice > 0 && functionChoice < 11) {
                break;
            }
        } while (true);
        return functionChoice;
    }

    private static void printMenu() {
        System.out.println("------PHẦN MỀM QUẢN LÝ MƯỢN SÁCH");
        System.out.println("1. Nhập lái xe mới");
        System.out.println("2. In danh sách lái xe");
        System.out.println("3. Nhập chặng đường mới");
        System.out.println("4. In danh sách chặng đường");
        System.out.println("5. Lập bảng phân công");
        System.out.println("6. In danh sách phân công");
        System.out.println("7. Sắp xếp danh sách phân công theo họ tên lái xe");
        System.out.println("8. Sắp xếp danh sách phân công theo số lượng tuyến đảm nhận trong ngày (giảm dần)");
        System.out.println("9. Thống kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
        System.out.println("10. Thoát");
    }
}
