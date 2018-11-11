/*
 * knap_sack.cpp
 *
 *  Created on: 2017年10月21日
 *      Author: penpen926
 */
#include<iostream>
#include<cstdio>
#include<algorithm>
#define MAXN 1000
#define MAXC 100000

int V[MAXN], W[MAXN];
int d[MAXN][MAXC];

/**
 * Use dynia
 */
void knapsack(){
	freopen("data.in","r",stdin);
	freopen("data.out","w",stdout);
	int volume, count;
	std::cout<<"input the count and volume."<<std::endl;
	scanf("%d %d",&count, &volume);
	int i,j;
	int gem_vol[count];
	int gem_value[count];
	for(i =0;i<count;i++){
		scanf("%d %d",&gem_vol[i],&gem_value[i]);
	}

	//Test check the input
	/*
	std::cout<<"volume "<<volume<<std::endl;
	std::cout<<"count  "<<count<<std::endl;
	for(i=0;i<count;i++)
		std::cout<<gem_vol[i]<<"  "<<gem_value[i]<<std::endl;
	*/

	//the two-dimensional array for dp
	int d[count+1][volume+1];


	for(i =0 ;i<=count;i++)
		for(j =0 ;j<=volume;j++){
			d[i][j] = i==0?0: d[i-1][j];

			if(i>0 && j>= gem_vol[i-1])
				d[i][j] =std::max(d[i][j], d[i-1][j-gem_vol[i-1]]+gem_value[i-1]);
		}

	//Output the result
	std::cout<<"Result:  "<<std::endl;
	std::cout<<d[count][volume]<<std::endl;

	fclose(stdin);
	fclose(stdout);
}


/**
 * Use dynamic programming to compute the kth term of fibonacci serie
 */
void fibonacci(){
	int k;
	printf("input k, compute the kth term:\n");
	scanf("%d",&k);
	unsigned long fib[k];
	fib[0] = 1;
	fib[1] = 1;

	/**
	 * Check how large a long variable is, how large a char variable is and
	 * how large an unsigned char variable is.
	 */
	printf("the size of long:%d\n",sizeof(long));
	printf("the size of char:%d\n", sizeof(char));
	printf("the size of unsigned char:%d\n", sizeof(unsigned char));
	for(int i=2;i<k;i++)
		fib[i] = fib[i-1]+fib[i-2];
	printf("%lu\n", fib[k-1]);
}

/*
void knapsack2(){
	freopen("data.in", "r", stdin);
		freopen("data.out", "w", stdout);
		int n, C;
		while(scanf("%d %d", &n, &C) != EOF){
			for(int i=0; i<n; ++i)	scanf("%d %d", &V[i], &W[i]);

			for(int i=0; i<=n; ++i){
				for(int j=0; j<=C; ++j){
					d[i][j] = i==0 ? 0 : d[i-1][j];
					if(i>0 && j>=V[i-1])
						d[i][j] =std::max(d[i][j],d[i-1][j-V[i-1]]+W[i-1]);
				}
			}
			printf("%d\n", d[n][C]);
		}
		fclose(stdin);
		fclose(stdout);
}
*/



int main(){
	//knapsack();
	fibonacci();
}





