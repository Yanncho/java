package fr.epita.assistants.linkedlist;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(8);
        list.insert(4);
        list.insert(6);
        list.insert(10);
        System.out.println(list.start.data);
        System.out.println(list.start.next.data);
        System.out.println(list.start.next.next.data);
        System.out.println(list.start.next.next.next.data);
        list.remove(0);

        System.out.println(list.start.data);
        System.out.println(list.start.next.data);
        System.out.println(list.start.next.next.data);
    }
}
