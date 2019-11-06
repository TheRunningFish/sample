package ltd.pitupi.sample.algo.linked_06;

import java.util.Scanner;

public class SelfLRUBaseLinkedList<T> {
	public class SNode<T> {
        private T element;
        private SNode next;
        public SNode(T element) {
            this.element = element;
        }
        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
        public SNode() {
            this.next = null;
        }
        public T getElement() {
            return element;
        }
        public void setElement(T element) {
            this.element = element;
        }
        public SNode getNext() {
            return next;
        }
        public void setNext(SNode next) {
            this.next = next;
        }
    }
    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;
    
	public SelfLRUBaseLinkedList() {
		super();
		this.headNode = new SNode<>();
		this.length = 0;
		this.capacity = DEFAULT_CAPACITY;
	}

	public SelfLRUBaseLinkedList(Integer capacity) {
		super();
		this.headNode = new SNode<>();
		this.length = 0;
		this.capacity = capacity;
	}

	public SNode findPreNode(T data){
		SNode sn = headNode;
		while(null!=sn.next){
			if(data.equals(sn.next.getElement())){
				return sn;
			}
			sn=sn.next;
		}
		return null;
	}
	
	public void add(T data){
		SNode preNode = findPreNode(data);
		if(null!=preNode){
			//删除并更新
			deleteElemOptim(preNode);
			intsertElemAtBegin(data);
		}else{
			if(length==capacity){
				//删除
				deleteElemEnd();
			}
			//更新
			intsertElemAtBegin(data);
		}
	}
	
	public void deleteElemOptim(SNode preNode){
		SNode temp = preNode.next;
		preNode.setNext(temp.next);
		temp = null;
		length--;
	}
	
	public void intsertElemAtBegin(T data){
		SNode next = headNode.next;
		headNode.setNext(new SNode<T>(data, next));
	}
	
	public void deleteElemEnd(){
		SNode sn = headNode;
		if(null==sn.next)return;
		while(sn.getNext().getNext()!=null){
			sn = sn.next;
		}
		SNode temp = sn.getNext();
		sn.setNext(null);
		temp= null;
		length--;
	}
	
	public void printAll(){
		SNode temp = headNode.getNext();
		String str = "";
		while(temp!=null){
			str = str + temp.getElement() + ",";
			temp = temp.next;
		}
		System.out.println(str);;
	}

	public static void main(String[] args) {
		SelfLRUBaseLinkedList rc = new SelfLRUBaseLinkedList<>(3);
		Scanner sc = new Scanner(System.in);
        while (true) {
        	rc.add(sc.next());
        	rc.printAll();
        }
	}
}
