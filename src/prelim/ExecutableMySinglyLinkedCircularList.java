package prelim;

public class ExecutableMySinglyLinkedCircularList {
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
        NBA.insertAtTail(b3);
        NBA.insertAtTail(b4);
        NBA.insertAtTail(b5);
        NBA.insertAtTail(b6);


        System.out.println("CURRENT HEAD: " + NBA.getHead());
        System.out.println("CURRENT TAIL: " + NBA.getTail());
        System.out.println("TAIL NEXT: " + NBA.getTail().getNext());

        NBA.deleteAtHead();
        System.out.println("\n\nCURRENT HEAD: " + NBA.getHead());
        System.out.println("CURRENT TAIL: " + NBA.getTail());
        System.out.println("TAIL NEXT: " + NBA.getTail().getNext());

        NBA.deleteAtTail();
        System.out.println("\n\nCURRENT HEAD: " + NBA.getHead());
        System.out.println("CURRENT TAIL: " + NBA.getTail());
        System.out.println("TAIL NEXT: " + NBA.getTail().getNext());
    }
}
