package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;
public class GenericSet<T extends Comparable>{
    ArrayList<T> base_;

    public GenericSet() {
        base_ = new ArrayList<>();
    }

    public void insert(T i){
        if (!base_.contains(i)){
            base_.add(i);
            Collections.sort(base_);
        }
    }

    public void remove(T i){
        base_.remove(i);
    }

    public boolean has(T i){
        return base_.contains(i);
    }

    public boolean isEmpty(){
        return base_.isEmpty();
    }

    public Comparable min(){
        return Collections.min(base_);
    }

    public Comparable max(){
        return Collections.max(base_);
    }

    public int size(){
        return base_.size();
    }

    public static GenericSet intersection(GenericSet a, GenericSet b){
        GenericSet res = new GenericSet();
        for (Object n : a.base_) {
            if (b.base_.contains(n))
                res.insert((Comparable) n);
        }
        return res;
    }

    public static GenericSet union(GenericSet a, GenericSet b){
        GenericSet res = new GenericSet();
        for (Object n : a.base_) {
                res.insert((Comparable) n);
        }
        for (Object n : b.base_) {
                res.insert((Comparable) n);
        }
        return res;
    }
}
