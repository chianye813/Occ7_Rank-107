package assignment_ds;

import java.util.ArrayList;

public class InjuryReserveStack<E> {

    private ArrayList<String> injuryReserve = new ArrayList<>();

    public int getSize() {
        return injuryReserve.size();
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The injury reserve is empty");
        }
        return injuryReserve.get(injuryReserve.size() - 1);
    }

    public boolean addInjured(String playerName) {
        return injuryReserve.add(playerName);
    }
    
    public boolean removeRecovered(String playerName) {
        if (isEmpty()) {
            throw new IllegalStateException("The injury reserve is empty");
        }
        return injuryReserve.remove(playerName);
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The injury reserve is empty");
        }
        return injuryReserve.remove(injuryReserve.size() - 1);
    }

    public boolean isEmpty() {
        return injuryReserve.isEmpty();
    }

    @Override
    public String toString() {
        return "Injury Reserve: " + injuryReserve.toString();
    }
    
    public void clear() {
        injuryReserve.clear();
    }
    
    public static void main (String[]args){
        InjuryReserveStack injuryReserve = new InjuryReserveStack();
        System.out.println(injuryReserve.toString());
    }
}
