public class Main {
    public static void main(String[] args) {
        Pesawat pesawat = new Pesawat("Singa Air", "Korea Timur", 1000);
        Kapal kapal = new Kapal("Kapal Api", "Tanah Thai", 2000);

        WargaSipil budi = new KapalAdapter(kapal, "Tuan Budi");
        budi.urusAdministrasi();
        System.out.println("--------------------");
        budi.cobaKabur();
        System.out.println("--------------------");
        budi.berhasilKabur();
        System.out.println("Budi berhasil kabur, selamat tinggal Konoha!");
        
        WargaSipil moel = new PesawatAdapter(pesawat, "Tuan Moel");
        moel.urusAdministrasi();
        System.out.println("--------------------");
        moel.cobaKabur();
        System.out.println("--------------------");
        moel.berhasilKabur();
        System.out.println("Moel berhasil kabur, sayonara!");
    }
}