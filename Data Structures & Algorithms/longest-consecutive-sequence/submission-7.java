class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestSequence = 0;
        for(int num: nums) {
            set.add(num);
        }
        int i = 0;
        while(i < nums.length) {
            int subLongest = 0;
            int j = nums[i];
            while(set.contains(j)) {
                subLongest++;
                j++;
            }
            if (subLongest > longestSequence) {
                longestSequence = subLongest;
            }
            i++;
        }
        return longestSequence;
    }
}
