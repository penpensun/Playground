package org.peng.algor.java.dp;
import java.io.*;

public class BackpackProblem {
	String inputFile = "./data/dp_input.txt";
	int N;
	int C;
	int[] v;
	int[] w;
	boolean[] details;
	// The dynamic programming matrix.
	int[][] d;
	
	public void initValues() throws IOException{	
		//Read in the data

		FileReader fr = new FileReader("./data/dp_input.txt");
		BufferedReader br= new BufferedReader(fr);
		
		String line = null;
		// Read the first line to get N
		line = br.readLine();
		String[] splits = line.split(" +");
		N = Integer.parseInt(splits[0]);
		C = Integer.parseInt(splits[1]);
		
		//Init the arrays
		v = new int[N+1];
		w = new int[N+1];
		int i=0;
		// Read in the volumes and values
		while((line = br.readLine())!= null){
			splits = line.split(" +");
			// Parse the values
			v[i] = Integer.parseInt(splits[0]);
			w[i++] = Integer.parseInt(splits[1]);
		}
	}
	
	/**
	 * The main function to solve backpack problem with dp
	 * @throws IOException
	 */
	public void solveBackpackProblem() throws IOException {
		d = new int[N+1][C+1];
		//Pay attention, here is <=
		for(int i=0;i<=N;i++)
			for(int j=0;j<=C;j++){
				if(i==0)
					d[i][j] = 0;
				else
					d[i][j] = d[i-1][j];
				if(i>0 && j>= v[i-1] )
					d[i][j] = Math.max(d[i][j],d[i-1][j-v[i-1]]+w[i-1]);
				
			}
	}
	
	public void printOutDetails(){
		int j=C;
		details = new boolean[N];
		for(int i=0;i<N;i++)
			details[i] = false;
		
		for(int i=N;i>0;i--){
			if(d[i][j] >d[i-1][j])
				details[i-1] = true;
		}
		// Out
		
	}
	
	
	public static void main(String args[]) throws IOException{
		BackpackProblem bpp = new BackpackProblem();
		bpp.initValues();
		
		System.out.println("N:  "+bpp.N);
		System.out.println("C:  "+bpp.C);
		for(int i=0;i<bpp.N;i++)
			System.out.println(bpp.v[i]+"\t"+bpp.w[i]);
		bpp.solveBackpackProblem();
		System.out.println(bpp.d[bpp.N-1][bpp.C-1]);
	}
}
