package com.darwin.wasterecycling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class WasteRecyclingApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(compute1("010101".toCharArray()));
    }

    public int compute1(char[] data){
        int[][] dp=new int[data.length+1][501];
        dp[1][1]=1;
        for (int i = 1; i <=data.length; i++) {
            for (int j = 1; j < i; j++) {
                if (data[i-1]!=data[j-1]){
                    for (int k = 1; k <= 500 && dp[j][k] > 0; k++) {
                        dp[i][1]=Math.max(dp[i][1],dp[j][k]+1);
                    }
                }else{
                    for (int k = 2; k <= 500 && dp[j][k-1] > 0; k++) {
                        dp[i][k]=Math.max(dp[i][k],dp[j][k-1]+k);
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));
        }
        return Arrays.stream(dp[data.length]).max().getAsInt();
    }



    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode compute(ListNode[] node){
        ListNode ans=null;
        ListNode[] cur=new ListNode[node.length];
        System.arraycopy(node, 0, cur, 0, node.length);
        boolean f = true;
        while (f){
            f=false;
            for (int i = 0; i < node.length; i++) {
                ListNode c = cur[i];
                if (c!=null){
                    f=true;
                    if (ans==null){
                        ans=new ListNode(c.val);
                    }else{
                        ans.next=new ListNode(c.val);
                    }
                    cur[i]=c.next;
                }
            }
        }
        return ans;
    }

}
