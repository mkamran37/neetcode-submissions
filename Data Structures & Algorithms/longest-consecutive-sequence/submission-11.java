class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int max = 0;

        for(int num: nums) {
            if(!set.contains(num - 1)) {
                int tmp = 1;
                int start = num;
                while(set.contains(start + 1)) {
                    tmp++;
                    start++;
                }
                if(tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
