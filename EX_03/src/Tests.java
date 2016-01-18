/**
 * Created by Aneta on 2016-01-18.
 */
public class Tests {
    public void TestEmptyListCreation()
    {

        TripleList<Integer> tripleList = new TripleList<Integer>();
        //if size of list is 0 next to create
        assert (0 == tripleList.getSize());
        assert (tripleList.getHead().getValue() == null);
        //indexes into objects
        assert (tripleList.getHead() == null);
        assert (tripleList.getHead().getNext() == null);
        assert (tripleList.getHead().getDown() == null);
        // Becouse I can catch assert errors in two ways
        // I will do this in a shorter way
    }
}