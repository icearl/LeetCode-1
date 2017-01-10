import java.util.ArrayList;
import java.util.List;

/**��95��
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 * Created by zhaoshiqiang on 2017/1/3.
 */
//�ݹ飬����Ҫ�����е�������¼������ÿ�ζ�����Ψһ�ģ���������û���ص������⣬���õݹ�
public class Unique_Binary_Search_TreesII {
    public static List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<TreeNode>();
        }else {
            return createTrees(1,n);
        }
    }
    public static List<TreeNode> createTrees(int m, int n){
        List<TreeNode>result = new ArrayList<TreeNode>();
        if (m>n){
            //�������Һ��ӿ���Ϊnull��������Ҫ���һ��null
            result.add(null);
            return result;
        }
        for (int i=m; i<=n; i++){
            //�õ�(m, i - 1)�������ܹ��ɵ�����
            List<TreeNode> ls = createTrees(m, i - 1);
            //�õ�(i + 1, n)�������ܹ��ɵ�����
            List<TreeNode> rs = createTrees(i + 1, n);
            //Ȼ����iΪ����ls�и���Ϊ��������rs�и���Ϊ���������������������������б�
            for (TreeNode l : ls){
                for (TreeNode r : rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        generateTrees(3);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
