# Amazon OA2

### [138\. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)

Difficulty: **Medium**


A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a of the list.

**Example 1:**

**![](https://discuss.leetcode.com/uploads/files/1470150906153-2yxeznm.png)**

```
Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
```

**Note:**

1.  You must return the **copy of the given head** as a reference to the cloned list.


#### Solution

Language: **Java**

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
        Node cur = head;
        while(cur!=null){
            hm.put(cur.val, new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.next!=null) hm.get(cur.val).next=hm.get(cur.next.val);
            if(cur.random!=null) hm.get(cur.val).random=hm.get(cur.random.val);
            cur=cur.next;
        }
        return hm.get(head.val);
    }
}
```

### [21\. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

Difficulty: **Easy**


Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```


#### Solution

Language: **Java**

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
```

### [572\. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)

Difficulty: **Easy**


Given two non-empty binary trees **s** and **t**, check whether tree **t** has exactly the same structure and node values with a subtree of **s**. A subtree of **s** is a tree consists of a node in **s** and all of this node's descendants. The tree **s** could also be considered as a subtree of itself.

**Example 1:**  
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
```

Given tree t:

```
   4 
  / \
 1   2
```

Return **true**, because t has the same structure and node values with a subtree of s.

**Example 2:**  
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

Given tree t:

```
   4
  / \
 1   2
```

Return **false**.

#### Solution

Language: **Java**

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}

```

### [240\. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)

Difficulty: **Medium**


Write an efficient algorithm that searches for a value in an _m_ x _n_ matrix. This matrix has the following properties:

*   Integers in each row are sorted in ascending from left to right.
*   Integers in each column are sorted in ascending from top to bottom.

**Example:**

Consider the following matrix:

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

Given target = `5`, return `true`.

Given target = `20`, return `false`.


#### Solution

Language: **Java**

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}
```

### Amazon | OA 2019 | Critical Connections

https://leetcode.com/discuss/interview-question/372581

https://leetcode.com/problems/critical-connections-in-a-network/

