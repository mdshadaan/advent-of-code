package day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_1/input.txt"));
        String currentLine = "";
        List<String> arr;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while((currentLine = reader.readLine())!=null){
            arr = Arrays.stream(currentLine.split(" ")).filter(s->!s.isBlank()).toList();
            list1.add(Integer.parseInt(arr.getFirst()));
            list2.add(Integer.parseInt(arr.get(1)));
        }
        int ans = 0 ;
        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());
        List<Integer> distinctElementsinListOne = list1.stream().distinct().toList();
        //first part of day 1 question
        for(int i=0;i<list1.size();i++) {
            ans+= Math.abs(list1.get(i)-list2.get(i));
        }
        Map<Integer,Integer> freqCountForSecondList = getFrequencyCount(list2);
        //solving second part of day 1 question
        ans = 0;
         for(Integer i:list1){
            if(freqCountForSecondList.containsKey(i)){
                ans = ans + (freqCountForSecondList.get(i)*i);
            }
         }
        System.out.println(ans);

    }
    public static Map<Integer,Integer> getFrequencyCount(List<Integer> list){
       Map<Integer,Integer> freq = new HashMap<>();
       for(Integer i:list){
           freq.put(i,freq.getOrDefault(i,0)+1);
       }
       return freq;
    }
}
