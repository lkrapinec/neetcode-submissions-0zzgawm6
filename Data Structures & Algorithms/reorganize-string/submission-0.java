class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(new int[] {i, count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            char c = (char) (curr[0] + 'a');

            char prev = sb.length() > 0 ? sb.charAt(sb.length() - 1) : '#';

            if (prev != c) {
                sb.append(c);
                curr[1]--;

                if (curr[1] > 0) {
                    maxHeap.offer(curr);
                }
                continue;
            }

            if (maxHeap.isEmpty()) {
                return "";
            }

            int[] next = maxHeap.poll();
            maxHeap.offer(curr);

            char n = (char) (next[0] + 'a');

            sb.append(n);

            next[1]--;
            if (next[1] > 0) {
                maxHeap.offer(next);
            }
        }

        return sb.toString();
    }
}