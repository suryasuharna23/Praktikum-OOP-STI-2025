public class Wush extends Bike implements Feature {
    private static int count = 0;

    public Wush(boolean subsidized) {
        super("Wush", subsidized ? 600 : 1200, 400);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean discountOffer(Number yourOffer) {
        return yourOffer.doubleValue() >= getPrice().doubleValue() * 0.88;
    }

    @Override
    public void printSpecialFeature() {
        System.out.println("Wush, Wush, Wush, Yes");
    }
}
