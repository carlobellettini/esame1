package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record Postazione(@NotNull Bagnino bagnino, @NotNull Area area, @NotNull Bandiera bandiera) {
  public Postazione segnala(Bandiera bandiera) {
    return new Postazione(bagnino, area, bandiera);
  }
}
