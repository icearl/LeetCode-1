/**第117题
 * Follow up for problem "Populating Next Right Pointers in Each Node".

     What if the given tree could be any binary tree? Would your previous solution still work?
     Note:
     You may only use constant extra space.
     For example,
     Given the following binary tree,
        1
      /  \
     2    3
    / \    \
   4   5    7
     After calling your function, the tree should look like:
        1 -> NULL
      /  \
     2 -> 3 -> NULL
    / \    \
   4-> 5 -> 7 -> NULL
 * Created by zhaoshiqiang on 2017/2/25.
 */
//用固定的空间搜索变形二叉树
public class Populating_Next_Right_Pointers_in_Each_NodeII {
    //这段代码依然适用于I
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while (head != null){
            TreeLinkNode cur = head;
            //将curNode下一层的节点全部连起来，tmpNextHead作为这个链表的头指针
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode pre = dummy;
            while (cur != null){
                if (cur.left != null){
                    pre.next=cur.left;
                    pre=pre.next;
                }
                if (cur.right != null){
                    pre.next=cur.right;
                    pre=pre.next;
                }
                cur=cur.next;
            }
            head=dummy.next;
        }
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeLinkNode p1=new TreeLinkNode(1);
        TreeLinkNode p2=new TreeLinkNode(2);
        TreeLinkNode p3=new TreeLinkNode(3);
        TreeLinkNode p4=new TreeLinkNode(4);
        TreeLinkNode p5=new TreeLinkNode(5);
        TreeLinkNode p6=new TreeLinkNode(6);
        TreeLinkNode p7=new TreeLinkNode(7);
        p1.left=p2;
        p1.right=p3;
        p3.left=p6;
        p3.right=p7;
        new Populating_Next_Right_Pointers_in_Each_NodeII().connect(p1);

    }
}
