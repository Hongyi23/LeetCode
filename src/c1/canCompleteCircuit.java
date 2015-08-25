package c1;

//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas 
//to travel from station i to its next station (i+1). 
//You begin the journey with an empty tank at one of the gas stations.

//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1. 

class Solution_2121 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int left = 0, sum = 0;
    	for(int i = 0, j = 0; i < gas.length; i++){
    		for(j = i; j < gas.length + i; j++){
    			int k = j % gas.length;
    			left = gas[k] - cost[k];
    			if(sum + left < 0) break;
    			else{
    				sum += left;
    			}
    		}
    		if(j == gas.length + i) return i;
    	}
    	return -1;
    }
}

public class canCompleteCircuit {

	public static void main(String[] args) {
		int[] gas = {2, 4};
		int[] cost = {3, 4};
		System.out.println(new Solution_2121().canCompleteCircuit(gas, cost));

	}

}
