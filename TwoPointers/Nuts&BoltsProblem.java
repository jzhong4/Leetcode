/*
 Author:     Junjie
 Date:       Aug 21, 2017
 Problem:    Nuts & Bolts Problem
 Difficulty: Medium
 Source:     http://lintcode.com/en/problem/nuts-bolts-problem/
 Solution:   首先使用 nuts 中的某一个元素作为基准对 bolts 进行 partition 操作，随后将 bolts 中得到的基准元素作为基准对 nuts 进行 partition 操作。O(nlogn)
*/
/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if(nuts == null || bolts == null){
            return;
        }
        
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    
    private void qsort(String[] nuts, String[] bolts, NBComparator compare, int l, int u){
        if(l >= u) return;
        
         int part_index = partition(nuts, bolts[l], compare, l, u);
        
        partition(bolts, nuts[part_index], compare, l, u);
        
        qsort(nuts, bolts, compare, l, part_index - 1);
        qsort(nuts, bolts, compare, part_index + 1, u);
    }
    
    private int partition(String[] str, String pivot, NBComparator compare, int l, int u){
         for (int i = l; i <= u; i++) {
            if (compare.cmp(str[i], pivot) == 0 || 
                compare.cmp(pivot, str[i]) == 0) {
                swap(str, i, l);
                break;
            }
        }

        String now = str[l];
        int left = l;
        int right = u;
        while(left < right){
            while(left < right && (compare.cmp(str[right], pivot) == -1 || compare.cmp(pivot, str[right]) == 1)){
                right--;
            }
            str[left] = str[right];
            
            while(left < right && (compare.cmp(str[left], pivot) == 1 || compare.cmp(pivot, str[left]) == -1)){
                left++;
            }
            str[right] = str[left];
        }
        
        str[left] = now;
        return left;
    }
    
    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }

};
