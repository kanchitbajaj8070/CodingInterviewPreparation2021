package Tries;

public class TrieClient {

    public static void main(String[] args) {
        String[] words = { "arts"};
        TrieImpl trie=new TrieImpl();
        for(String s:words)
            trie.addWord(s);
        System.out.println(trie.root.toString());
        System.out.println(trie.search("art"));
        trie.remove("arts");
        System.out.println(trie.search("arts"));
        System.out.println(trie.root.toString());
    }
}
