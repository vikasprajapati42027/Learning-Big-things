package TestJava.Test231;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {
    private final TrieNode root = new TrieNode();

    // Insert a word into the tree
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    // Returns all words in the Trie that start with the given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;
        
        // 1. Navigate to the end of the prefix
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return results; // Prefix not found!
            }
            current = current.children.get(ch);
        }
        
        // 2. We are at the prefix node. Now perform DFS to find all full words below it!
        findAllWords(current, new StringBuilder(prefix), results);
        return results;
    }

    private void findAllWords(TrieNode node, StringBuilder currentWord, List<String> results) {
        if (node.isEndOfWord) {
            results.add(currentWord.toString());
        }
        
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            currentWord.append(entry.getKey());
            findAllWords(entry.getValue(), currentWord, results);
            currentWord.deleteCharAt(currentWord.length() - 1); // Backtrack
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 231: Trie (Prefix Tree) for Autocomplete ===\n");

        System.out.println("A Trie is THE data structure used by Google and IDEs for Autocomplete.");
        System.out.println("Instead of checking every string, we traverse a tree of characters!\n");

        Trie trie = new Trie();
        
        System.out.println("Inserting dictionary words...");
        String[] dictionary = {"app", "apple", "application", "aptitude", "bat", "batch", "car", "cart"};
        for (String word : dictionary) {
            trie.insert(word);
        }
        
        System.out.println("\nType 'ap' -> Autocomplete Results:");
        System.out.println(trie.autocomplete("ap"));
        
        System.out.println("\nType 'bat' -> Autocomplete Results:");
        System.out.println(trie.autocomplete("bat"));
        
        System.out.println("\nType 'xyz' -> Autocomplete Results:");
        System.out.println(trie.autocomplete("xyz"));
        
        System.out.println("\nThis is incredibly fast: O(L) time where L is the length of the prefix!");
    }
}
