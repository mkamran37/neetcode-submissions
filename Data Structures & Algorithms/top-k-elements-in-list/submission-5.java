class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for(int num: nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        for(int key: map.keySet()) {
            List<Integer> list = map2.getOrDefault(map.get(key), new ArrayList<>());
            list.add(key);
            map2.put(map.get(key), list);
        }
        int[] result = new int[k];
        int j = 0;
        for(int i = nums.length; i > 0; i--) {
            if(map2.containsKey(i)) {
                for(Integer n: map2.get(i))
                    result[j++] = n;
            }
            if(k == j) {
                return result;
            }
        }
        return result;
    }
}
