public class Ngeng extends Bike {
    private static int count = 0;

    public Ngeng() {
        super("Ngeng", 1100.10, 350.1);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean discountOffer(Number yourOffer) {
        return yourOffer.doubleValue() >= getPrice().doubleValue() * 0.92;
    }
}
