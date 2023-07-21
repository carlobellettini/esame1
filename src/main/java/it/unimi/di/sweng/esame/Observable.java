package it.unimi.di.sweng.esame;

public interface Observable<T> {
  void notifyObservers();

  void addObserver(Observer<T> o);

  T getState();
}
