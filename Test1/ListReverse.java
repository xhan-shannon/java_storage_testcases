class Node {
    private Node prev;
    private int data;
    private Node next;
   
    public Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
    
    public void setPrev(Node node){
        prev = node;
    }

    public void setNext(Node node){
        next = node;
    }

    public Node getNext(){
        return next;
    }
    
    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}


class LinkedList{
    
    Node head = null;
    Node pcur = null;

    public LinkedList(Node node){
       pcur = head = node;
    }

    public Node addNode(int data){
        Node node = new Node(data); 
        //node.setData(data);
        if (head == null){
            head = node;
            pcur = head;
        }

        pcur.setNext(node);
        node.setNext(null);
        pcur = node;
        
        return pcur;
    }
    
    public void printLinkedList(){
        Node p = head;
        System.out.println("Show the list:");
        while (null != p){
            System.out.printf("%d->", p.getData());
            p = p.getNext();
        }
        System.out.printf("null");
        System.out.println();
    }

    public void reverse(int k){
        Node p = head;
        Node f_node = null;

        int f_data = 0;
        int s_data = 0;
        int n_count = 0;

        while (null != p){
            n_count++;
            if (1 == n_count){
                f_data = p.getData();
                f_node = p;
            }
            if (3 == n_count){
                s_data = p.getData();
                p.setData(f_data);
                f_node.setData(s_data);
            }
        
            p = p.getNext();
            n_count %= 3;
            
        }
    }


}

public class ListReverse{
    public static void main(String argv[]){
        System.out.println("Init a linkedlist ");
        LinkedList orig_list1 = new LinkedList(new Node(1));
        orig_list1.addNode(2);
        orig_list1.addNode(3);
        orig_list1.addNode(4);
        orig_list1.addNode(5);
        orig_list1.addNode(6);
        orig_list1.addNode(7);
        orig_list1.addNode(8);
        orig_list1.printLinkedList();

        int k = 3;
        String str_out = "";
        str_out.format("Reverse the linkedlist with k=%d", k);
        System.out.println(str_out);
        orig_list1.reverse(k);
        orig_list1.printLinkedList();
        
    }
}
