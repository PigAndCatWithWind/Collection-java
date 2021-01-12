package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        Collection collection = new ArrayList<String>();
        collection.add("one");//add value
        collection.add("two");
        System.out.println(collection.contains("one"));//To datermine if there is
        collection.remove("one");//remove arraylist value
        System.out.println(collection.size());//the size of the arrayliat
        System.out.println(collection.isEmpty());//judge null
        collection.clear();//empty

        List list = new ArrayList();
        list.add("two");
        list.add("three");
        list.add("four");

        //does collection include all list
        System.out.println(collection.containsAll(list));
        //collection add all list
        collection.addAll(list);
        System.out.println(collection);
        //collection remove that it intersection list
        collection.removeAll(list);
        System.out.println(collection);
        //collection intersection list
        collection.retainAll(list);
        System.out.println(collection.retainAll(list));
    }
}
