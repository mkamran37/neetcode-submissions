class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for(int key: map.keySet()) {
            int count = map.get(key);
            List<Integer> list = map2.getOrDefault(count, new ArrayList<>());
            list.add(key);
            map2.put(count, list);
        }
        int[] result = new int[k];
        for(int i = nums.length, j = 0; i >= 0; i--) {
            if (map2.containsKey(i)) {
                List<Integer> list = map2.get(i);
                for(Integer n: list) {
                    result[j++] = n;
                    if (j == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
