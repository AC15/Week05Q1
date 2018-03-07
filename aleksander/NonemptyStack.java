package aleksander;

/**
 * Created by AC15 on 07/03/2018
 */
public class NonemptyStack<A> extends Stack<A> {
    private A value;
    private Stack<A> rest;

    /**
     * Initialise by pushing
     */
    public NonemptyStack(A x, Stack<A> s) {
        value = x;
        rest = s;
    }

    public boolean isEmpty() {
        return false;
    }

    public A top() {
        return value;
    }

    public Stack<A> pop() {
        return rest;
    }

    public int depth() {
        return 1 + pop().depth();
    }
}
