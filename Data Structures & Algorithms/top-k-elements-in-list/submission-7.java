class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapOfCount = new HashMap<>();
        for (int num: nums) {
            int count = mapOfCount.getOrDefault(num, 0);
            count++;
            mapOfCount.put(num, count);
        }
        Map<Integer, List<Integer>> mapOfNums = new HashMap<>();
        for (int num: mapOfCount.keySet()) {
            int key = mapOfCount.get(num);
            List<Integer> list = mapOfNums.getOrDefault(key, new ArrayList<>());
            list.add(num);
            mapOfNums.put(key, list);
        }
        int[] result = new int[k];
        int j = 0;
        for (int i = nums.length; i > 0; i--) {
            if (mapOfNums.containsKey(i)) {
                List<Integer> r = mapOfNums.get(i);
                while (!r.isEmpty() && k > 0) {
                    result[j] = r.remove(r.size() - 1);
                    k--;
                    j++;
                }
            }
            if (k == 0) {
                break;
            }
        }
        return result;
    }
}
