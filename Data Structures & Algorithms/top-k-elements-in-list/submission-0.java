class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        List<List<Integer>> numberList = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            numberList.add(new ArrayList<>());
        }
        for(int key: map.keySet()) {
            int count = map.get(key);
            numberList.get(count).add(key);
        }
        int[] result = new int[k];
        int i = nums.length, j = 0;
        System.out.println(map);
        while(k > 0) {
            if (numberList.get(i).size() > 0) {
                for(int num: numberList.get(i)) {
                    result[j] = num;
                    k--;
                    j++;
                }
            }
            i--;
        }
        return result;
    }
}
