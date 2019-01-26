package interview;

/*
求链表的第一个公共结点
 */
import java.util.HashMap;
import java.util.Map;
class LinkNode<T> {
    private T t;
    public LinkNode next =null;
    public LinkNode(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }
}
class A {
    private int i;
    public A(int i){
        this.i = i;
    }
    public  int getI(){
        return i;
    }
}
public class carbon2 {
    public static LinkNode<A> FindUnionNode(LinkNode<A> head1,LinkNode<A> head2){
       Map<LinkNode,Integer> map = new HashMap<LinkNode,Integer>();
       int i = 1;
       while(head1 !=null){
           map.put(head1,null);
           head1 = head1.next;
       }
        while(head2 !=null){
           if (map.containsKey(head2)){
               return head2;
           }
           head2 = head2.next;
        }
       return null;
    }
    public static  void main(String []args){

        A a1 = new A(1);
        A a2 = new A(2);
        A a3 = new A(3);
        A a4 = new A(4);
        A a5 = new A(5);
        //初始化Node1
        LinkNode<A> head1 = new LinkNode<>(a1);
        head1.next = new LinkNode<A>(a2);
        head1.next.next = new LinkNode<A>(a3);
        head1.next.next.next = new LinkNode<A>(new A(6));
        //初始化Node2
        LinkNode<A> head2 = new LinkNode<>(a5);
        head2.next = new LinkNode<A>(a4);
        head2.next.next = head1.next.next ;
        head2.next.next.next = new LinkNode<A>(new A(6));
        LinkNode<A> node = FindUnionNode(head1,head2);
        System.out.println(node.getT().getI());
    }
}
