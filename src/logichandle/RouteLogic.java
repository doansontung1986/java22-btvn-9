package logichandle;

import entity.Driver;
import entity.Route;

import java.util.Scanner;

public class RouteLogic {
    private Route[] routes = new Route[100];

    public void inputRoutes() {
        System.out.println("Nhập số lượng chặng đường: ");
        int numberRoute = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberRoute; i++) {
            System.out.println("Nhập thông tin cho chặng đường thứ " + (i + 1));
            Route route = new Route();
            route.inputInfo();
            saveRoute(route);
        }
    }

    public void showRoutes() {
        System.out.println("Danh sách chặng đường");
        System.out.printf("%-16s | %-16s | %-16s |\n", "Mã chặng đường ", "Quãng đường", "Số trạm dừng");
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null) {
                routes[i].displayInfo();
            }
        }
    }

    public void saveRoute(Route route) {
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] == null) {
                routes[i] = route;
                break;
            }
        }
    }

    public Route searchDriverById(int routeId) {
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null && routes[i].getRouteId() == routeId) {
                return routes[i];
            }
        }
        return null;
    }
}
