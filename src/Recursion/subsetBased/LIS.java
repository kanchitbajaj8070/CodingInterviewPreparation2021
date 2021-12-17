package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
    int[]a={2,5,3,7,11,8,10,13,6};
    lis(a,0,new ArrayList<>());
        System.out.println(list);
    }
    private static List<Integer> list=new ArrayList<>();
    private static void lis(int[]a , int i , List<Integer> ans)
    {
        if(i==a.length)
        {
            if(list==null||list.isEmpty())
                list=new ArrayList<>(ans);
            else
            {
                if(list.size()<ans.size())
                    list=new ArrayList<>(ans);
            }
            return;
        }
        if(ans.isEmpty())
        {
            ans.add(a[i]);
            lis(a,i+1,ans);
            ans.remove(ans.size()-1);
        }
        else
        {
            int last=ans.get(ans.size()-1);
            if(a[i]>last)
            {
                ans.add(a[i]);
                lis(a,i+1,ans);
                ans.remove(ans.size()-1);
                lis(a,i+1,ans);
            }
            else
                lis(a,i+1,ans);
        }
    }

}
