package aleksander;

/**
 * Created by AC15 on 07/03/2018
 */
public class EmptyStack<A> extends Stack<A> {
    public EmptyStack() {
    }

    public boolean isEmpty() {
        return true;
    }

    public Stack<A> pop() {
        return null;
    }

    public A top() {
        return null;
    }

    public int depth() {
        return 0;
    }
}
