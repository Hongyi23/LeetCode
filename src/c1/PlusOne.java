package c1;

class solution_2117{
	public int[] plusOne(int[] digits) {
		int plus = 999;
		int carry = plus;
        for(int i = digits.length - 1; i >= 0; i--){
        	digits[i] += carry;
        	if (digits[i] < 10) break;
        	else if(i != 0){
        		carry = digits[i] / 10;
        		digits[i] = digits[i] % 10;
        	}
        }
        if(digits[0] >= 10){
        	int[] tmp = new int[digits.length + 1];
        	tmp[0] = digits[0] / 10;
        	tmp[1] = digits[0] % 10;
        	for(int i = 1; i < digits.length; i++){
        		tmp[i + 1] = digits[i];
        	}
        	return tmp;
        }else return digits;
    }
}

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9, 9, 9};
		for(int i : new solution_2117().plusOne(digits)){
			System.out.print(i);
		}
	}

}
