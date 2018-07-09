package com.ubs.sai;

public interface SimpleHashTable<K,V> {
	V get(K key);
	void put(K key, V value);
}