class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> deduper = new HashSet<>();
        for(int n: nums) {
            if (deduper.contains(n)) {
                return true;
            }
            deduper.add(n);
        }
        return false;
    }
}
