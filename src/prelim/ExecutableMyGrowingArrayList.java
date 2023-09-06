package prelim;

public class ExecutableMyGrowingArrayList {
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
            return super.equals(obj);
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
        bookList.insert(b3);
        bookList.insert(b4);
        bookList.insert(b5);

        System.out.println("CURRENT SIZE: "+bookList.getSize());

        bookList.insert(b6);
        System.out.println("CURRENT SIZE: "+bookList.getSize());

        bookList.insert(b7);
        System.out.println("CURRENT SIZE: "+bookList.getSize());

        bookList.delete(b6);
        System.out.println("CURRENT SIZE: "+bookList.getSize());

        for (int i = 0; i < bookList.getSize(); i++){
            System.out.println(bookList.getElement(i).toString());
        }
    }
}
