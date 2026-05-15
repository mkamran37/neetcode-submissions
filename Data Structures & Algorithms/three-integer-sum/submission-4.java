class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];
            while(l < r) {
                if(nums[l] + nums[r] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    tmp.add(nums[i]);
                    result.add(tmp);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if(nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

    private List<Integer> findPair(int[] nums, int startIndex, int target) {
        List<Integer> result = new ArrayList<>();
        int i = startIndex;
        int j = nums.length - 1;
        while(i < j) {
            if(nums[i] + nums[j] == target) {
                result.add(nums[i]);
                result.add(nums[j]);
                return result;
            } else if(nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
