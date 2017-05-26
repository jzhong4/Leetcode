package dp;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] nums = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			nums[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			nums[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					nums[i][j] = 0;
				} else {
					nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
				}
			}
		}
		return nums[m - 1][n - 1];
	}
}
