package PoorPigs;

import java.lang.Math;
class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states= minutesToTest/minutesToDie+1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(states));
    }

    public static void main(String args[]){
        int result = new PoorPigs().poorPigs(8, 15,45);
        System.out.println(result);
    }
}