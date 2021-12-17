import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String ip[] = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int col = Integer.parseInt(ip[1]);
        int[][] skill_cost = new int[N][col];
        for (int i_skill_cost = 0; i_skill_cost < N; i_skill_cost++) {
            String[] arr_skill_cost = br.readLine().split(" ");
            for (int j_skill_cost = 0; j_skill_cost < arr_skill_cost.length; j_skill_cost++) {
                skill_cost[i_skill_cost][j_skill_cost] = Integer.parseInt(arr_skill_cost[j_skill_cost]);
            }
        }
        String ip1[] = br.readLine().split(" ");
        int Q = Integer.parseInt(ip1[0]);
        int col1 = Integer.parseInt(ip1[1]);
        int[][] groupings = new int[Q][col1];
        for (int i_groupings = 0; i_groupings < Q; i_groupings++) {
            String[] arr_groupings = br.readLine().split(" ");
            for (int j_groupings = 0; j_groupings < arr_groupings.length; j_groupings++) {
                groupings[i_groupings][j_groupings] = Integer.parseInt(arr_groupings[j_groupings]);
            }
        }
        int B = Integer.parseInt(br.readLine().trim());

        int out_ = solve(skill_cost, groupings, B);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    public static final class Node implements Comparable<Node> {
        float skill;
        float salary;
        int i;
        int[]d;

        public Node(float skill, float salary, int i,int[]d) {
            this.skill = skill;
            this.salary = salary;
            this.i = i;
            this.d=d;
        }

        @Override
        public int compareTo(Node o) {
            if (((o.salary / o.skill) > (salary / skill)))
                return -1;
            else if (((o.salary / o.skill) < (salary / skill)))
                return 1;
            else
                return 0;
        }
    }

    static int solve(int[][] skill_cost, int[][] groupings, int B) {

        List<Integer> prices = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();
        HashSet<Integer> grouped = new HashSet<>();
        List<Node> values = new ArrayList<>();
        for (int[] d : groupings) {
            int price = 0;
            int weight = 0;
            for (int i = 0; i < d.length; i++) {
                price += skill_cost[d[i] - 1][0];
                weight += skill_cost[d[i] - 1][1];
                grouped.add(d[i] - 1);
            }
            values.add(new Node(price, weight, 0,d));
        }

        for (int i = 0; i < prices.size(); i++)
        Collections.sort(values);
        HashSet<Integer> included = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < values.size(); i++) {
            int w = (int) values.get(0).salary;
            int p = (int) values.get(0).skill;
            if (B - w >= 0) {
                ans += p;
                if(i<groupings.length)
                {
                    included.add(groupings[i][0]-1);
                    included.add(groupings[i][1]-1);
                }
            }
        }
        return ans;
    }
}