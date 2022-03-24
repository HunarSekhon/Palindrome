package IHS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;

class Main
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("please enter a string:");
        String userInput=sc.nextLine();
        sc.close();
        findAllPalindromes(userInput);
    }

    public static ArrayList<String> findAllPalindromes(String palindrome)
    {
        String boundedstring = "@" + palindrome + "#";
        char[] charArray = boundedstring.toCharArray();
        int[][] plaindromeLength = new int[2][palindrome.length() + 1];
        int max;
        TreeMap<String,Integer> tmap = new TreeMap<>();

        for (int j = 0; j <= 1; j++) {
            plaindromeLength[j][0] = max = 0;
            int i = 1;
            while (i <= palindrome.length()) {
                while (charArray[i - max - 1] == charArray[i + j + max])
                    max++;
                plaindromeLength[j][i] = max;
                int k = 1;
                while ((plaindromeLength[j][i - k] != max - k) && (k < max)) {
                    plaindromeLength[j][i + k] = Math.min(plaindromeLength[j][i - k], max - k);
                    k++;
                }
                max = Math.max(max - k, 0);
                i += k;
            }
        }

        for (int i = 1; i <= palindrome.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                for (max = plaindromeLength[j][i]; max > 0; max--) {
                    tmap.put(palindrome.substring(i - max - 1, max + j + i - 1),i - max - 1);
                }
            }
        }
        ArrayList<String> finalList = filterPalindromesArray(tmap);
        return finalList;
    }

    public static ArrayList<String> filterPalindromesArray(TreeMap<String,Integer> tmap)
    {
        HashMap<String,Integer> tempMap=new HashMap<>(tmap);
        ArrayList<String> alist =new ArrayList<>(tmap.keySet());
        alist.sort((o1,o2)->o1.length()>=o2.length()?-1:1);
        ArrayList<String> templist=new ArrayList<>();

        for(int i=0;i<alist.size()-1;i++)
        {
            for(int j=i+1;j<alist.size();j++)
            {
                String temp = alist.get(j);
                if(alist.get(i).contains(temp))
                {
                    templist.add(temp);
                }
            }
            alist.removeAll(templist);
        }
        for(String s:alist)
        {
            System.out.println(s+","+tempMap.get(s)+","+s.length());
        }
        return alist;
    }
}


























