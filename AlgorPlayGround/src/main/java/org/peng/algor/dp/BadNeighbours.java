package org.peng.algor.dp;
import java.io.*;
/**
 * This class is written to solve the problem of topcoder Bad Neighbor Problem:
 * https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 * 
 * Suggested solution in the forum:
 * https://discuss.codechef.com/questions/88786/topcoder-bad-neighbour-dp-based-problem
 * 
 * @author penpen926
 *
 */
public class BadNeighbours {
	int[] donations;
	int[] d1 ;
	int[] d2 ;
	String input = "./data/BadNeighbours_input.txt";
	public void init() throws IOException{
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		// Read the donation array
		String line = br.readLine();
		String [] splits= line.split(" +");
		donations = new int[splits.length];
		for(int i=0;i<splits.length;i++)
			donations[i] = Integer.parseInt(splits[i]);
		d1 = new int[donations.length+1];
		d2 = new int[donations.length+1];
	}
	public void maxDonations() {
		d1[0] = 0;
		d2[0] = 0;
		d1[1] = 0;
		d2[1] = donations[0];
		
		for(int i=2;i<d1.length;i++) {
			if(d1[i-1] != d1[i-2])
				d1[i] = Math.max(d1[i-2]+donations[i-1], d1[i-1]);
			
			else d1[i] = d1[i-1]+donations[i-1];
			
			if(i == d1.length-1)
				d2[i] = d2[i-1];
			
			else if(d2[i-1] != d2[i-2])
				d2[i] = Math.max(d2[i-2]+donations[i-1], d2[i-1]);
			
			else d2[i] = d2[i-1]+donations[i-1];
		}
		System.out.println(d1[d1.length-1]);
		System.out.println(d2[d2.length-1]);
	}
	
	
	public static void main(String args[]) throws IOException{
		BadNeighbours bn = new BadNeighbours();
		bn.init();
		bn.maxDonations();
	}
}
