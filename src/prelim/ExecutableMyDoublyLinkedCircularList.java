/**
 * SAMPLE RUN:
 *
 * ADDITION OF: v1, v2, v3, v4, and v5
 * CURRENT HEAD: Cooking Italian Cuisine uploaded by John Smith
 * CURRENT TAIL: Fitness: Home Workouts for Beginners uploaded by Sophia Lee
 * HEAD.PREV: Fitness: Home Workouts for Beginners uploaded by Sophia Lee
 * TAIL.NEXT: Cooking Italian Cuisine uploaded by John Smith
 * CURRENT SIZE: 6
 * ...<->HEAD: Cooking Italian Cuisine uploaded by John Smith <-> Travel Vlog: Exploring Tokyo uploaded by Sarah Johnson <-> Introduction to Machine Learning uploaded by Michael Brown <-> Guitar Tutorial: Playing Classical Music uploaded by Emily Davis <-> Digital Photography Tips and Tricks uploaded by David Wilson <-> TAIL: Fitness: Home Workouts for Beginners uploaded by Sophia Lee<->...
 *
 *
 * DELETION OF: current head, current tail, and the node at index 3
 * CURRENT HEAD: Travel Vlog: Exploring Tokyo uploaded by Sarah Johnson
 * CURRENT TAIL: Digital Photography Tips and Tricks uploaded by David Wilson
 * HEAD.PREV: Digital Photography Tips and Tricks uploaded by David Wilson
 * TAIL.NEXT: Travel Vlog: Exploring Tokyo uploaded by Sarah Johnson
 * CURRENT SIZE: 3
 * ...<->HEAD: Travel Vlog: Exploring Tokyo uploaded by Sarah Johnson <-> Introduction to Machine Learning uploaded by Michael Brown <-> TAIL: Digital Photography Tips and Tricks uploaded by David Wilson<->...
 *
 *
 * TO SEARCH: Introduction to Machine Learning uploaded by Michael Brown
 * KEY INDEX IN THE LIST: 1
 *
 * TO SEACH: Cooking Italian Cuisine uploaded by John Smith
 * KEY INDEX IN THE LIST: -1
 */
package prelim;

public class ExecutableMyDoublyLinkedCircularList {
    /**
     * The Video class will be used to emulate the Doubly Circular Linked List. It has a channel and video title attribute.
     *
     * Consider the scenario of watching a playlist of Youtube videos. You can play the next video, go back to the previous video, and vice versa.
     * You can also watch the same video again and again. Thus, this class best fits the doubly circular linked list in real life.
     */
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

    /**
     * The run method shows how different methods of the doubly circular linked list can be utlizied.
     * It initially shows how to use the insertion methods by the head, the tail, or wherever you want.
     * It then shows the deletion methods in which you can delete from the head, tail, or from the chosen index.
     * Lastly, it shows the search method that returns the index of the key if found.
     */
    public void run(){
        MyDoublyLinkedCircularList<Video> playlist = new MyDoublyLinkedCircularList();

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
        playlist.insertAtIndex(1,v2);
        playlist.insertAtTail(v3);
        playlist.insertAtIndex(3,v4);
        playlist.insertAtTail(v5);
        playlist.insertAtTail(v6);

        System.out.println("ADDITION OF: v1, v2, v3, v4, and v5");
        System.out.println("CURRENT HEAD: " + playlist.getHead());
        System.out.println("CURRENT TAIL: " + playlist.getTail());
        System.out.println("HEAD.PREV: " + playlist.getHead().getPrev());
        System.out.println("TAIL.NEXT: " + playlist.getTail().getNext());
        System.out.println("CURRENT SIZE: " + playlist.getSize());
        System.out.println(playlist.toString());

        playlist.deleteAtIndex(3);
        playlist.deleteAtHead();
        playlist.deleteAtTail();

        System.out.println("\n\nDELETION OF: current head, current tail, and the node at index 3");
        System.out.println("CURRENT HEAD: " + playlist.getHead());
        System.out.println("CURRENT TAIL: " + playlist.getTail());
        System.out.println("HEAD.PREV: " + playlist.getHead().getPrev());
        System.out.println("TAIL.NEXT: " + playlist.getTail().getNext());
        System.out.println("CURRENT SIZE: " + playlist.getSize());
        System.out.println(playlist.toString());

        System.out.println("\n\nTO SEARCH: " + v3.toString());
        System.out.println("KEY INDEX IN THE LIST: " + playlist.search(v3));
        System.out.println("\nTO SEACH: " + v1.toString());
        System.out.println("KEY INDEX IN THE LIST: " + playlist.search(v1));
    }
}
