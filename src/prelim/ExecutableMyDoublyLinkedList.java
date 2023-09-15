/**
 * SAMPLE RUN:
 *
 * CURRENT HEAD: Payphone by Maroon 5
 * CURRENT TAIL: Shape of You by Ed Sheeran
 * CURRENT SIZE: 3
 * null <-> Payphone by Maroon 5 <-> Bohemian Rhapsody by Queen <-> Shape of You by Ed Sheeran <-> null
 *
 *
 * CURRENT HEAD: Imagine by John Lennon
 * CURRENT TAIL: Billie Jean by Michael Jackson
 * CURRENT SIZE: 7
 * null <-> Imagine by John Lennon <-> Payphone by Maroon 5 <-> Bohemian Rhapsody by Queen <-> Shape of You by Ed Sheeran <-> Hotel California by Eagles <-> Rolling in the Deep by Adele <-> Billie Jean by Michael Jackson <-> null
 *
 *
 * CURRENT HEAD: Payphone by Maroon 5
 * CURRENT TAIL: Rolling in the Deep by Adele
 * CURRENT SIZE: 4
 * null <-> Payphone by Maroon 5 <-> Bohemian Rhapsody by Queen <-> Shape of You by Ed Sheeran <-> Rolling in the Deep by Adele <-> null
 *
 *
 *
 * SEARCH KEY: Shape of You by Ed Sheeran
 * SEARCH STATUS (index of key): 2
 */
package prelim;

public class ExecutableMyDoublyLinkedList {
    /**
     * The class Music will be used to emulate a MUSIC PLAYER in which a music player has songs that have a previous song and a next song.
     * The music class has 2 attributes which are the song title and song artist.
     */
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

    /**
     * This method simply displays the different functions of the MyDoublyLinkedList methods and how it is used in different use cases.
     * The code below displays how the insert and deletion methods are used in different scenarios. The search method is also displayed to display its function.
     */
    public void run(){
        MyDoublyLinkedList<Music> doubly = new MyDoublyLinkedList<>();

        Music m1 = new Music("Payphone", "Maroon 5");
        Music m2 = new Music("Bohemian Rhapsody", "Queen");
        Music m3 = new Music("Shape of You", "Ed Sheeran");
        Music m4 = new Music("Imagine", "John Lennon");
        Music m5 = new Music("Hotel California", "Eagles");
        Music m6 = new Music("Rolling in the Deep", "Adele");
        Music m7 = new Music("Billie Jean", "Michael Jackson");

        doubly.insertAtHead(m1);
        doubly.insertAtTail(m2);
        doubly.insertAtIndex(2,m3);

        System.out.println("ADDING m1 at head, m2 at tail, and m3 at index 3");
        System.out.println("CURRENT HEAD: " + doubly.getHead());
        System.out.println("CURRENT TAIL: " + doubly.getTail());
        System.out.println("CURRENT SIZE: " + doubly.getSize());
        System.out.println(doubly.toString());

        doubly.insertAtHead(m4);
        doubly.insertAtTail(m5);
        doubly.insertAtTail(m6);
        doubly.insertAtIndex(6,m7);
        System.out.println("\n\nADDING m4 at head, m5 at tail, m6 at tail, and m7 in index 6");
        System.out.println("CURRENT HEAD: " + doubly.getHead());
        System.out.println("CURRENT TAIL: " + doubly.getTail());
        System.out.println("CURRENT SIZE: " + doubly.getSize());
        System.out.println(doubly.toString());

        doubly.deleteAtTail();
        doubly.deleteAtHead();
        doubly.deleteAtIndex(3);
        System.out.println("\n\nDELETING current tail, current head, and node at index 3");
        System.out.println("CURRENT HEAD: " + doubly.getHead());
        System.out.println("CURRENT TAIL: " + doubly.getTail());
        System.out.println("CURRENT SIZE: " + doubly.getSize());
        System.out.println(doubly.toString());

        System.out.println("\n\n\nSEARCH KEY: " + m3);
        System.out.println("SEARCH STATUS (index of key): " + doubly.search(m3));
    }
}
