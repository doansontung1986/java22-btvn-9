package entity;

public class ScheduleTable implements Displayable {
    private Driver driver;
    private RouteDetail[] details;

    public ScheduleTable(Driver driver, RouteDetail[] details) {
        this.driver = driver;
        this.details = details;
    }

    public Driver getDriver() {
        return driver;
    }

    public ScheduleTable setDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public RouteDetail[] getDetails() {
        return details;
    }

    public ScheduleTable setDetails(RouteDetail[] details) {
        this.details = details;
        return this;
    }

    @Override
    public void displayInfo() {
        for (int i = 0; i < details.length; i++) {
            System.out.printf("%-24s | %-24s | %-12s |\n", this.driver.getName(), this.details[i].getRoute().getRouteId(), this.details[i].getRound());
        }
    }
}
