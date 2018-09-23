void selectionsort(int[] arrayToSort) {
	for(int i = 0; i < arrayToSort.length - 1; i++) {
		int minPos = i;
		for(int j = i + 1; j < arrayToSort.length; j++) {
			if(arrayToSort[j] < arrayToSort[minPos]) {
				minPos = j;
			}
		}
		if(minPos != i) {
			int temp = arrayToSort[i];
			arrayToSort[i] = arrayToSort[minPos];
			arrayToSort[minPos] = temp;
		}
	}
}

时间复杂度：O(n^2)，因为每次遍历的复杂度是O(n)的，一共遍历n-1次，所以复杂度是O(n^2)。
空间复杂度：O(1)
最坏情况：排序的数和复杂度没关系
稳定性：选择排序是不稳定的排序，例如有5 8 5 2 9 ，5个元素按从小到大排序，当第一趟排序后形成2 8 5 5 9 ，两个5的相对位置最终排好序后发生了变化