package Tries;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieImpl {

    public Node root;
    private int count;
    TrieImpl()
    {
        root=new Node('*');
        count=0;
    }

    public class Node {
        public char ch;
        public Map<Character, Node> childrens;
        boolean isTerminal;

        Node(char ch) {
            this.ch = ch;
            this.childrens = new HashMap<>();
            isTerminal = false;
        }

        Node(char ch, boolean isTerminal) {
            this.ch = ch;
            this.childrens = new HashMap<>();
               this.isTerminal = isTerminal;
        }
        @Override
        public String toString()
        {
            return ch+"  :   "+this.childrens.toString()+" : "+isTerminal;
        }

    }
    public void addWord(String word)
    {
        if(word.length()==0)
            return;
        addWord(root,word);
    }

    private void addWord(Node root, String word) {
    if(word.length()==0)
    {
        if(!root.isTerminal)
        {   root.isTerminal=true;
            count++;
        }
        return;
    }
    char cc=word.charAt(0);
    Node child=root.childrens.get(cc);
    if(child==null)
    {
        child=new Node(cc);
        root.childrens.put(cc,child);
    }
    addWord(child,word.substring(1));
    }
public boolean search(String word)
{
   return search(root,word);
}

    private boolean search(Node root, String word) {
    if(root==null)
        return false;
    if(word.length()==0&&root.isTerminal)
        return true;
    if(word.length()==0&&!root.isTerminal)
    return false;
    Node child=root.childrens.get(word.charAt(0));
    return search(child,word.substring(1));
    }
   public void remove(String word)
   {
       remove(root,word);
   }

    private void remove(Node root, String word) {

    if(word.length()==0)
    {
    if(root.isTerminal)
    {  root.isTerminal=false;
        count--;
    }
        return;
    }
    Node child=root.childrens.get(word.charAt(0));
        if(child==null)
            return;
    remove(child,word.substring(1));
if(!child.isTerminal&&child.childrens.size()==0)
{
    root.childrens.remove(word.charAt(0));

}

    }
}
