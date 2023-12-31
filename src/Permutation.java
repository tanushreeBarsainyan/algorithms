package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation {
    private static void permute(int[] nums, int startIndex, List<List<Integer>> result){
       if(startIndex == nums.length - 1){
           result.add(Arrays.stream(nums).boxed().toList());
           return;
       }

       for(int i = startIndex; i < nums.length; i++){

           //swap ith and start index element for next permutaion
           int temp = nums[i];
           nums[i] = nums[startIndex];
           nums[startIndex] = temp;


           permute(nums, startIndex + 1, result);

           temp = nums[i];
           nums[i] = nums[startIndex];
           nums[startIndex] = temp;

       }

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }
}