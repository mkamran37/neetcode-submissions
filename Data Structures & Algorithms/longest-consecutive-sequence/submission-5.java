class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) { //O(n)
            set.add(num);
        }
        int longestLength = 0;
        for (int num: nums) {
            int temp = 0;
            while (set.contains(num--)) {
                temp++;
            }
            longestLength = Math.max(longestLength, temp);
        }
        return longestLength;
    }
}
