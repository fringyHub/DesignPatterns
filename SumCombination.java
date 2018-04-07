package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class SumCombination {

    public void sumCombinations(int input[], int sum) {
        Arrays.sort(input);
        sumCombinations(input, sum, 0, new LinkedList<>());
    }

    private void sumCombinations(int input[], int sum, int start, LinkedList<Integer> current) {
        if(sum == 0) {
            current.stream().forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else if(sum > 0) {
            int prev = -1;
            for (int i = start; i < input.length; i++) {
               if (sum < input[i]) return;

               if (prev != input[i]) {
                    current.add(input[i]);
                    sumCombinations(input, sum - input[i], i + 1, current);
                    current.remove(current.size() -1);

                    prev = input[i];
                }

            }
        }
    }
    public static void main(String args[]) {
        int input[] = new int[] {2,5,4,10,7,14,9};

        SumCombination combinations = new SumCombination();
        combinations.sumCombinations(input, 25);
    }
}
