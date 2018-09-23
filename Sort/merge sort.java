void mergesort(int[] arrayToSort, int left, int right) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			mergesort(arrayToSort, left, mid);
			mergesort(arrayToSort, mid + 1, right);
			merge(arrayToSort, left, mid, right);
		}
}

void merge(int[] arrayToSort, int left, int mid, int right) {
	int[] helper = new int[arrayToSort.length];
	
	for(int i = left; i <= right; i++) {
		helper[i] = arrayToSort[i]; 
	}
	
	int helperLeft = left;
	int helperRight = mid + 1;
	int current = left;
	while(helperLeft <= mid && helperRight <= right) {
		if(helper[helperLeft] < helper[helperRight]) {
			arrayToSort[current] = helper[helperLeft];
			helperLeft++;
		}else{
			arrayToSort[current] = helper[helperRight];
			helperRight++;
		}
		current++;
	}
	
	for(int i = helperLeft; i <= mid; i++) {
		arrayToSort[current++] = helper[i];
	}
}