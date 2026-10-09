class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //0 - unvisited, 1 - visited, 2 - no cycle
        boolean[] visited = new boolean[n];

        if(foundCycle(0,0, adj,visited)){
            return false;
        }

        for(boolean visit : visited){
            if(!visit){
                return false;
            }
        }
        
        return true;
    }

    private boolean foundCycle(int curr, int prev, List<List<Integer>> adj, boolean[] visited){
        if(visited[curr]){
            return true;
        }

        visited[curr] = true;

        for(int next : adj.get(curr)){
            if(prev == next){
                continue;
            }

            if(foundCycle(next, curr, adj, visited)){
                return true;
            }
        }

        return false;
    }
}

//when graph is a tree
//how to detect a cycle

//0->1,2,3
//1->0,4
//2->0
//3->0
//4->1

//when looking in adj list skip node from where we came from
//have prev node


//0->1
//1->0,2,3,4
//2->1,3
//3->1,2
//4->1

//create adjacecy list
//for each node try to reach the end of the tree, and if end is reached mark it 
//when going deeper in the tree mark each node as visited, if node is reached again but is already visited, then graph is not a valid tree


//all nodes needs to ba part of same tree
//when starting from any node, all nodes needs to be visited