package QuadraticProbeHash;


public class QuadraticProbeHashing<T> {

    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }

    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }

    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        int konum=hash(eleman);
        int deneme=0;
        while (true) {
            if (dizi[qk(konum, deneme)] == null || !dizi[qk(konum, deneme)].isActive) {
                dizi[qk(konum, deneme)]=new HashEntry<>(eleman);
                elemanSayisi++;
                break;
            }
            else
                deneme++;
        }
    }

    public int qk(int konum, int deneme) {
        return (konum+deneme*deneme)%dizi.length;
    }

    public boolean sil(T eleman){
        int konum=hash(eleman);
        int deneme=0;
        while (dizi[qk(konum, deneme)]==null || !dizi[qk(konum, deneme)].isActive || !dizi[qk(konum, deneme)].value.equals(eleman)){
            deneme++;
            if(deneme>dizi.length)
                return false;
        }
        dizi[qk(konum, deneme)].isActive=false;
        elemanSayisi--;
        return true;
    }
}
