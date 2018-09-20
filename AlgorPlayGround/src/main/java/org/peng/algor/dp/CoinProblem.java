package org.peng.algor.dp;
import java.io.*;
/**
 * The algorithm to solve coin problem, as described in this webpage, the first problem
 * http://www.hawstein.com/posts/dp-novice-to-advanced.html
 * 
 * @author penpen926
 *
 */
public class CoinProblem {
	int[] d; // the array recording the least number of coins for a particular value
	int N; // N different types of coin
	int v[]; // The values of the coins
	int t; // The target value;
	String inputPath = "./data/coin_input.txt";
	static int MAX_VALUE  = 100000;
	/**
	 * Read the inputs.
	 * The input format should be:
	 * target_value
	 * coin1_value coin2_value coin3_value
	 *  
	 */
	public void initValues() throws IOException{
		FileReader fr = new FileReader(inputPath);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		//read in the target_value
		line = br.readLine();
		t = Integer.parseInt(line.trim());
		
		// read the values of the coins
		line = br.readLine();
		String[] splits = line.split(" +");
		v= new int[splits.length];
		for(int i=0;i<splits.length;i++)
			v[i] = Integer.parseInt(splits[i]);
		
		br.close();
		fr.close();
		
		//Init d
		d = new int[t+1];
		for(int i=0;i<d.length;i++)
			d[i] = MAX_VALUE;
		
		/*
		System.out.println("v[i]");
		for(int i=0;i<v.length;i++)
			System.out.print(v[i]+" ");
		System.out.println();
		System.out.println("t:  "+t);
		*/
	}
	
	public void solveCoinProblem() {
		for(int j=0;j<=t;j++) {
			if( j ==0)
				d[j] =0;
			else {
				int[] candidates = new int[v.length];
				for(int i=0;i<candidates.length;i++)
					if(j>=v[i]  && d[j-v[i]]+1 <d[j]) 
						d[j] = d[j-v[i]]+1;
				System.out.println("d[j]:  "+d[j]);
			}
			
		}
		System.out.println(d[t]);
		//output d
		/*
		for(int i=0;i<d.length;i++)
			System.out.print(d[i]+"  ");
		System.out.println();
		
		*/
	}
	
	public int minArray(int[] arr) {
		//Output arr
		/*
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"  ");
		System.out.println();
		*/
		int min = arr[0];
		for(int i=1;i<arr.length;i++)
			if(min>arr[i])
				min = arr[i];
		
		return min;
	}
	
	
	public static void main(String args[]) {
		CoinProblem cp = new CoinProblem();
		try{
			cp.initValues();
		}catch(IOException e) {
			e.printStackTrace();
		}
		cp.solveCoinProblem();
	}
}
