package entity;

public class RouteDetail {
    private Route route;
    private int round;

    public RouteDetail(Route route, int round) {
        this.route = route;
        this.round = round;
    }

    public Route getRoute() {
        return route;
    }

    public RouteDetail setRoute(Route route) {
        this.route = route;
        return this;
    }

    public int getRound() {
        return round;
    }

    public RouteDetail setRound(int round) {
        this.round = round;
        return this;
    }
}
