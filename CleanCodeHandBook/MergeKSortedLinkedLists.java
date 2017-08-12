Assume k lists, each list of size n
Solution1: Brute force - O(nk^2) runtime, O(1) space
Merge a list one by one. First merge operation will be two lists of size n, therefore in the worst case there could be n + n operations. The second merge operation will be two lists of size 2n and n. 所以每次merge increase the size of the merged lists by n. The total number of comparisons required is 2n + 3n + … + kn = O(nk^2)

Solution2: PriorityQueue, 最小Heap - O(nklogk) runtime, O(k) space
补充: priorityqueue是用Heap来实现的，什么是heap？ - complete binary tree. 每个节点是key，小于child的key值，就是heap-order property。min() costs O(1), remove(), insert() costs O(logn)
Maintain a min heap of size k(space), 1) initialized with the smallest element from each list, 2) extract nodes out of the heap, insert 3) insert its next node to the heap. Each insert operation costs log(k) and total elements is nk elements, so the total runtime complexity is O(nklogk)

Solution3: Divide and Conquer - O(nklogk), O(1) space
             k            nk
          k/2  k/2        nk
         . . . . . .      nk
        1 1 1 1 1 1 1     O(nk)



Solution2:
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });
        
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null){
                queue.add(lists.get(i));
            }
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            head.next = temp;
            head = temp;
            if(head.next != null){
                queue.add(head.next);
            }
        }
        return dummyNode.next;
    }
}

Solution3:
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        return mergeKListsHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeKListsHelper(List<ListNode> lists, int start, int end){
        if(start == end){
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return mergeLists(left, right);
    }
    
    private ListNode mergeLists(ListNode node1, ListNode node2){
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                head.next = node1;
                node1 = node1.next;
            }else{
                head.next = node2;
                node2 = node2.next;
            }
                head = head.next;
        }
        
        if(node1 != null){
            head.next = node1;
        }
        
        if(node2 != null){
            head.next = node2;
        }
        return dummyNode.next;
    }
}