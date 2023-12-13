    package src;

    import java.util.*;

    public class IPO {

            private static int maxProfit = 0;
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
                if(k == 0) return w;
                while(k > 0){
                    for(int i : map.keySet()){
                        int profit = 0;

                        if(i >= w && map.get(i).size() > 0 ){
                            //then we can start a project with i capital and take the profit
                            List<Integer> list = map.get(i);
                            int tempProject = list.get(list.size() - 1);
                            w += tempProject;
                            list.remove(list.size() - 1);
                            profit = backtrack(map, k - 1, w);
                            w -= tempProject;
                            list.add(tempProject);
                        }
                        maxProfit = Math.max(maxProfit, profit);
                    }
                }
                return maxProfit;
            }
        }

