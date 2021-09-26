package solutions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
       /* Arrays.sort(deck);
        if(N<=2)
            return deck;
        int[] sol = new int[N];
        int half;
        boolean isOdd;
        if(N%2==0) {
            half = N / 2;
            isOdd=false;
        }
        else {
            half = N / 2 + 1;
            isOdd=true;
        }
        int i;
        for(i=0; i<half; i++){
            sol[i*2]=deck[i];
        }
        if(isOdd) {
            swap(deck,i,i+1);
        }
        int j=0;
        for(;i<N;i++){
            sol[j*2+1]=deck[i];
            j++;
        }

        return sol;
*/
    }
    void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
