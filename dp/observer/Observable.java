package ro.uvt.dp.observer;
import ro.uvt.dp.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    List<Observer> observers;

    private static Observable observableInstance = null;

    public static Observable getInstance() {
        if(observableInstance == null){
            synchronized (Observable.class){
                if(observableInstance == null){
                    observableInstance = new Observable();
                }
            }
        }
        return observableInstance;
    }

    protected Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        System.out.println("An admin has logged in");
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
