package com.ubs.sai;

public class SimpleQueueImpl<T> implements SimpleQueue<T> {
	private static final int CAPACITY = 4;	
	private int front = 0;
	private int rear = 0;
	@SuppressWarnings("unchecked")
	private T[] array = (T[])(new Object[CAPACITY]);
	
	@Override
	public void offer(T value) {
		if (getSize() == CAPACITY)
			throw new IllegalStateException();
		int rearLoc = rear++%CAPACITY;
		array[rearLoc] = value;		
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
		int frontLoc = front++%CAPACITY;
		T frontElem = array[frontLoc];
		return frontElem;		
	}
}