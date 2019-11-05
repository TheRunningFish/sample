package ltd.pitupi.sample.algo.array;

import java.util.Arrays;

public class SelfGenericArray {
	private String data[];
	private int capacity;
	private int size;

	public SelfGenericArray(int capacity) {
		super();
		this.data = new String[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	public SelfGenericArray() {
		super();
		this.data = new String[10];
		this.size = 0;
		this.capacity = 10;
	}

	public void add(int index,String value) throws Exception {
		checkIndex(index);
		if(size==data.length){
			resize();
		}
		for(int i=index;i<size;i++){
			data[i+1]=data[i];
		}
		data[index]=value;
		size++;
	}
	
	private void resize(){
		int newCapacity = size*2;
		String[] resize = new String[newCapacity];
		for(int i=0;i<size;i++){
			resize[i]=data[i];
		}
		data=resize;
		capacity=newCapacity;
	}

	public void delete(int index) throws Exception {
		checkIndex(index);
		for(int i=index;i<size;i++){
			data[i]=data[i+1];
			size--;
		}
	}

	public String find(int index) throws Exception{
		checkIndex(index);
		return data[index];
	}
	
	private void checkIndex(int index) throws Exception{
		if(index<0||index>data.length) throw new Exception();
	}
	
	@Override
	public String toString() {
		return "SelfArray [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}

	public static void main(String[] args) throws Exception {
		SelfGenericArray sa = new SelfGenericArray(10);
		sa.add(0, "A");System.out.println(sa);
		sa.add(0, "B");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.find(1);System.out.println(sa);
		sa.delete(1);System.out.println(sa);
	}
}
