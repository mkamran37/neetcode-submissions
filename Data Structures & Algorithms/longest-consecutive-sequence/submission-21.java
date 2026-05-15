class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int num: nums) {
            set.add(num);
        }
        for (int num: nums) {
            int tmp = num;
            int length = 0;
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(tmp)) {
                tmp++;
                length++;
            }
            result = Math.max(result, length);
        }
        return result;
    }
}
