package com.ubs.sai;

public class SimpleQueueImpl<T> implements SimpleQueue<T> {
	private static final int CAPACITY = 10;	
	private int front = 0;
	private int rear = 0;
	@SuppressWarnings("unchecked")
	private T[] array = (T[])(new Object[CAPACITY]);
	
	@Override
	public void offer(T value) {
		if (getSize() == 10)
			throw new IllegalStateException();
		array[rear++] = value;
		
	}
	@Override
	public int getFront() {
		return front;
	}
	@Override
	public int getRear() {
		return rear;
	}
	@Override
	public int getSize() {
		return Math.abs(rear - front);
	}

	@Override
	public T poll() {
		if (getSize()==0) return null;		
		T frontElem = array[front++];
		return frontElem;		
	}
}