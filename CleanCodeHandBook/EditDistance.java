完美分析：
编辑距离的话，当我们要计算d(i,j)时，即计算A(i)到B(j)之间的编辑距离，此时，设A(i)形式是somestr1c；B(i)形如somestr2d的话，
将somestr1变成somestr2的编辑距离已知是d(i-1,j-1)
将somestr1c变成somestr2的编辑距离已知是d(i,j-1)
将somestr1变成somestr2d的编辑距离已知是d(i-1,j)
那么利用这三个变量，就可以递推出d(i,j)了：
如果c==d，显然编辑距离和d(i-1,j-1)是一样的
如果c!=d，情况稍微复杂一点，
如果将c替换成d，编辑距离是somestr1变成somestr2的编辑距离 + 1，也就是d(i-1,j-1) + 1
如果在c后面添加一个字d，编辑距离就应该是somestr1c变成somestr2的编辑距离 + 1，也就是d(i,j-1) + 1
如果将c删除了，那就是要将somestr1编辑成somestr2d，距离就是d(i-1,j) + 1
***对第一个字符串做替换，加，删操作以避免重复！！！
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();    
        int[][] minSteps = new int[m + 1][n + 1]; // 避免minSteps[m - 1][n - 1]的情况（minSteps[-1][-1]）
        
	    for(int i = 0; i <= m; i++){
	        minSteps[i][0] = i;	
	    }

            for(int i = 0; i <= n; i++){
	        minSteps[0][i] = i;	
	    }

	    for(int i = 1; i <= m; i++){
	      for(int j = 1; j <= n; j++){
            if(word1.charAt(i - 1) == word2.charAt(j - 1)){//前i个字符与第i个位置不同
	            minSteps[i][j] = minSteps[i - 1][j - 1];		
	        }else{
               minSteps[i][j] = Math.min(minSteps[i - 1][j - 1],Math.min(minSteps[i][j - 1], minSteps[i - 1][j]))+1;
            }
          }
	    }
       return minSteps[m][n];
    }
}