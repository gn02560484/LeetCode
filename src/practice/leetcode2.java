package practice;

import java.util.LinkedList;

public class leetcode2 {
	LinkedList<Integer> list = new LinkedList<>();
	int position = 0;
	boolean checkifR = false;
	
	public leetcode2() {
		
	}
	
	public void listAll(LinkedList<Integer> nums,int position) {
		
        for(int i=0; i<nums.size();i++) {
        	LinkedList<Integer> temp = new LinkedList<>();
        	for(int num:nums) {
        		temp.add(num);
        	}
        	if(list.size()<(position+1)) {
        		list.add(position,nums.get(i));
        	}else {
        		list.set(position, nums.get(i));
        	}
        	temp.remove(i);
 
        	if(nums.size()==1) {
        		if( list.getLast() != 0 && this.check2Pow(list)) {
        			this.checkifR = true;
        			System.out.println("break!!!");
        			break;
        		}else {
        			continue;
        		}
        	}else {
        		listAll(temp, position + 1);
        	}
        }
    }
       
	public boolean check2Pow(LinkedList<Integer> nums) {
		System.out.println("check");
		
		int num = 0;
		for(int i = 0; i<nums.size();i++) {
			num += nums.get(i) * Math.pow(10.0, i);
		}
		boolean checkItem;
		checkItem = ((num&(num-1))==0);
		return checkItem;		
	}

	
	
	public static void main(String[] args) {
		int N = 262441;
		int num = 0;
		
		if(N!=1) {
				LinkedList<Integer> nums = new LinkedList<>();
			
			do {
				num = N % 10;
				nums.add(num);
				N = N / 10;
			}while(N != 0);
			
			leetcode2 check2power = new leetcode2();

			boolean checkAns;
			check2power.listAll(nums, check2power.position);
			checkAns = check2power.checkifR;
			System.out.println(checkAns);
		}else {
			System.out.println("true");
		}
		
	}
}
