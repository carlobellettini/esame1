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
    return getListaPostazioni();
  }


  @Override
  public void arriva(@NotNull Bagnino bagnino, @NotNull Area area) {
    super.arriva(bagnino, area);
    notifyObservers();
  }

  @Override
  public void segnala(@NotNull Bagnino bagnino, @NotNull Bandiera bandiera) {
    super.segnala(bagnino, bandiera);
    notifyObservers();
  }

  @Override
  public void vaVia(Bagnino bagnino) {
    super.vaVia(bagnino);
    notifyObservers();
  }
}
