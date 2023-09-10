package prelim;

public class ExecutableMyDoublyLinkedList {
    private class Music{
        private String title;
        private String artist;

        public Music(String title, String artist){
            this.title = title;
            this.artist = artist;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        @Override
        public String toString() {
            return this.title +" by "+ this.artist;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    public static void main(String[] args) {
        try {
            ExecutableMyDoublyLinkedList program = new ExecutableMyDoublyLinkedList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        MyDoublyLinkedList<Music> doubly = new MyDoublyLinkedList<>();

        Music m1 = new Music("Payphone", "Maroon 5");
        Music m2 = new Music("Bohemian Rhapsody", "Queen");
        Music m3 = new Music("Shape of You", "Ed Sheeran");
        Music m4 = new Music("Imagine", "John Lennon");
        Music m5 = new Music("Hotel California", "Eagles");
        Music m6 = new Music("Rolling in the Deep", "Adele");
        Music m7 = new Music("Billie Jean", "Michael Jackson");

        /*
        doubly.insertAtHead(m1);
        doubly.insertAtTail(m2);
        doubly.insertAtTail(m3);
        doubly.insertAtTail(m4);
        doubly.insertAtTail(m5);


         */

        doubly.insertAtIndex(0,m1);


        System.out.println(doubly.toString());
        System.out.println("CURRENT HEAD: " + doubly.getHead());
        System.out.println("CURRENT TAIL: " + doubly.getTail());
        System.out.println(doubly.getSize());


        doubly.deleteAtHead();
        doubly.deleteAtTail();
        doubly.deleteAtIndex(1);
        System.out.println("\n\n\n"+doubly.toString());
        System.out.println("CURRENT HEAD: " + doubly.getHead());
        System.out.println("CURRENT TAIL: " + doubly.getTail());
        System.out.println(doubly.getSize());

    }
}
