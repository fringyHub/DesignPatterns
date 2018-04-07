package com.company;

public class WordCombination {

    public void printCombination(String str) {
        printCombination(str, "");
    }

    private void printCombination(String str, String soFar) {
        if(str.isEmpty()) {
            System.out.println(soFar);
        } else {
            for(char curr : str.toCharArray()) {
                soFar = soFar.concat(String.valueOf(curr));
                str = str.substring(1);

                printCombination(str, soFar);

                soFar = soFar.substring(0, soFar.length() -1);
                str = str.concat(String.valueOf(curr));
            }
        }
    }
    public static void main(String args[]) {
        new WordCombination().printCombination("vped");
    }
}
