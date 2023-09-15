/**
 * SAMPLE RUN:
 *
 *CURRENT HEAD: Nike Air Force 1
 * CURRENT TAIL: Vans Vans Old Skool
 * CURRENT SIZE: 4
 * Nike Air Force 1 -> Nike Dunks -> Adidas Ultraboost -> Vans Vans Old Skool -> null
 *
 *
 *
 * CURRENT HEAD: New Balance 550
 * CURRENT TAIL: Vans Vans Old Skool
 * CURRENT SIZE: 5
 * New Balance 550 -> Nike Air Force 1 -> Nike Dunks -> Adidas Ultraboost -> Vans Vans Old Skool -> null
 *
 *
 *
 * CURRENT HEAD: New Balance 550
 * CURRENT TAIL: Nike Dunks
 * CURRENT SIZE: 3
 * New Balance 550 -> Nike Air Force 1 -> Nike Dunks -> null
 *
 *
 *
 * SEARCH: Nike Air Force 1
 * 1
 * GET ELEMENT: Nike Dunks
 *
 * CURRENT HEAD: New Balance 550
 * CURRENT TAIL: Nike Dunks
 * CURRENT SIZE: 3
 * New Balance 550 -> Nike Air Force 1 -> Nike Dunks -> null
 */
package prelim;

import java.util.Objects;

public class ExecutableMySinglyLinkedList {
    /**
     * The class Sneaker will be used as an example for this linked list executable class.
     * The Sneaker class has 2 attributes which are brand and model of the shoes.
     */
    private class Sneaker{
        private String brand;
        private String model;

        public Sneaker(String brand, String model){
            this.brand = brand;
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return this.brand + " " + this.model;
        }

        @Override
        public boolean equals(Object obj) {
            Sneaker another = (Sneaker) obj;

            return this.brand.equalsIgnoreCase(another.getBrand()) && this.model.equalsIgnoreCase(another.getModel());
        }
    }
    public static void main(String[] args) {
        try {
            ExecutableMySinglyLinkedList program = new ExecutableMySinglyLinkedList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * In this run method, several methods of the MySinglyLinkedList class is implemented to show their functionalities.
     *
     * The insert and delete methods are also stated to illustrate their different versions.
     *
     * The current head, current tail, and current size are also displayed to visualize the change in linked list if these methods are utilized.
     */
    public void run(){
        MySinglyLinkedList<Sneaker> singly = new MySinglyLinkedList<>();

        Sneaker s1 = new Sneaker("Nike", "Air Force 1");
        Sneaker s2 = new Sneaker("Nike", "Dunks");
        Sneaker s3 = new Sneaker("Adidas","Ultraboost");
        Sneaker s4 = new Sneaker("Vans","Old Skool");
        Sneaker s5 = new Sneaker("New Balance","550");
        Sneaker s6 = new Sneaker("Under Armour","Curry 7");

        singly.insertAtHead(s1);
        singly.insertAtTail(s2);
        singly.insertAtTail(s3);
        singly.insertAtTail(s4);

        System.out.println("ADDING s1 at head, s2, s3, and s4");
        System.out.println("CURRENT HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("CURRENT SIZE: " + singly.getSize());
        System.out.println(singly.toString());

        singly.insertAtHead(s5);
        System.out.println("\n\n\nADDING s5 at head");
        System.out.println("CURRENT HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("CURRENT SIZE: " + singly.getSize());
        System.out.println(singly.toString());

        singly.deleteAtTail();
        singly.deleteAtIndex(3);
        System.out.println("\n\n\nDELETING current tail and node at index 3");
        System.out.println("CURRENT HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("CURRENT SIZE: " + singly.getSize());
        System.out.println(singly.toString());

        System.out.println("\n\n\nSEARCH: Nike Air Force 1");
        System.out.println(singly.search(new Sneaker("Nike","Air Force 1")));
        System.out.println("GET ELEMENT: " + singly.getElement(2));
        System.out.println("\nCURRENT HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("CURRENT SIZE: " + singly.getSize());
        System.out.println(singly.toString());
    }
}
