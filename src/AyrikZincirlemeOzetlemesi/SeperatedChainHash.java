package AyrikZincirlemeOzetlemesi;

import java.util.ArrayList;
import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        int konum = hash(deger);
        if(dizi[konum] == null){
            dizi[konum] = new LinkedList<>();
        }
        dizi[konum].add(deger);
    }
    public boolean sil(int deger){
        Integer degerInt = Integer.valueOf(deger);
        int konum = hash(deger);
        if(dizi[konum] != null){
            if(dizi[konum].contains(deger)){
                dizi[konum].remove(degerInt);
                return true;
            }
        }
        return false;

    }
    public int asalBul(){
        int currentLenght = dizi.length;
        int temp = 0;

        for (int i = currentLenght*2; true; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j == 0){
                    temp++;
                }
            }
            if(temp == 0){
                return i;
            }
            temp = 0;
        }
    }
    public void yenidenOzetle() {

        int yeniBoyut = asalBul();
        LinkedList<Integer>[] newArray = new LinkedList[yeniBoyut];
        LinkedList<Integer>[] tempArray = dizi;
        dizi = newArray;

        for (LinkedList<Integer> element: tempArray) {
            if(element != null){
                for (int element_element:element) {
                    ekle(element_element);
                }
            }
        }
    }
}