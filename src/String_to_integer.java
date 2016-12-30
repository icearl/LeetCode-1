import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**��8�⣺Implement atoi to convert a string to an integer.
 * Created by zhaoshiqiang on 2016/12/30.
 */
public class String_to_integer {

    public static int myAtoi(String str) {
        if (str == null || "".equals(str)){
            return 0;
        }
        str = str.trim();
        int length = str.length();
        long result =0;
        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;
        boolean flag=false;
        int i=0;
        if (str.charAt(0) == '-'){
            i=1;
            flag=true;
        }
        if (str.charAt(0) == '+'){
            i=1;
        }
        for ( ; i<length; i++){
            char a = str.charAt(i);
            //ע��������=
            if (a >= '0' && a <= '9'){
                result = result*10+a-'0';
                //�������������Χ��ֱ����������ֵ
                if (flag){
                    if (result >= -min){
                        return (int)min;
                    }
                }else {
                    if (result >= max){
                        return (int)max;
                    }
                }

            }else {
                break;
            }

        }
        if (flag){
            return -(int)result;
        }else {
            return (int)result;
        }

    }

    public static void main(String[] args){
//        long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
            System.out.println(myAtoi("2147483648"));
            System.out.println(myAtoi("-2147483648"));
            System.out.println(myAtoi("+-1"));
            System.out.println(myAtoi("-1"));
            System.out.println(myAtoi("+1"));
            System.out.println(myAtoi("1"));
            System.out.println(myAtoi("    0101"));
//        long endTime = System.currentTimeMillis();
//        System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
    }
}
