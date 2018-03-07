package aleksander;

public abstract class Stack<A> {
    /**
     * Is this stack empty?
     */
    abstract boolean isEmpty();

    /**
     * The top element
     */
    abstract A top();

    /**
     * The result of removing the top element
     */
    abstract Stack<A> pop();

    /**
     * The number of elements stored
     */
    abstract int depth();
}
