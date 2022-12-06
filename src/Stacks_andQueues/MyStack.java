package Stacks_andQueues;

public class MyStack<T>{
    private T[] dizi;
    private int elemanSayisi;

    public MyStack(){
        dizi = (T[]) new Object[10];
        elemanSayisi = 0;
    }
    public MyStack(int elemanSayisi){
        dizi = (T[]) new Object[elemanSayisi];

    }
    public T peek(){
        if(elemanSayisi == 0){
            throw new RuntimeException("Underflow");
        }
        return dizi[elemanSayisi -1];
    }

    public void push(T eleman){
        if(elemanSayisi == dizi.length)
            throw new RuntimeException("Out of size");
        dizi[elemanSayisi++] = eleman;
    }

    public T pop(){
        T temp;
        if(elemanSayisi == 0)
            throw new RuntimeException("Underflow");
        temp = dizi[dizi.length-1];
        dizi[dizi.length-1] = null;
        elemanSayisi -= 1;
        return temp;
    }

    public boolean isEmpty(){
        return elemanSayisi==0;
    }

    public void print(){
        for (int i = elemanSayisi-1; i >= 0; i--) {
            System.out.println(dizi[i]);
        }
    }

}
