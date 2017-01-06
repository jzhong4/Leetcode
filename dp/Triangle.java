package dp;

public class Triangle {
	// Top - down solution
	 public int minimumTotal(List<List<Integer>> triangle) {
	        int n = triangle.size();
	        List<List<Integer>> minPath = new ArrayList<List<Integer>>(n);
	        for(int i = 0; i < n; i++)  {
	            minPath.add(new ArrayList<Integer>());
	        }
	       // ArrayList是要初始化的，才能access
	       for(int i = 0; i < n; i++){
	            for(int j = 0; j < n ; j++){
	                minPath.get(i).add(Integer.MAX_VALUE);
	            }
	       }
	        
	        minPath.get(0).set(0,  triangle.get(0).get(0));
	        for(int i = 1; i < n; i++){
	            minPath.get(i).set(0, minPath.get(i - 1).get(0) + triangle.get(i).get(0));
	        }
	        
	        for(int i = 1; i < n; i++){
	            minPath.get(i).set(i, minPath.get(i - 1).get(i - 1) + triangle.get(i).get(i));
	        }
	        
	        for(int i = 1; i < n; i++){
	            for(int j = 1; j < i ; j++){
	                minPath.get(i).set(j, Math.min(minPath.get(i - 1).get(j - 1), minPath.get(i -1).get(j)) + triangle.get(i).get(j));
	            }
	        }
	        //如何找到最小值
	        int minSum = minPath.get(n - 1).get(0);
	        for(int i = 1; i < n; i++){
	            minSum = Math.min(minPath.get(n - 1).get(i), minSum);
	    }
	    return minSum;
	    }
	 
   // bottom - up: 不需要计算两边，不需要扫描最后的结果
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		List<List<Integer>> minPath = new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; i++) {
			minPath.add(new ArrayList<Integer>());
		}
		// ArrayList是要初始化的，才能access
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				minPath.get(i).add(Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < n; i++) {
			minPath.get(n - 1).set(i, triangle.get(n - 1).get(i));
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				minPath.get(i).set(j,
						Math.min(minPath.get(i + 1).get(j), minPath.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
			}
		}
		return minPath.get(0).get(0);
	}    
}
// Memorize search
public class Solution {
    int n;
    List<List<Integer>> minPath;
    List<List<Integer>> triangle;
    
    public int search(int i, int j){
        if(i >= this.n){
            return 0;
        }
        
        if(minPath.get(i).get(j) != Integer.MAX_VALUE){
            return minPath.get(i).get(j);
        }
        
        minPath.get(i).set(j, Math.min(search(i + 1, j), search(i + 1, j + 1)) + this.triangle.get(i).get(j));
        
        return minPath.get(i).get(j);
    }
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.n = triangle.size();
        this.minPath = new ArrayList<List<Integer>>(this.n);
        for(int i = 0; i < this.n; i++)  {
            this.minPath.add(new ArrayList<Integer>());
        }
       // ArrayList是要初始化的，才能access
       for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.n ; j++){
                this.minPath.get(i).add(Integer.MAX_VALUE);
            }
       }
       return search(0, 0);
    }
}
