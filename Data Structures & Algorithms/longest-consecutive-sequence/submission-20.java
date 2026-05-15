class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        for (int num: nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int temp = 0;
            int start = num;
            while (set.contains(start)) {
                start++;
                temp++;
            }
            result = Math.max(temp, result);
        }
        return result;
    }
}
