public class MyLinkedList<E> {
  //NODE CLASS
  public class Node{
    private E data;
    private Node next,prev;

    public Node(E data) {
      this.data = data;
    }

    public Node next() {
      return next;
    }
    public Node prev() {
      return prev;
    }
    public E getData() {
      return data;
    }
    public void setNext(Node next) {
      this.next = next;
    }
    public void setPrev(Node prev) {
      this.prev = prev;
    }
    public E setData(E data) {
      E orig = this.data;
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
  public int size() {
    return size;
  }
  public boolean add(E element) {
    if (size==0) {
      Node val = new Node(element);
      start = val;
      end = val;
    } else {
      Node val = new Node(element);
      val.setPrev(end);
      end.setNext(val);
      end = val;
    }
    size++;
    return true;
  }
  public void add(int index, E element) {
    if (index<0 || index>=size) throw new IndexOutOfBoundsException("invalid index");
    if (index==size) add(element);
    else {
      Node current = getNthNode(index);
      Node val = new Node(element);
      val.setPrev(current.prev());
      val.setNext(current);
      current.prev().setNext(val);
      current.setPrev(val);
      size++;
    }
  }
  public void extend(MyLinkedList<E> other) {
    int otherSize = other.size();
    Node otherStart = other.getNthNode(0);
    otherStart.setPrev(end);
    end.setNext(otherStart);
    end = other.getNthNode(otherSize-1);
    other.clear();
    size+=otherSize;
  }
  public E removeFront() {
    E orig = start.getData();
    start = start.next;
    return orig;
  }
  public E remove(int index) {
    if (index<0 || index>=size) throw new IndexOutOfBoundsException("invalid index");
    E orig = getNthNode(index).getData();
    if (index==0) start=start.next();
    else if (index==size) end=end.prev();
    else {
      Node current = getNthNode(index);
      current.prev().setNext(current.next());
      current.next().setPrev(current.prev());
    }
    size--;
    return orig;
  }
  private Node getNthNode(int n) {
    Node current = start;
    for (int i=0;i<n;i++) {
      current = current.next();
    }
    return current;
  }

  public static void main(String[] args) {
    MyLinkedList<Integer> m = new MyLinkedList<Integer>();
    System.out.println(m.add(2));
    System.out.println(m.add(3));
    System.out.println(m);
    System.out.println(m.removeFront());
    System.out.println(m);
    m.clear();
    System.out.println(m);
    System.out.println(m.add(4));
    System.out.println(m.add(5));
    System.out.println(m.add(6));
    m.add(1,7);
    m.remove(1);
    System.out.println(m);
  }
}
