package ltd.pitupi.sample.algo.stack_08;

public class SelfSampleBrowser {
	public static void main(String[] args) {
		
	}
	public void open(){
		
	}
	public void forward(){
		
	}
	public void back(){
		
	}
	public SelfSampleBrowser() {
		super();
		this.currentPage = "";
		this.forwardStack = new LinkedListStack();
		this.backStack = new LinkedListStack();
	}
	private String currentPage;
	private LinkedListStack forwardStack;
	private LinkedListStack backStack;
	public static class LinkedListStack{
//		public static void main(String[] args) {
//			LinkedListStack lls = new LinkedListStack();
//			lls.push("1");printAll();
//			lls.push("2");printAll();
//			lls.push("3");printAll();
//			lls.pop();printAll();
//			lls.pop();printAll();
//			lls.pop();printAll();
//			lls.pop();printAll();
//		}
		public void push(String data){
			this.top = new Node(data,top);
			this.size++;
		}
		public String pop(){
			Node popNode = this.top;
			if(null==popNode){
				System.out.println("stack is null");
				return null;
			}
			this.top = popNode.next;
			return popNode.getData();
		}
		public static void printAll(){
			Node n = top;
			String str = "";
			while(null!=n){
				str = str+"printAll--"+n.getData();
				n = n.next;
			}
			System.out.println(str);
		}
		private int size;
		private static Node top;
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public Node getTop() {
			return top;
		}
		public void setTop(Node top) {
			this.top = top;
		}
		public static class Node{
			private String data;
			private Node next;
			public Node(String data) {
				super();
				this.data = data;
				this.next = null;
			}
			public Node(String data, Node next) {
				super();
				this.data = data;
				this.next = next;
			}
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public Node getNext() {
				return next;
			}
			public void setNext(Node next) {
				this.next = next;
			}
		}
	}
}
