class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minVal = 0;
        for (int num: nums) { //O(n)
            set.add(num);
            if (num < minVal) {
                minVal = num;
            }
        }
        int longestLength = 0;
        for (int num: nums) {
            int temp = 0;
            for(int i = num; i >= minVal; i--) {
                if(set.contains(i)) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp > longestLength) {
                longestLength = temp;
            }
        }
        return longestLength;
    }
}
