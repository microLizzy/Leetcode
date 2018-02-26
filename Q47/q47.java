package Q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q47 {
public static List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result,new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used ) {
        if( tempList.size() == nums.length ){
            result.add(new ArrayList<>(tempList));
        }
        else{
            for( int i=0; i<nums.length; i++ ){
                // Case 1: element has been used
                // Case 2: remove duplicates of child node, say 1 2 2, the last 2 should not be considered in the tree node
                // Case 3: say [1,2,2], index 0->1->2, 0->2->1. In order to avoid this case, the previous index must not be used
                // explanation: https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote/45
                if( used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backTrack(result, tempList, nums, used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }   
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2,2};
        System.out.println(permuteUnique(nums));
    }

}
