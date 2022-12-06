package DoulbyLinkedList_Odev;

import LinkedList.DoublyLinkedList;

public class main {
    public static void main(String[] args) {
        Ilan ilan1 = new Ilan("asdas","asd",6,2132);
        Ilan ilan2 = new Ilan("aasdas","asd",2,2132);
        Ilan ilan3 = new Ilan("asddas","asd",9,2132);
        Ilan ilan4 = new Ilan("asdhas","asd",20,2132);
        Ilan ilan5 = new Ilan("asdafvs","asd",12,2132);
        Ilan ilan6 = new Ilan("assdas","asd",17,2132);
        Ilan ilan7 = new Ilan("asduas","asd",3,2132);
        Ilan ilan8 = new Ilan("asdaes","asd",5,2132);
        Ilan ilan9 = new Ilan("asdasas","asd",11,2132);
        Ilan ilan10 = new Ilan("assdas","asd",5,2132);

        Odev1Ogrenci list = new Odev1Ogrenci();
        list.guneGoreSiraliEkle(ilan1);
        list.guneGoreSiraliEkle(ilan2);
        list.guneGoreSiraliEkle(ilan4);
        list.guneGoreSiraliEkle(ilan3);
        list.guneGoreSiraliEkle(ilan5);
        list.guneGoreSiraliEkle(ilan6);
        list.guneGoreSiraliEkle(ilan7);
        list.guneGoreSiraliEkle(ilan8);
        list.guneGoreSiraliEkle(ilan9);
        list.guneGoreSiraliEkle(ilan10);


        list.print();
    }
}
