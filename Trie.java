package com.leetcode;

import java.util.HashMap;
import java.util.Map;

class Trie {
	class TrieNode {
		private Map<Character, TrieNode> childs;
		private boolean endOfWord = false;

		public TrieNode() {
			childs = new HashMap<>();
		}

	}
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curr = root;

		for(Character ch : word.toCharArray()) {
			if(!curr.childs.containsKey(ch)) {
				curr.childs.put(ch, new TrieNode());
			}
			curr = curr.childs.get(ch);
		}

		curr.endOfWord = true;
	}

	public boolean search(String word) {
		TrieNode curr = root;

		for(Character ch : word.toCharArray()) {
			if(!curr.childs.containsKey(ch)) {
				return false;
			}
			curr = curr.childs.get(ch);
		}

		return curr.endOfWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = root;

		for(Character ch : prefix.toCharArray()) {
			if(!curr.childs.containsKey(ch)) {
				return false;
			}
			curr = curr.childs.get(ch);
		}

		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // return True
		System.out.println(trie.search("app"));     // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app"));     // return True
	}
}