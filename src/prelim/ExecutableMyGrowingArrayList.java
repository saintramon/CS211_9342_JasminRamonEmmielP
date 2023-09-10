/**
 * SAMPLE RUN:
 *
 * The Calculus 7, Leithold
 * Introduction to Algorithms, CLRS
 * Graph Theory, Wilson
 * Discrete Mathematics and its Applications, Rosen
 * Probability and Statistics, Walpole
 * The Algorithm Manual, Skiena
 * Algorithms, Sedgewick
 * CURRENT SIZE OF THE DYNAMIC LIST: 7
 *
 *
 *
 * The Calculus 7, Leithold
 * Introduction to Algorithms, CLRS
 * Discrete Mathematics and its Applications, Rosen
 * Probability and Statistics, Walpole
 * The Algorithm Manual, Skiena
 * CURRENT SIZE OF THE DYNAMIC LIST: 5
 *
 *
 * SEARCH KEY: Probability and Statistics, Walpole
 * Comparing data: Probability and Statistics, Walpole with array[0]: The Calculus 7, Leithold
 * Comparing data: Probability and Statistics, Walpole with array[1]: Introduction to Algorithms, CLRS
 * Comparing data: Probability and Statistics, Walpole with array[2]: Discrete Mathematics and its Applications, Rosen
 * Comparing data: Probability and Statistics, Walpole with array[3]: Probability and Statistics, Walpole
 * SERCH STATUS (index of key): 3
 */
package prelim;

import java.util.ArrayList;
import java.util.Arrays;

public class ExecutableMyGrowingArrayList {
    /**
     * The book class will be utilized as the example for this task.
     * The book class have 2 attributes which are the book title and the book author.
     */
    private class Book{
        private String title;
        private String author;

        public Book(String title, String author){
            this.title = title;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return this.title + ", " + this.author;
        }

        @Override
        public boolean equals(Object obj) {
            Book another = (Book) obj;
            return this.title.equalsIgnoreCase(another.getTitle()) && this.author.equalsIgnoreCase(another.getAuthor());
        }
    }

    public static void main(String[] args){
        try {
            ExecutableMyGrowingArrayList program = new ExecutableMyGrowingArrayList();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * In this method, the application and implementations of some methods in the MyGrowingArrayList class are illustrated.
     * The method displays the insert functions by passing an Object arguement or passing an index and Object parameters for the method.
     * The method also displays the delete functions in which the user can delete an object in the list by using the Object name or its index in the list.
     * For each block of functions, the list is then displayed to have a visual on its current elements.
     */
    public void run(){
        MyGrowingArrayList bookList = new MyGrowingArrayList();

        Book b1 = new Book("The Calculus 7", "Leithold");
        Book b2 = new Book("Introduction to Algorithms", "CLRS");
        Book b3 = new Book("Graph Theory", "Wilson");
        Book b4 = new Book("Discrete Mathematics and its Applications", "Rosen");
        Book b5 = new Book("Probability and Statistics", "Walpole");
        Book b6 = new Book("The Algorithm Manual", "Skiena");
        Book b7 = new Book("Algorithms", "Sedgewick");

        bookList.insert(b1);
        bookList.insert(b2);
        bookList.insert(2,b3);
        bookList.insert(b4);
        bookList.insert(b5);
        bookList.insert(b6);
        bookList.insert(6,b7);

        for (int i = 0; i < bookList.getSize(); i++){
            System.out.println(bookList.getElement(i).toString());
        }
        System.out.println("CURRENT SIZE OF THE DYNAMIC LIST: " + bookList.getSize());
        System.out.println();
        System.out.println();
        System.out.println();


        bookList.delete(b7);
        bookList.delete(2);
        for (int i = 0; i < bookList.getSize(); i++){
            System.out.println(bookList.getElement(i).toString());
        }
        System.out.println("CURRENT SIZE OF THE DYNAMIC LIST: " + bookList.getSize());

        System.out.println("\n\nSEARCH KEY: " + b5.toString());
        System.out.println("SERCH STATUS (index of key): " + bookList.search(b5));
    }
}
