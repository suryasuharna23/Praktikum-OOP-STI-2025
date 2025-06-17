public class Ultra extends Bike {
    private static int count = 0;

    public Ultra() {
        super("Ultra", 1500.50, 500.4);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean discountOffer(Number yourOffer) {
        return (getPrice().doubleValue() - yourOffer.doubleValue()) <= 100;
    }
}
