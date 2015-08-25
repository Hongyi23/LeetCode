package c3;

class Solution_34 {
    public String addBinary(String a, String b) {
        int carry = 0, sum = 0;
        StringBuilder result = new StringBuilder();
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){ //��ס������Ӷ��Ǵ�������ӣ����Լ�������Ҫ�Ӵ�Ŀ�ʼ
        	int ai = (i < 0)? 0 : a.charAt(i) - '0';
        	int bi = (j < 0)? 0 : b.charAt(j) - '0';
        	sum = (ai + bi + carry) % 2;
        	result.insert(0, sum);     //StringBuilder����ֱ��append���� �����ý��������ַ���ת��
        	carry = (ai + bi + carry) / 2;
        }
        if(carry != 0) result.insert(0, 1);
        return result.toString();
    }
}

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(new Solution_34().addBinary("111", "11"));

	}

}
