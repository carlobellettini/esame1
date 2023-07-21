package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class Modello extends State implements Observable<@NotNull List<@NotNull Postazione>> {
  private final @NotNull List<Observer<List<Postazione>>> observers = new ArrayList<>();

  @Override
  public void notifyObservers() {
    for (Observer<List<Postazione>> observer : observers) {
      observer.update(this);
    }
  }

  @Override
  public void addObserver(@NotNull Observer<List<Postazione>> o) {
    observers.add(o);
  }

  @Override
  public List<Postazione> getState() {
    return null;
  }
}