Given an underected connected graph with `n` nodes labeled `1..n`. A [bridge](https://en.wikipedia.org/wiki/Bridge_(graph_theory)) (cut edge) is defined as an edge which, when removed, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). Equivalently, an edge is a bridge if and only if it is not contained in any cycle. The task is to find all bridges in the given graph. Output an empty list if there are no bridges.



Input:



- `n`, an int representing the total number of nodes.
- `edges`, a list of pairs of integers representing the nodes connected by an edge.



**Example 1:**



```
Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
```



![img](https://i.imgur.com/Swl4fjs.png)



```
Output: [[1, 2], [4, 5]]
Explanation:
There are 2 bridges:
1. Between node 1 and 2
2. Between node 4 and 5
If we remove these edges, then the graph will be disconnected.
If we remove any of the remaining edges, the graph will remain connected.
```



**Example 2:**



```
Input: n = 6, edges = [[1, 2], [1, 3], [2, 3], [2, 4], [2, 5], [4, 6], [5, 6]]
```



![img](https://i.imgur.com/eYHEDjl.png)



```
Output: []
Explanation:
We can remove any edge, the graph will remain connected.
```



**Example 3:**



```
Input: n = 9, edges = [[1, 2], [1, 3], [2, 3], [3, 4], [3, 6], [4, 5], [6, 7], [6, 9], [7, 8], [8, 9]]
```



![img](https://i.imgur.com/yevH89d.png)



```
Output: [[3, 4], [3, 6], [4, 5]]
```



The order of nodes is **important!** If the input contains an edge `[3, 1]` you should return it as `[3, 1]`, `[1, 3]` won't be accepted.
C++: input is `vector>`
Java: input is `List`

#### Solution

```java
// "static void main" must be defined in a public class.

public class Main {
    static int time = 0;
    static final int NIL = -1;
    static List<Integer[]> ans1 = new LinkedList<>();
    
    static class Graph{
        private int v;
        private LinkedList<Integer> adj[]; 
        Graph(int V) 
        { 
            v = V; 
            adj = new LinkedList[V+1]; 
            for (int i=0; i<V+1; ++i) 
                adj[i] = new LinkedList(); 
        }
        
        void addEdge(int V, int w) 
        { 
            this.adj[V].add(w);
            this.adj[w].add(V);
        }
    }
    
    static void bridgeDfs(Graph g,int u,boolean visited[], int disc[], int low[], int parent[] )
    {
        visited[u] = true;
        disc[u]=low[u]=++time;
        
        Iterator<Integer> i = (g.adj[u]).iterator();
        while(i.hasNext())
        {
            int v = i.next();
            if(!visited[v])
            {
                parent[v]=u;
                bridgeDfs(g,v,visited,disc,low,parent);
                low[u] = Math.min(low[u],low[v]);
                if(low[v]>disc[u])
                    ans1.add(new Integer[]{u,v});
            }
            else if(v!=parent[u])
            {
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }
    
    static int[][] bridges(int[][] edges,int v)
    {
        Graph g = new Graph(v);
        for(int i=0;i<edges.length;i++)
        {
            g.addEdge(edges[i][0],edges[i][1]);
        }
        boolean visited[] = new boolean[v+1];
        int disc[] = new int[v+1];
        int low[] = new int[v+1];
        int parent[] = new int[v+1];
        
        for(int i=0;i<v;i++)
        {
            parent[i]=NIL;
            visited[i]=false;
        }
        

        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                bridgeDfs(g,i, visited, disc, low, parent);
            }
        }
        
        int[][] res = new int[ans1.size()][2];
        int index=0;
        for(Integer[] temp: ans1)
        {
            res[index][0]=temp[0];
            res[index][1]=temp[1];
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        int n=10;
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5},{4,6},{5,6},{5,7}, {6, 7}, {7, 8}, {8, 9},{8,10}};
        int[][] ans = bridges(edges,n);
        if(ans.length==0)
            System.out.print("[]");
        for(int[] arr : ans)
            System.out.print(Arrays.toString(arr)+",");
    }
}
```

### Amazon | OA 2019 | Favorite Genres

Given a map `Map> userSongs` with user names as keys and a list of all the songs that the user has listened to as values.



Also given a map `Map> songGenres`, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.



The task is to return a map `Map>`, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.



**Example 1:**



```
Input:
userSongs = {  
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
songGenres = {  
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

Output: {  
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}

Explanation:
David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
```



**Example 2:**



```
Input:
userSongs = {  
   "David": ["song1", "song2"],
   "Emma":  ["song3", "song4"]
},
songGenres = {}

Output: {  
   "David": [],
   "Emma":  []
}
```

#### Solution

```java
// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
		Map<String, List<String>> res = new HashMap<>();
		Map<String, String> songstogenre = new HashMap<>();
		
		for(String genre : genreMap.keySet()) {
			List<String> songs = genreMap.get(genre);
			for(String song : songs) {
				songstogenre.put(song, genre);
			}
		}
		
		Map<String, Map<String, Integer>> usergenrecount = new HashMap<>();
		for(String user : userMap.keySet()) {
			if(!usergenrecount.containsKey(user))
				usergenrecount.put(user, new HashMap<>());
			List<String> songs = userMap.get(user);
			for(String song : songs) {
				String genre = songstogenre.get(song);
				int count = usergenrecount.get(user).getOrDefault(genre, 0) + 1;
				usergenrecount.get(user).put(genre, count);
			}
		}
		
		for(String user : usergenrecount.keySet()) {
			if(!res.containsKey(user))
				res.put(user, new ArrayList<>());
			Map<String, Integer> pair = usergenrecount.get(user);
			int max = 0;
			List<String> favgenre = new ArrayList<>();
			for(String genre : pair.keySet()) {
				if(favgenre.size() == 0) {
					favgenre.add(genre);
					max = pair.get(genre);
				} else if(pair.get(genre) > max) {
					favgenre.clear();
					favgenre.add(genre);
					max = pair.get(genre);
				} else if(pair.get(genre) == max)
					favgenre.add(genre);
			}
			res.put(user, favgenre);
		}
		return res;
	}
}


public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
		List<String> list2 = Arrays.asList("song5", "song6", "song7");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();
		List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		genreMap.put("Rock", list3);
		genreMap.put("Dubstep", list4);
		genreMap.put("Techno", list5);
		genreMap.put("Pop", list6);
		genreMap.put("Jazz", list7);
        
        /*Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2");
		List<String> list2 = Arrays.asList("song3", "song4");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();*/
        
        System.out.println(new Solution().favoritegenre(userMap, genreMap));
    }
}
```

### Amazon | OA 2019 | Two Sum - Unique Pairs

Given an int array `nums` and an int `target`, find how many **unique pairs** in the array such that their sum is equal to `target`. Return the number of pairs.



**Example 1:**



```
Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
```



**Example 2:**



```
Input: nums = [1, 1], target = 2
Output: 1
Explanation:
1 + 1 = 2
```



**Example 3:**



```
Input: nums = [1, 5, 1, 5], target = 6
Output: 1
Explanation:
[1, 5] and [5, 1] are considered the same.
```

#### Solution

```java
    public static int findUniquePairs(int[] nums, int target) {
        Map<Integer, Boolean> prev = new HashMap<>();

        int pairs = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            int diff = target - nums[i];
            if (prev.containsKey(diff)) {
                if (!prev.get(diff)) {
                    ++pairs;
                    prev.put(diff, true);
                }
                prev.put(nums[i],true);
            } else {
                prev.put(nums[i],false);
            }
        }
        return pairs;
    }
```

### [59\. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)

Difficulty: **Medium**


Given a positive integer _n_, generate a square matrix filled with elements from 1 to _n_<sup>2</sup> in spiral order.

**Example:**

```
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```


#### Solution

Language: **Java**

```java
public class Solution {
    public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];
        
        // Edge Case
        if (n == 0) {
            return matrix;
        }
        
        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;
            
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;
            
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;
            
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }
        
        return matrix;
    }
}
```