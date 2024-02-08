package fr.epita.assistants.myset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
public class IntegerSet {
    ArrayList<Integer> base_;

    public IntegerSet() {
        base_ = new ArrayList<>();
    }

    public void insert(Integer i){
        if (!base_.contains(i)){
            base_.add(i);
            Collections.sort(base_);
        }
    }

    public void remove(Integer i){
        base_.remove(i);
    }

    public boolean has(Integer i){
        return base_.contains(i);
    }

    public boolean isEmpty(){
        return base_.isEmpty();
    }

    public Integer min(){
        return Collections.min(base_);
    }

    public Integer max(){
        return Collections.max(base_);
    }

    public int size(){
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b){
        IntegerSet res = new IntegerSet();
        for (Integer n : a.base_) {
            if (b.base_.contains(n))
                res.insert(n);
        }
        return res;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b){
        IntegerSet res = new IntegerSet();
        for (Integer n : a.base_) {
                res.insert(n);
        }
        for (Integer n : b.base_) {
                res.insert(n);
        }
        return res;
    }
}
