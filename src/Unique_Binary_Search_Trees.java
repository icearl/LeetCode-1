/**��96��
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.
 * Created by zhaoshiqiang on 2017/1/3.
 */
//���䶯̬�滮
public class Unique_Binary_Search_Trees {
    public static int numTrees(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int[] results = new int[n+1];
        results[1]=1;
        results[0]=1;
        /**
         * ���� f(i) ��ʾ��������������� [0,i] �����ڵĲ�ͬBST�ļ��ϣ�
         * ��f(i)���Կ�����0~i-1��ֳ����Σ�ǰ����Ϊi�ĸ��ڵ㣬�����Ϊi����ڵ㣬��ǰ������*���������Ϊ��ηֶε�����
         * ����Щ������ͣ���Ϊf(i)
         * */
        for (int i=2; i<=n; i++){
            for (int j=0; j<i; j++){
                results[i]=results[i]+results[j]*results[i-1-j];
            }
        }
        return results[n];
    }

    public static void main(String[] args){
        System.out.println(numTrees(9));
    }
}
