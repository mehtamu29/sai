package com.ubs.sai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;


public class SimpleHashTableImpl<K, V> implements SimpleHashTable<K, V> {
	private static final int DEF_SIZE = 100;
	private List<Set<Entry<K, V>>> entries = new ArrayList<Set<Entry<K, V>>>();

	public SimpleHashTableImpl() {
		super();
		init();
	}
	private void init() {
		for(int i=0;i<DEF_SIZE;i++) {
			entries.add(new HashSet<>());	
		}
	}
	@Override
	public V get(K key) {
		int loc = key.hashCode() % DEF_SIZE;		
		Optional<Entry<K, V>> entry =
				entries.get(loc)
				.stream()
				.filter(entr -> entr.key.equals(key))
				.findFirst();

		return entry.isPresent() ? entry.get().getValue():null;
	}

	@Override
	public void put(K key, V value) {
		int loc = key.hashCode() % DEF_SIZE; 
		//TODO what about the multiple key value
		if (entries.get(loc).contains(new Entry<>(key, value))) {
			entries.get(loc).remove(new Entry<>(key, value));
		}
		entries.get(loc).add(new Entry<>(key, value));
	}

	public static class Entry<K, V>{
		private final K key;
		private final V value;
		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		@Override
		public boolean equals(Object other) {
			if (this==other) return true;
			if (!(other instanceof Entry)) return false;

			@SuppressWarnings("unchecked")
			Entry<K, V> otherEntry = (Entry<K, V>)other;
			return (Objects.equals( key,otherEntry.key));
		}
		@Override
		public int hashCode() {	
			return Objects.hash(key);
		}	
	}
}