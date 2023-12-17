package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //if(nums2.length > nums1.length) return kSmallestPairs(nums2, nums1, k);
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        for(int i = 0; i < nums2.length; i++){
            for(int j = 0; j < nums1.length; j++){
                heap.add(new ArrayList<>(List.of(nums1[j], nums2[i], nums1[j] + nums2[i])));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            List<Integer> curr = heap.remove();
            curr.remove(curr.size() - 1);
            result.add(curr);
        }
        return result;

    }
    public static void main(String args){
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }

}
