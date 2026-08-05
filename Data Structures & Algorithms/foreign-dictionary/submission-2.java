class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];

            int length = Math.min(prevWord.length(), currWord.length());
            int diff = -1;
            for (int j = 0; j < length; j++) {
                if (prevWord.charAt(j) != currWord.charAt(j)) {
                    diff = j;
                    break;
                }
            }

            if (diff == -1) {
                if(prevWord.length() > currWord.length()){
                    return "";
                }
                continue;
            }

            graph.get(prevWord.charAt(diff)).add(currWord.charAt(diff));
        }

        Map<Character, Integer> visited = new HashMap<>();

        List<Character> result = new ArrayList<>();
        for (char key : graph.keySet()) {
            if (dfs(key, graph, visited, result)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }

        return sb.toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> graph, Map<Character, Integer> visited,
        List<Character> result) {

        int status = visited.getOrDefault(c, 0);
        if (status == 1) {
            return true;
        }

        if(status == 2){
            return false;
        }

        visited.put(c, 1);

        Set<Character> edges = graph.get(c);

            for (char edge : edges) {
                if (dfs(edge, graph, visited, result)) {
                    return true;
                }
            }

        visited.put(c, 2);

        result.add(c);
        return false;
    }
}
