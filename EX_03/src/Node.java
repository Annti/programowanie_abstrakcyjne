/**
 * Created by Aneta on 2016-01-18.
 */
public class Node<T extends Comparable<T>> {

    private T value;

    private Node<T> prior;
    private Node<T> next;
    private Node<T> down;

    public Node(T val) {
        value = val;
    }



    public Node(T val, Node<T> first, int size) {
        value = val;

        for (int i = 0; i <= size; i++) {
            if (first.value.compareTo(val)==0) {

            }
        }
    }

    /**
     * Konstruktor, który pozwala wstawić element na określone miejsce
     *
     * @param val obiekt, który chcemy umieścić na liście
     * @param n   obiekt kolejny
     */


    /**
     * @return aktualny obiekt
     */
    public Object getValue() {
        return value;
    }

    /**
     * @return kolejny element
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param n kolejny element
     */
    public void setNext(Node<T> n) {
        next = n;
    }

    public void setValue(T val) {
        value = val;
    }


    public Node getDown() {
        return down;
    }

    public void setDown(Node<T> down) {
        this.down = down;
    }

    public Node<T> getPrior() {
        return prior;
    }

    public void setPrior(Node<T> prior) {
        this.prior = prior;
    }


}
