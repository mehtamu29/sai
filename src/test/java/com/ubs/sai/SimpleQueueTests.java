package com.ubs.sai;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleQueueTests {
	SimpleQueue<String> queue;

	@Before
	public void init() {
		queue = new SimpleQueueImpl<>();
	}
	@Test
	public void testQueueCreation() {
		assertNotNull(queue);
	}
	@Test
	public void testQueueFirstOffer() {
		queue.offer("First");
		assertEquals(0,queue.getFront());
		assertEquals(1,queue.getRear());
		assertEquals(1,queue.getSize());
	}
	@Test
	public void testQueueMultipleOffer() {
		queue.offer("First");
		queue.offer("First");
		queue.offer("First");
		assertEquals(0,queue.getFront());
		assertEquals(3,queue.getRear());
		assertEquals(3,queue.getSize());		
	}	
	@Test
	public void testQueueEmptyPoll() {
		assertNull(queue.poll());
	}
	@Test
	public void testQueueSingleElemPoll() {
		queue.offer("First");
		assertEquals("First", queue.poll());
		assertEquals(0,queue.getSize());
	}
	@Test
	public void testQueueTwoElemPoll() {
		queue.offer("First");
		queue.offer("First1");
		queue.offer("First2");
		queue.offer("First3");
		
		assertEquals("First", queue.poll());
		assertEquals(1,queue.getFront());
		assertEquals(4,queue.getRear());
		assertEquals(3,queue.getSize());
		
		assertEquals("First1", queue.poll());
		assertEquals(2,queue.getFront());
		assertEquals(4,queue.getRear());
		assertEquals(2,queue.getSize());

		assertEquals("First2", queue.poll());
		assertEquals(3,queue.getFront());
		assertEquals(4,queue.getRear());
		assertEquals(1,queue.getSize());

		assertEquals("First3", queue.poll());
		assertEquals(0,queue.getSize());

	}
	@Test(expected=IllegalStateException.class)
	public void testQueueTestAddOnFull() {
		queue.offer("First");
		queue.offer("First");
		queue.offer("First");
		queue.offer("First");
		queue.offer("First");
	}
	
	@Test
	public void testQueueTestRotate() {
		queue.offer("First");
		queue.poll();
		queue.offer("First");
		queue.poll();
		queue.offer("First");
		queue.poll();
		queue.offer("First");
		queue.poll();
		queue.offer("First");
		assertEquals("First", queue.poll());
		System.out.println("Shirdi Sai Baba");
	}
}