class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int max = 0;

        for(int num: nums) {
            int tmp = 0;
            int start = num;
            while(set.contains(start)) {
                tmp++;
                start++;
            }
            if(tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}
