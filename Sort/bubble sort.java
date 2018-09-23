void bubblesort(int[] arrayToSort) {
	boolean swapped = true;
	for(int i = 0; i < arrayToSort.length - 1; i++) {
		swapped = false;
		for(int j = 0; j < arrayToSort.length - 1 - i; j++) {
			if(arrayToSort[j] > arrayToSort[j + 1]) {
				int temp = arrayToSort[j];
				arrayToSort[j] = arrayToSort[j + 1];
				arrayToSort[j + 1] = temp;
				swapped = true;
			}
		}
		if(!swapped) break; //如果在某一趟排序中数列已经有序，则结束排序过程
	}
}

时间复杂度：时间复杂度是O(n^2)，假设排序的数有n个，遍历一趟的复杂度是O(n)，需要遍历n-1次，所以时间复杂度为O(n^2)。
空间复杂度：O(1)，因为不需要额外的存储空间。
最坏情况：要排序的数是逆序排好序的。
稳定性：冒泡排序是稳定的算法，因为它实现相邻两个元素之间的交换，没有改变元素的相对位置，所以满足稳定性。