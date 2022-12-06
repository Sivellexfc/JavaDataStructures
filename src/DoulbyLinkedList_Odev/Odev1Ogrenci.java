package DoulbyLinkedList_Odev;

import LinkedList.Node;

public class Odev1Ogrenci extends DoublyLinkedList<Ilan> {
    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların günlerinin küçükten büyüğe doğru sıralı olmasını sağlar
     * @param ilan Eklenecek ilan
     */
    public void guneGoreSiraliEkle(Ilan ilan) {
        Node<Ilan> current;
        Node<Ilan> head = getHead();
        Node<Ilan> newNode = new Node<>(ilan,null,null);

        if (head == null)
            addFirst(ilan);

        else if (head.value.getGun() >= newNode.value.getGun()) {
            addFirst(ilan);
        }
        else {
            current = head;
            while (current.next != null && current.next.value.getGun() < newNode.value.getGun())
                current = current.next;
            newNode.next = current.next;

            if (current.next != null)
                newNode.next.previous = newNode;
            current.next = newNode;
            newNode.previous = current;
        }

    }

    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların fiyatlarının küçükten büyüğe doğru sıralı olmasını sağlar
     * @param ilan Eklenecek ilan
     */
    public void fiyataGoreSiraliEkle(Ilan ilan){

    }

    /**
     * Bu metot bağlı listeye ekleme yaparken ilanların günlerine göre sıralama yapar, eğer günleri aynı ise fiyatlarına göre kendi aralarında küçükten büyüğe sıralama yapar
     * @param ilan
     */
    public void guneVeFiyataGoreSiraliEkle(Ilan ilan) {

    }
}
