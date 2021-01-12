package collection;
class HashNode<K,V>{
    int hash;
    K key;
    V value;
    HashNode next;
}
public class MyHashMap<K,V> {
    HashNode[] table;
    int size;

    public static int MyHash(int v,int langth){
        return v&(langth-1);
    }
    public MyHashMap(){
        table = new HashNode[16];
    }

    public V get(K key){
        int hash = MyHash(key.hashCode(),table.length);
        V value = null;
        if (table[hash]!=null){
            HashNode temp = table[hash];
            while (temp!=null){
                if (temp.key.equals(key)){
                    value = (V)temp.value;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }

    public void put(K key,V value){
        HashNode newNode = new HashNode();
        newNode.hash = MyHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;
        HashNode temp = table[newNode.hash];
        HashNode iterLast = null;
        boolean keyRepeat = false;
        if (temp==null){
            table[newNode.hash] = newNode;
            size++;
        }else {
            while (temp!=null){
                if (temp.key.equals(key)){
                    keyRepeat = true;
                    temp.value = value;
                    break;
                }else {
                    iterLast = temp;
                    temp = temp.next;
                }
            }

            if (!keyRepeat){
                iterLast.next = newNode;
                size++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i=0;i<table.length;i++){
            HashNode temp = table[i];
            while (temp!=null){
                stringBuilder.append(temp.key+" : "+temp.value+",");
                temp = temp.next;
            }
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,'}');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
        myHashMap.put(10,"a");
        myHashMap.put(20,"b");
        System.out.println(myHashMap);
    }
}
