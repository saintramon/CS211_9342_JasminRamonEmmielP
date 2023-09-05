package prelim;

public class ListOverflowException extends Throwable {
    public ListOverflowException(){
        super("Desired index out of bounds");
    }
}
