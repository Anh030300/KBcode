package main;

public class Individual {
	public int[] binaryVal;
	public int value;
	public double obj;
	
	public Individual(int val) {     //constructor
		if(val >= 0 && val < (int)Math.pow(2, Config.indiSize)) {
			this.value = val;
			binaryVal = new int[Config.indiSize];
			char[] temp = Integer.toBinaryString(val).toCharArray();
			int c = binaryVal.length - 1;
			for(int i = temp.length - 1; i >= 0; i--) {
				if(temp[i] == '0') binaryVal[c] = 0;
				else binaryVal[c] = 1;
				c--;
			}
		}
		obj = Objective.getObjective(this);
	}
	
	public Individual(int[] bin) { 
		binaryVal = bin;
		value = getValue(binaryVal);
		obj = Objective.getObjective(this);
	}
	
	public int getValue(int[] bin) {
		int kq = 0;
		for(int i = 0 ; i<bin.length;i++) {
			kq+= bin[i] * (int)Math.pow(2, (bin.length - 1  - i));
		}
		return kq;
	}
	
	public static void main(String[] arg) {
		Individual a = new Individual(new int[] {0,0,0,0,1,0,0,0});
		//for(int i = 0; i<8;i++) {
			System.out.print(a.value);
		//}
	}
}
