package SegmentTrees;

import java.util.Arrays;

public class SegmentTree {

    int[] result;
    int n;
    SegmentTree(int[] a)
    {
        int size=4*a.length+1;
        result=new int [size+1];
        n=a.length;
       buildTree(a,result,0,a.length-1,1);
        System.out.println(Arrays.toString(result));
    }

    int buildTree(int[]a, int[]result , int s, int e,int i)
    {
        if(s==e)
        {
            result[i]=a[s];
            return result[i];
        }
        int mid=(s+e)/2;
        int left=buildTree(a,result,s,mid,2*i);
        int right=buildTree(a,result,mid+1,e,2*i+1);
        result[i]=left+right;
        return  result[i];
    }
    int query(int s,int e)
    {
        return query(result,0,n-1,s,e,1);
    }

    private int query(int[] result, int ss, int se, int qs, int qe,int i) {
//complete overloap
        if(ss>=qs&&se<=qe)
            return result[i];
        else if (ss>qe||se<qs)//no overloap
            return 0;//default value , Integer.MAX_VALUE for range min query
        else
        {
            //partial overlap;
            int mid=(ss+se)/2;
            int left=query(result,ss,mid,qs,qe,2*i);
            int right=query(result,mid+1,se,qs,qe,2*i+1);
            return left+right;
        }

    }
    public void update(int i,int val)
    {
        update(result,0,n-1,i,val,1);
    }

    private void update(int[] result, int ss, int se, int qi, int val, int index) {

        if(ss==qi&&se==qi)
        {
            result[index]=val;
            return ;//exact
        }
        else if(qi>=ss&&qi<=se) {
            //some type of overlap
            int mid=(ss+se)/2;
            update(result,ss,mid,qi,val,2*index);
            update(result,mid+1,se,qi,val,2*index+1);
            result[index]=result[2*index+1]+result[2*index];
        }
        else
            return ;//no overlap
    }
    public void rangeIncrement(int l,int r,int inc)
    {
        updateRange(result,0,n-1,l,r,inc,1);
    }

    private void updateRange(int[] result, int ss, int se, int qs,int qe, int inc, int index) {
        if (ss > qe || se < qs) {
            //sno overlap;
            return;
        }
        //int
        if (ss ==se) {
            result[index] += inc;
            return;//leaf node
        } else  {
            int mid = (ss + se) / 2;
            updateRange(result, ss, mid, qs,qe, inc, 2 * index);
            updateRange(result, mid + 1, se, qs,qe, inc, 2 * index + 1);
            result[index] = result[2 * index + 1] + result[2 * index];
        }
    }
}
