package prelim;

public class ExecutableMySinglyLinkedList {

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
    }
    public static void main(String[] args) {
        try {
            ExecutableMySinglyLinkedList program = new ExecutableMySinglyLinkedList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        MySinglyLinkedList singly = new MySinglyLinkedList();

        singly.insertAtHead(new Sneaker("Nike","Dunks"));
        singly.insertAtTail(new Sneaker("Adidas", "Samba"));
        singly.insertAtTail(new Sneaker("Nike", "Air Force 1"));
        singly.insertAtTail(new Sneaker("New Balance", "550"));
        singly.insertAtTail(new Sneaker("Yeezy Boost", "350"));

        System.out.println("HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("SIZE: " + singly.getSize());
        System.out.println(singly.toString());

        System.out.println();


        singly.deleteAtIndex(4);
        System.out.println(singly.toString());
        System.out.println("HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("SIZE: " + singly.getSize());

        singly.insertAtIndex(2,new Sneaker ("ABC", "EFG"));
        System.out.println(singly.toString());
        System.out.println("HEAD: " + singly.getHead());
        System.out.println("CURRENT TAIL: " + singly.getTail());
        System.out.println("SIZE: " + singly.getSize());
    }
}
