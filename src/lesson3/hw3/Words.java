package lesson3.hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Words {
    private static final String STR =
            "Ночь, улица, фонарь, аптека,\n" +
            "Бессмысленный и тусклый свет.\n" +
            "Живи ещё хоть четверть века —\n" +
            "Всё будет так. Исхода нет.\n" +
            "\n" +
            "Умрёшь — начнёшь опять сначала\n" +
            "И повторится всё, как встарь:\n" +
            "Ночь, ледяная рябь канала,\n" +
            "Аптека, улица, фонарь.";
    private  static String[] words;

    static {
        words = STR.split("(?U)\\W+");
        for (int i = 0; i < words.length; i++){
            words[i] = words[i].toLowerCase();
        }
    }

    private static LinkedHashSet<String> getUnicWords(String[] arr){
        LinkedHashSet<String> set = new LinkedHashSet<>(arr.length);
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        return set;
    }

    private static HashMap<String, Integer> howManyTimesEachWord(String[] arr){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+ 1);
            }else {
                map.put(arr[i], 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(words));
        System.out.println(getUnicWords(words));
        System.out.println(howManyTimesEachWord(words));
    }
}
