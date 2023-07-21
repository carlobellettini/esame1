package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Main;

public record Area(int pos) {
  public Area {
    if (pos <0 || pos >= Main.NUMPOSTAZIONI) throw new IllegalArgumentException("postazione non valida");
  }
}
