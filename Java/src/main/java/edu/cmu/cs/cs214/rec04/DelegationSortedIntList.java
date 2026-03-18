package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private int totalAdded = 0;
    private SortedIntList sortedList;

    public DelegationSortedIntList() {
        sortedList = new SortedIntList();
    }

    @Override
    public boolean add(int value) {
        boolean result = sortedList.add(value);
        if (result){
            totalAdded++;
        } 
        return result;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            result |= this.add(list.get(i));
        }
        return result;
    }

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedList.size();
    }
    
    public int getTotalAdded() {
        return totalAdded;
    }
}