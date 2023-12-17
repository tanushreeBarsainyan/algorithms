    package src;

    import java.util.*;

    public class IPO {

           // private static int maxProfit = 0;
            public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
                Map<Integer, List<Integer>> map = new HashMap<>();
                for(int i = 0; i < profits.length ; i++){
                    map.computeIfAbsent(capital[i], x-> new ArrayList<>()).add(profits[i]);
                }
                for(List<Integer> list : map.values()){
                    //sort list in ascending order
                    Collections.sort(list);
                }
                System.out.println(map);

                return backtrack(map, k, w);
            }
        private static int backtrack(Map<Integer, List<Integer>> map, int k, int w){
            int maxProfit = 0;
            if(k == 0 || map.isEmpty()) return w;// No more projects to choose or no more budget
            Iterator<Integer> iterator = new ArrayList<>(map.keySet()).iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();

                List<Integer> list = map.get(i);
                if (i <= w && !list.isEmpty()) {
                    int tempProject = list.remove(0);  // Remove the project with the maximum profit
                    int profit = tempProject + backtrack(map, k - 1, w + tempProject);
                    list.add(tempProject);  // Backtrack: add the removed project back to the list
                    maxProfit = Math.max(maxProfit, profit);
                }
                if (list.isEmpty()) {
                    iterator.remove(); // Remove the capital entry if no more projects are available for it
                }
            }

            return maxProfit;
        }
        }

