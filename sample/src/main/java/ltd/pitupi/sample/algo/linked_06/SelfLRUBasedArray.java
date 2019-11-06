package ltd.pitupi.sample.algo.linked_06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SelfLRUBasedArray<T> {
	private static final int DEFAULT_CAPACITY = (1 << 3);
    private int capacity;
    private int count;
    private T[] value;
    private Map<T, Integer> holder;
	
	public SelfLRUBasedArray() {
		this(DEFAULT_CAPACITY);
	}

	public SelfLRUBasedArray(int capacity) {
		this.capacity = capacity;
		this.count=0;
		this.value = (T[]) new Object[capacity];
		this.holder = new HashMap<T,Integer>(capacity);
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean isFull(){
		return count == capacity;
	}
	
	public void offer(T object){
		if(null==object) throw new IllegalArgumentException();
		Integer index = holder.get(object);
		if(index==null){
			if(isFull()){
				//删除且缓存
				removeAndCache(object);
			}else{
				//仅缓存
				cache(object,count);
			}
		}else{
			//更新且缓存
			update(object,index);
		}
	}
	
	public void removeAndCache(T object){
		T key = value[--count];
		holder.remove(key);
		cache(object,count);
	}
	
	public void cache(T object,int end){
		rightShift(end);
		value[0] = object;
		holder.put(object, 0);
		count++;
	}
	
	public void rightShift(int end){
		for(int i=end-1;i>=0;i--){
			value[i+1] = value[i];
			holder.put(value[i], i+1);
		}
	}
	
	public void update(T object,Integer index){
		rightShift(index);
		holder.put(object, 0);
		value[0]=object;
	}
	
	@Override
	public String toString() {
		return "SelfLRUBasedArray [capacity=" + capacity + ", count=" + count + ", value=" + Arrays.toString(value)
				+ ", holder=" + holder + "]";
	}

	public static void main(String[] args) {
		SelfLRUBasedArray<Object> pc = new SelfLRUBasedArray<Object>(3);
		pc.offer("A");System.out.println(pc);
		pc.offer("B");System.out.println(pc);
		pc.offer("C");System.out.println(pc);
		pc.offer("D");System.out.println(pc);
		pc.offer("C");System.out.println(pc);
	}
}
