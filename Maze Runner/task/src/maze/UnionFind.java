package maze;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UnionFind<T>  {
    private Map<T,T> id;
    private Map<T,Integer> size;
    public  UnionFind(T[] items){
        id=new HashMap<>();
        size=new HashMap<>();
        for (T item:items){
            id.put(item,item);
            size.put(item,1);
        }
    }
    public UnionFind(){
        id=new HashMap<>();
        size=new HashMap<>();
    }
    public void add(T item){
        if (id.containsKey(item)) return;
        id.put(item,item);
        size.put(item,1);
    }
    public T find(T item){
        if (id.get(item)==null) return null;
        if (id.get(item)==item) return item;
        T root=item;
        while(id.get(root)!=root) root=id.get(root);  //Спускаемся до корневого
        while(item!=root) {
            T parent=id.get(item);
            id.put(item,root);
            item=parent;
        }
        return root;
    }
    public void union(T one,T two){
        T oneId=find(one);
        T twoId=find(two);
        if (oneId==twoId || oneId==null || twoId==null) return;
        if (size.get(oneId)>size.get(twoId)){
            id.put(two,oneId);
        } else{
            id.put(one,twoId);
            if (Objects.equals(size.get(oneId),size.get(twoId))){
                size.put(oneId,size.get(oneId)+1);
            }
        }
    }
    public boolean isConnected(T one,T two){
        return (find(one)!=null && find(two)!=null && find(one)==find(two));
    }
}
