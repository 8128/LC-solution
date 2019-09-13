// the best way is under 

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet hs = new HashSet();
        for (int a : nums){
            if(hs.add(a)==false){
                return a;
            }
        }
        return 0;
    }
}

//对于数组 A = [2,6,4,1,3,1,5]
//index 0 , 1, 2, 3, 4, 5, 6
//value:2, 6, 4, 1, 3, 1, 5

// 索引是什么？ 索引是指针的相对位置/偏移量
// 那么value 是什么？ 下一个位置的地址
// 那么这个数组就可以转换为 : 0 - > 2 - > 4 -> 3 -> 1 -> 6 -> 5-> [1- >6-> 5 ->1 链表环] 可以看到这就是一个有环的链表
// slow = nums[slow] 的含义就是指针向右移动一步 等价于slow = slow.next
// fast = nums[nums[fast]] 就是移动两步 等价于fast = fast.next.next

class Solution {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}