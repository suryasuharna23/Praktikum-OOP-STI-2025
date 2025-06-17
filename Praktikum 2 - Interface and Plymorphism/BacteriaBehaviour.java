/*
    Nama                    : 
    NIM                     : 18223050
    Hari dan tanggal        : 
    Deskripsi Program       :
*/

/**
 * BacteriaBehaviour.java
 * 
 * Interface untuk mendefinisikan perilaku dasar bakteri.
 */
public interface BacteriaBehaviour {
    String getName();
    int getCurrentPopulation();
    double getGrowthRate();
    boolean hasKanR();
    
    void setCurrentPopulation(int population);
    void setGrowthRate(double growthRate);
    void setKanR(boolean resistant);
    void reproduce(int days, double effectiveModifier);
}
