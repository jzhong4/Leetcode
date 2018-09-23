void quicksort(int[] arrayToSort, int left, int right) {
		if(left < right) {
			int index = partition(arrayToSort, left, right);
			if(left < index - 1 ) {
				quicksort(arrayToSort, left, index - 1);
			}
			if(index < right) {
				quicksort(arrayToSort, index, right);
			}	
		}
}

int partition(int[] arrayToSort, int left, int right) {
	int pivot = arrayToSort[(right + left) / 2];
	while(left <= right) {
		while(arrayToSort[left] < pivot) left++;
		while(arrayToSort[right] > pivot) right--;
		
		if(left <= right) {
			swap(arrayToSort, left, right);
			left++;
			right--;
		}
	}
	return left;
}

void swap(int[] arrayToSort, int left, int right) {
	int temp = arrayToSort[left];
	arrayToSort[left] = arrayToSort[right];
	arrayToSort[right] = temp;
}

时间复杂度：快速排序最坏时间复杂度是O(n^2)，数组已经排好序（这要看选取的基准值，如果总是选取最左边的作为基准值则是O(n^2)）这类情况下快速排序会达到最坏的情况。从这里可以看出选取基准值很重要，如果基准值随机选取，快排很难达到最坏情况。平均时间复杂度是O(n*log(n))，可以这样理解：快排是采用分治的策略，可以把这个过程看成一个二叉树，则遍历一层的时间复杂度是O(n)，树的高度为log2(n+1)，则复杂度为O(n*log2(n))。
空间复杂度：O(logn)~O(n)，这里看的是递归的深度。
稳定性：快排是一种不稳定的算法，因为在选取基准值相互交换的时候，元素的相对位置会变化。