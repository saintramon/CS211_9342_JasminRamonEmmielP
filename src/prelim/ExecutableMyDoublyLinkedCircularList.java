package prelim;

public class ExecutableMyDoublyLinkedCircularList {
    private class Video{
        private String channel;
        private String title;

        public Video(String channel, String title){
            this.channel = channel;
            this.title = title;
        }

        public String getChannel() {
            return channel;
        }

        public String getTitle() {
            return title;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return this.title + " uploaded by " + this.channel;
        }
    }

    public static void main(String[] args) {
        try {
            ExecutableMyDoublyLinkedCircularList program = new ExecutableMyDoublyLinkedCircularList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        MyDoublyLinkedCircularList playlist = new MyDoublyLinkedCircularList();

        Video v1 = new Video("John Smith", "Cooking Italian Cuisine");
        Video v2 = new Video("Sarah Johnson", "Travel Vlog: Exploring Tokyo");
        Video v3 = new Video("Michael Brown", "Introduction to Machine Learning");
        Video v4 = new Video("Emily Davis", "Guitar Tutorial: Playing Classical Music");
        Video v5 = new Video("David Wilson", "Digital Photography Tips and Tricks");
        Video v6 = new Video("Sophia Lee", "Fitness: Home Workouts for Beginners");
        Video v7 = new Video("Daniel Martin", "Art of Storytelling in Film");
        Video v8 = new Video("Olivia White", "DIY Home Decor Ideas");
        Video v9 = new Video("Ethan Turner", "Science Explained: The Solar System");
        Video v10 = new Video("Ava Lewis", "Traveling on a Budget");

        playlist.insertAtHead(v1);
        playlist.insertAtTail(v2);
        playlist.insertAtTail(v3);
        playlist.insertAtTail(v4);
        playlist.insertAtTail(v5);

        System.out.println("CURRENT HEAD: " + playlist.getHead());
        System.out.println("CURRENT TAIL: " + playlist.getTail());
        System.out.println("HEAD.PREV: " + playlist.getHead().getPrev());
        System.out.println("TAIL.NEXT: " + playlist.getTail().getNext());
        System.out.println("CURRENT SIZE: " + playlist.getSize());
        System.out.println(playlist.toString());
        System.out.println(playlist.search(v3));
    }
}
