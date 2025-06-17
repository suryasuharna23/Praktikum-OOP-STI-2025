import java.util.*;

class CatalogBarang<T> {
    private final T barang;
    private final int jumlah;

    public CatalogBarang(T barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public T barang() {
        return barang;
    }

    public int jumlah() {
        return jumlah;
    }
}

public class InventoryManager<A extends Barang> {
    private ArrayList<CatalogBarang<A>> inventory; // List menyimpan item inventory

    /**
     * Konstruktor untuk InventoryManager
     * 
     * Mendefinisikan list inventory
     */
    public InventoryManager() {
        this.inventory = new ArrayList<CatalogBarang<A>>();
    }

    /**
     * Menambahkan katalog barang baru ke dalam inventory
     * 
     * @param item   barang yang akan ditambahkan
     * @param jumlah jumlah barang yang akan ditambahkan
     * 
     */
    public void addCatalog(A item, int jumlah) {
        CatalogBarang<A> catalog = new CatalogBarang<A>(item, jumlah);
        inventory.add(catalog);
    }

    /**
     * Menghapus katalog barang terakhir dalam inventory
     * Apabila inventory berisi [A, B, C] maka fungsi ini akan menghilangkan C
     * Apabila inventory kosong, akan mencetak "Inventory Kosong"
     */
    public void removeCatalog() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory Kosong");
        } else {
            inventory.remove(inventory.size() - 1);
        }
    }

    /**
     * Mencetak total katalog barang tiap tipe barang
     * untuk fungsi ini ASUMSIKAN BAHAWA HANYA ADA BAJU DAN HANDPHONE DALAM INVENTORY
     * Apabila kosong, jumlah baju akan 0 dan jumlah handphone akan 0
     * Apabila inventory berisi [(Baju, 12), (Baju, 14), (Handphone, 2)]
     * maka fungsi ini akan mencetak :
     * 
     * [Total Baju : 2]
     * [Total Handphone : 1]
     */
    public void printTotalType() {
        int totalBaju = 0;
        int totalHandphone = 0;
        
        for (CatalogBarang<A> catalog : inventory) {
            A item = catalog.barang();
            if (item instanceof Baju) {
                totalBaju++;
            } else if (item instanceof Handphone) {
                totalHandphone++;
            }
        }
        
        System.out.println("[Total Baju : " + totalBaju + "]");
        System.out.println("[Total Handphone : " + totalHandphone + "]");
    }

    /**
     * Mendapatkan total jumlah (amount) suatu barang dengan tipe tertentu dalam
     * inventory
     * Apabila itemType bukan merupakan "Baju" atau "Handphone" maka fungsi ini akan
     * mengembalikan -1
     * 
     * Misalnya inventory berisi [(Baju, 12), (Baju, 14), (Handphone, 2)] dan fungsi
     * manager.getTotalAmount("Baju") dipanggil maka akan mengembalikan
     * 26
     * karena 12 + 14 dari total amount catalog barang yang bertipe Baju.
     *
     * @param itemType tipe barang yang akan dihitung jumlahnya
     */
    public int getTotalAmount(String itemType) {
        if (!itemType.equals("Baju") && !itemType.equals("Handphone")) {
            return -1;
        }
        
        int totalAmount = 0;
        for (CatalogBarang<A> catalog : inventory) {
            A item = catalog.barang();
            if ((itemType.equals("Baju") && item instanceof Baju) ||
                (itemType.equals("Handphone") && item instanceof Handphone)) {
                totalAmount += catalog.jumlah();
            }
        }
        
        return totalAmount;
    }

    /**
     * Mendapatkan total jumlah harga semua barang dalam inventory
     * Total harga didapatkan dari total penjumlahan hasil price barang dikali
     * dengan amount barang tersebut untuk semua barang dalam inventory
     * 
     * Misalnya :
     * Baju1 punya harga 10
     * HP1 punya harga 20
     * Inventory berbentuk : [(Baju1, 10), (HP1, 2)]
     * maka manager.getTotalPrice() akan mengembalikan 140
     * dari : (10 * 10) + (20 * 2) = 140
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (CatalogBarang<A> catalog : inventory) {
            A item = catalog.barang();
            totalPrice += item.getPrice() * catalog.jumlah();
        }
        return totalPrice;
    }

    /**
     * Apabila inventory kosong, akan mencetak "Inventory Kosong"
     * Apabila terdapat katalog barang dalam inventory akan mencetak setiap katalog
     * barang dalam format :
     * [Name(Price) : Amount]
     * Misalnya, kalau inventory berisi Kaos Putih seharga 50 berjumlah 10 maka
     * fungsi ini akan mencetak :
     * [Kaos Putih(50) : 10]
     */
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory Kosong");
        } else {
            for (CatalogBarang<A> catalog : inventory) {
                A item = catalog.barang();
                System.out.println("[" + item.getName() + "(" + item.getPrice() + ") : " + catalog.jumlah() + "]");
            }
        }
    }

}

/**
 * Kelas-kelas yang akan digunakan untuk soal ini
 */

class Barang {
    private String name;
    private int price;

    public Barang(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}

class Baju extends Barang {
    private String color;

    public Baju(String name, String color, int price) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}

class Handphone extends Barang {
    private String merk;

    public Handphone(String name, String merk, int price) {
        super(name, price);
        this.merk = merk;
    }

    public String getMerk() {
        return this.merk;
    }
}