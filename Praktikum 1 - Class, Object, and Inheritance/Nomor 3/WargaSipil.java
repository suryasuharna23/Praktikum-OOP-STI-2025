public abstract class WargaSipil {
    protected String namaPemesan;
    protected int harga;

    public WargaSipil(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public abstract void urusAdministrasi();
    
    public abstract void cobaKabur();

    public abstract void berhasilKabur();
}