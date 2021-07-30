package Recursion.subsetBased;

public class knapSack {
    public static void main(String[] args) {
        int[] prices={40,20,35,100};
        int[]weights={1,2,3,5};
        int capacity=7;
       int ans= maxProfit(prices,weights,capacity,0);
        System.out.println(ans);
    }

    private static int maxProfit(int[] prices, int[] weights, int capacity,int i)
    {
   if(i==weights.length||capacity==0)
   {
       return 0;
   }
   int include=0;
   int exclude=0;
   if(capacity>=weights[i])
   {
       include=prices[i]+maxProfit(prices,weights,capacity-weights[i],i+1);
       exclude=maxProfit(prices,weights,capacity,i+1);
   return Math.max(include,exclude);
   }
   else
       return maxProfit(prices,weights,capacity,i+1);

    }
}
