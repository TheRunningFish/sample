package ltd.pitupi.sample.algo.array;

import java.util.Arrays;

public class SelfArray {
	private String data[];
	private int size;

	public SelfArray(int capacity) {
		super();
		this.data = new String[capacity];
		this.size = 0;
	}

	public void add(int index,String value) throws Exception {
		checkIndex(index);
		for(int i=index;i<size;i++){
			data[i+1]=data[i];
		}
		data[index]=value;
		size++;
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
		SelfArray sa = new SelfArray(10);
		sa.add(0, "A");System.out.println(sa);
		sa.add(0, "B");System.out.println(sa);
		sa.add(1, "C");System.out.println(sa);
		sa.find(1);System.out.println(sa);
		sa.delete(1);System.out.println(sa);
	}
}
