class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i > 0 && idx < k; i--) {
            for (int n : buckets[i]) {
                res[idx++] = n;
                if (idx == k) break;
            }
        }
        return res;
    }
}