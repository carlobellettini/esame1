package it.unimi.di.sweng.esame;

public interface Observer<T> {
  void update(Observable<T> subj);
}
