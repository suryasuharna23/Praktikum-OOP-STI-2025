public class Bim extends Bike implements Feature {
    private static int count = 0;

    public Bim() {
        super("Bim", 700, 200.2);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean discountOffer(Number yourOffer) {
        return false;
    }

    @Override
    public void printSpecialFeature() {
        System.out.println("Bim bim bim chota bim chota bim!");
    }
}
