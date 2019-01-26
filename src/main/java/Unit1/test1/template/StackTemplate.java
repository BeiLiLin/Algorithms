package Unit1.test1.template;

public interface StackTemplate<T> {
    public T pop();
    public void push(T item);
    public int size();
    public Boolean isEmpty();
}
