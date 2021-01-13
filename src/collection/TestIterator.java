package collection;

import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("list_a");
        list.add("list_b");
        list.add("list_c");
        for (Iterator<String> iterator = list.iterator();iterator.hasNext();){
            String temp = iterator.next();
            System.out.println(temp);
        }


        Set<String> set = new HashSet<>();
        set.add("set_a");
        set.add("set_b");
        set.add("set_c");
        for (Iterator<String> iterator = set.iterator();iterator.hasNext();){
            String temp = iterator.next();
            System.out.println(temp);
        }


        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hash_a");
        map.put(2,"hash_b");
        map.put(3,"hash_c");

        System.out.println("way one :");
        Set<Map.Entry<Integer,String>> one = map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iterator = one.iterator();iterator.hasNext();){
            Map.Entry<Integer,String> temp = iterator.next();
            System.out.println(temp.getKey()+" : "+temp.getValue());
        }

        System.out.println("way two :");
        Set<Integer> two = map.keySet();
        for (Iterator<Integer> iterator = two.iterator();iterator.hasNext();){
            Integer key = iterator.next();
            System.out.println(key+" : " + map.get(key));
        }

    }
}
