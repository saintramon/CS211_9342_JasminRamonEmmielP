/**
 *SAMPLE RUN:
 * SIZE OF THE LIST: 5
 * Jasmin, 2230748
 * Lacanilao, 2230654
 * Roxas, 2230456
 * Tank, 2233210
 * De Torres, 2230123
 *
 *
 * SIZE OF THE LIST: 5
 * Jasmin, 2230748
 * Lacanilao, 2230654
 * Roxas, 2230456
 * Tank, 2233210
 * null
 *
 *
 * KEY TO SEARCH: Roxas, 2230456
 * Comparing data: Roxas, 2230456 with array[0]: Jasmin, 2230748
 * Comparing data: Roxas, 2230456 with array[1]: Lacanilao, 2230654
 * Comparing data: Roxas, 2230456 with array[2]: Roxas, 2230456
 * SEARCH STATUS (index of key): 2
 */
package prelim;

public class ExecutableMyFixedSizeArrayList {
    /**
     * This is the Student class that will be utilized for the demonstration of the MyFixedArrayList class
     */
    private class Student{
        private String lastName;
        private String idNumber;

        public Student(String lastName, String idNumber){
            this.lastName = lastName;
            this.idNumber = idNumber;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getLastName() {
            return lastName;
        }

        public String getIdNumber() {
            return idNumber;
        }

        @Override
        public String toString() {
            return this.lastName + ", " + this.idNumber;
        }

        @Override
        public boolean equals(Object another) {
            return super.equals(another);
        }
    }

    public static void main(String[] args) {
        try {
            ExecutableMyFixedSizeArrayList program = new ExecutableMyFixedSizeArrayList();
            program.run();
        }catch (ListOverflowException listOverflowException){
            listOverflowException.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This run method demonstrates the different usages of the MyFixedArrayList class.
     * It displays the different usages of the MyList interface methods implemented in the MyFixedArrayList class.
     * @throws ListOverflowException
     */
    public void run() throws ListOverflowException{
        MyFixedSizeArrayList studentList = new MyFixedSizeArrayList();

        Student s1 = new Student("Jasmin", "2230748");
        Student s2 = new Student("Lacanilao", "2230654");
        Student s3 = new Student("Roxas", "2230456");
        Student s4 = new Student("Tank", "2233210");
        Student s5 = new Student("De Torres", "2230123");
        Student s6 = new Student("Leung", "2230000");

        studentList.insert(s1);
        studentList.insert(1,s2);
        studentList.insert(s3);
        studentList.insert(3,s4);
        studentList.insert(s5);
        //studentList.insert(s6); will trigger the ListOverflowException

        System.out.println("SIZE OF THE LIST: " + studentList.getSize());
        for (int i = 0; i < studentList.getSize(); i++){
            System.out.println(studentList.getElement(i));
        }

        System.out.println("\n\nSIZE OF THE LIST: " + studentList.getSize());
        studentList.delete(s5);
        for (int i = 0; i < studentList.getSize(); i++){
            System.out.println(studentList.getElement(i));
        }

        System.out.println("\n\nKEY TO SEARCH: " + s3.toString());
        System.out.println("SEARCH STATUS (index of key): " + studentList.search(s3));
    }
}
