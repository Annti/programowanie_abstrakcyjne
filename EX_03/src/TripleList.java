/**
 * Created by Aneta on 2016-01-18.
 */
public class TripleList<T > {


    private Node<T> head = new Node<T>(null);


 private int size;

    public TripleList() {
        clear();
    }

    public void clear() {

        head.setNext(null);
        head.setPrior(null);
        head.setDown(null);

    }
    public void add(T val)
    {
        //if is first element
        if (head.getValue() == null)
        {
            head.setValue(val);
            System.out.print("cos");
        }
        else {
            Node<T> node = new Node(val, head, size);
            size ++;
            System.out.print("dsfdsdsf");
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}