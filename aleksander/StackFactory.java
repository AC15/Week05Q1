package aleksander;

/**
 * Created by AC15 on 07/03/2018
 */
public class StackFactory<A> {
    /**
     * A brand new empty stack
     */
    public Stack<A> empty() {
        return new EmptyStack<>();
    }

    /**
     * The result of a push
     */
    public Stack<A> push(A x, Stack<A> s) {
        return new NonemptyStack<>(x, s);
    }
}