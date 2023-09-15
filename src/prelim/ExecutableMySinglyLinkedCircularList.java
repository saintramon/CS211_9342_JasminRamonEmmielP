/**
 * SAMPLE RUN:
 *
 * CURRENT HEAD: Warriors, Steve Kerr, 15
 * CURRENT TAIL: Clippers, Tyronn Lue, 15
 * CURRENT TAIL.NEXT: Warriors, Steve Kerr, 15
 * CURRENT SIZE: 12
 * HEAD: Warriors, Steve Kerr, 15 --> Knicks, Tom Thibodeau, 15 --> Cavaliers, Lady Gaga, 15 --> Timberwolves, Elton John, 15 --> Heat, John Rey De Torres, 15 --> Bulls, Billy Donovan, 15 --> Rockets, Stephen Silas, 15 --> Suns, Monty Williams, 15 --> TAIL: Clippers, Tyronn Lue, 15 --> HEAD: Warriors, Steve Kerr, 15 --> ...
 *
 *
 * CURRENT HEAD: Knicks, Tom Thibodeau, 15
 * CURRENT TAIL: Suns, Monty Williams, 15
 * CURRENT TAIL.NEXT: Cavaliers, Lady Gaga, 15
 * CURRENT SIZE: 8
 * HEAD: Knicks, Tom Thibodeau, 15 --> Cavaliers, Lady Gaga, 15 --> Timberwolves, Elton John, 15 --> Bulls, Billy Donovan, 15 --> Rockets, Stephen Silas, 15 --> TAIL: Suns, Monty Williams, 15 --> HEAD: Knicks, Tom Thibodeau, 15 --> ...
 *
 *
 * TO SEARCH: Timberwolves, Elton John, 15
 * SEARCH STATUS (index of key): 2
 */
package prelim;

public class ExecutableMySinglyLinkedCircularList {
    /**
     * The Basketball Team class will be used for the implementation of the Circular Singly Linked List class.
     * It is to imagine that a tournament for basketball teams are going on and there is a ROUND ROBIN part, hence, the circular singly linked list was utilized.
     */
    private class BasketballTeam{
        private String teamName;
        private String coach;
        private int teamSize;

        public BasketballTeam(String teamName, String coach, int teamSize){
            this.teamName = teamName;
            this.coach = coach;
            this.teamSize = teamSize;
        }

        public int getTeamName() {
            return teamSize;
        }

        public String getCoach() {
            return coach;
        }

        public int getTeamSize() {
            return teamSize;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public void setCoach(String coach) {
            this.coach = coach;
        }

        public void setTeamSize(int teamSize) {
            this.teamSize = teamSize;
        }

        @Override
        public String toString() {
            return this.teamName + ", " + this.coach + ", " + this.teamSize;
        }
    }

    public static void main(String[] args) {
        try{
            ExecutableMySinglyLinkedCircularList program = new ExecutableMySinglyLinkedCircularList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * The run method simply displays the current state of the linked list after applying the different methods to it.
     * The insert methods are first displayed, followed by deletion methods, then the search method.
     */
    public void run(){
        MySinglyLinkedCircularList<BasketballTeam> NBA = new MySinglyLinkedCircularList();

        BasketballTeam b1 = new BasketballTeam("Warriors","Steve Kerr",15);
        BasketballTeam b2 = new BasketballTeam("Cavaliers","Lady Gaga",15);
        BasketballTeam b3 = new BasketballTeam("Timberwolves","Elton John",15);
        BasketballTeam b4 = new BasketballTeam("Heat","John Rey De Torres",15);
        BasketballTeam b5 = new BasketballTeam("Lakers", "Frank Vogel", 15);
        BasketballTeam b6 = new BasketballTeam("Bulls", "Billy Donovan", 15);
        BasketballTeam b7 = new BasketballTeam("Knicks", "Tom Thibodeau", 15);
        BasketballTeam b8 = new BasketballTeam("Rockets", "Stephen Silas", 15);
        BasketballTeam b9 = new BasketballTeam("Suns", "Monty Williams", 15);
        BasketballTeam b10 = new BasketballTeam("Clippers", "Tyronn Lue", 15);

        NBA.insertAtHead(b1);
        NBA.insertAtTail(b2);
        NBA.insertAtIndex(2,b3);
        NBA.insertAtTail(b4);
        NBA.insertAtIndex(4,b5);
        NBA.insertAtTail(b6);
        NBA.insertAtIndex(6,b7);
        NBA.insertAtTail(b8);
        NBA.insertAtTail(b9);
        NBA.insertAtIndex(10,b10);

        System.out.println("ADDING b1 at head, b2 at tail, b3 at index 2, b4 at tail, b5 at index 4, b6 at tail, b7 at index 6, b8 at tail, b9 at tail, and b10 at index 10");
        System.out.println("CURRENT HEAD: " + NBA.getHead());
        System.out.println("CURRENT TAIL: " + NBA.getTail());
        System.out.println("CURRENT TAIL.NEXT: " + NBA.getTail().getNext());
        System.out.println("CURRENT SIZE: " + NBA.getSize());
        System.out.println(NBA.toString());


        NBA.deleteAtHead();
        NBA.deleteAtTail();
        NBA.deleteAtIndex(3);
        NBA.deleteAtIndex(6);
        System.out.println("\n\nDELETING current head, current tail, node at index 3, and node at index 6");
        System.out.println("CURRENT HEAD: " + NBA.getHead());
        System.out.println("CURRENT TAIL: " + NBA.getTail());
        System.out.println("CURRENT TAIL.NEXT: " + NBA.getTail().getNext());
        System.out.println("CURRENT SIZE: " + NBA.getSize());
        System.out.println(NBA.toString());

        System.out.println("\n\nTO SEARCH: " + b3.toString());
        System.out.println("SEARCH STATUS (index of key): " + NBA.search(b3));
    }
}
