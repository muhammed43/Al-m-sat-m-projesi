public class Urun {
    
    //urun bilgileri
    private int id;
    private String isim;
    private double stok;
    private double fiyat;

    //yapilandirici
    public Urun(int id,String isim,double fiyat, double stok) {
        this.id = id;
        this.isim = isim;
        this.stok = stok;
        this.fiyat = fiyat;
    }

    //getter ve setterlar
    public int getId() {
        return this.id;
    }
    public String getIsim() {
        return this.isim;
    }
    public double getStok() {
        return this.stok;
    }
    public void setStok(double stok) {
        this.stok = stok;
    }
    public double getFiyat() {
        return this.fiyat;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\tisim: " + this.isim + "\tstok: " + this.stok + " kg\tfiyat: " + this.fiyat + " TL";
    }
}
