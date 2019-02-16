/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        //in this position actually pre is dummyHead
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
                // the pre changed here, but dummyhead stayed
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                // dummyhead became the pre of the last stage's root.left
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}
