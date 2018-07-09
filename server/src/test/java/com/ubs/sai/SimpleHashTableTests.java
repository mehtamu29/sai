package com.ubs.sai;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleHashTableTests {
	private SimpleHashTable<String,String> simpleHashTable;

	@Before
	public void init() {	
		simpleHashTable = new SimpleHashTableImpl<>();
	}
	@Test
	public void testSimpleTable() {
		assertNotNull(simpleHashTable);
	}
	@Test
	public void testHashGetNonExistant() {
		assertNull(simpleHashTable.get("SAI"));
	}
	@Test
	public void testHashPutAndGet() {
		simpleHashTable.put("SAI","Baba");
		assertEquals("Should find Baba for Sai","Baba",simpleHashTable.get("SAI"));
	}
	@Test
	public void testHashPutAndGetDupAndGet() {
		simpleHashTable.put("SAI","Baba");
		assertEquals("Should find Baba for Sai","Baba",simpleHashTable.get("SAI"));
		simpleHashTable.put("SAI","Baba1");
		assertEquals("Should find Baba for Sai","Baba1",simpleHashTable.get("SAI"));
	}		
}