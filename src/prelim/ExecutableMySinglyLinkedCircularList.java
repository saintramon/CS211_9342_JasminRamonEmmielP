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

        NBA.insertAtHead(b1);
        NBA.insertAtTail(b2);
        NBA.insertAtTail(b3);
        NBA.insertAtTail(b4);


        System.out.println("CURRENT HEAD: " + NBA.getHead().getData().toString());
        System.out.println("CURRENT TAIL: " + NBA.getTail().getData().toString());
        System.out.println("HEAD PREV: " + NBA.getHead().getPrev().getData().toString());
        System.out.println("TAIL NEXT: " + NBA.getTail().getNext().getData().toString());

        NBA.deleteAtHead();
        System.out.println("\n\nCURRENT HEAD: " + NBA.getHead().getData().toString());
        System.out.println("CURRENT TAIL: " + NBA.getTail().getData().toString());
        System.out.println("HEAD PREV: " + NBA.getHead().getPrev().getData().toString());
        System.out.println("TAIL NEXT: " + NBA.getTail().getNext().getData().toString());
    }
}
