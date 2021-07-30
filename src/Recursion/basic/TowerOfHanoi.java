package Recursion.basic;

public class TowerOfHanoi {
    public static void main(String[] args) {
        String src="A";
        String dest="C";
        String aux="B";
        int n=3;
        moveDiscs(n,src,dest,aux);
    }

    private static void moveDiscs(int n, String src, String dest, String aux) {
    if(n==0)
        return;
    moveDiscs(n-1,src,aux,dest);
        System.out.println("Move"+n+" th disc form "+ src+" to "+dest);
        moveDiscs(n-1,aux,dest,src);

    }
}
