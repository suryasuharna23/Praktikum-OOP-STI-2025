public abstract class Bike implements Discountable {
    private String name;
    private Number price;
    private Number battery;

    public Bike(String name, Number price, Number battery) {
        this.name = name;
        this.price = price;
        this.battery = battery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getBattery() {
        return battery;
    }

    public void setBattery(Number battery) {
        this.battery = battery;
    }

    public void printSpec() {
        System.out.printf("%s $%.2f, %.1fWh\n", name, price.doubleValue(), battery.doubleValue());
    }

    public boolean isBetterThan(Bike otherBike) {
        if (this.battery.doubleValue() > otherBike.battery.doubleValue()) {
            return true;
        } else if (this.battery.doubleValue() == otherBike.battery.doubleValue()) {
            return this.price.doubleValue() < otherBike.price.doubleValue();
        } else {
            return false;
        }
    }
}
