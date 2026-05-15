class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toFind = target - nums[i];
            if (indices.containsKey(toFind)) {
                return new int[]{indices.get(toFind), i};
            }
            indices.put(nums[i], i);
        }
        return new int[]{};
    }
}
