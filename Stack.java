package aleksander;

public interface Stack<T> {
    
    boolean isEmpty();
    
    void pop() throws StackUnderflowException;
    
    void push(T item);
    
    T top() throws StackUnderflowException;

    int size();

    boolean validate();
    
    @Override
    String toString();
}
