public class MyLinkedList<E> {
  //NODE CLASS
  public class Node{
    private Integer data;
    private Node next,prev;

    public Node(int data) {
      this.data = data;
    }

    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public Integer getData() {
      return data;
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public void setPrev(Node prev) {
      this.prev = prev;
    }
    public Integer setData(int data) {
      Integer orig = this.data;
      this.data = data;
      return orig;
    }
    public String toString() {
      return ""+data;
    }
  }
  //
  private int size;
  private Node start,end;

  public String toString() {
    if (size==0) return "[]";
    Node current = start;
    String ans = "[";
    while (current != end) {
      ans+=current.getData()+", ";
      current=current.next();
    }
    return ans+end+"]";
  }
  public MyLinkedList() {
    size=0;
  }
  public void clear() {
    size=0;
  }
  public boolean add(E element) {
    return true;
  }
  public void add(int index, E element) {}
  public void extend(MyLinkedList<E> other) {}
  public E removeFront() {
    return;
  }
}
