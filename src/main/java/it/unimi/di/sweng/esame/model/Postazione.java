package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record Postazione(@NotNull Bagnino bagnino, @NotNull Area area, @NotNull Bandiera bandiera) {
  public Postazione segnala(Bandiera bandiera) {
    return new Postazione(bagnino, area, bandiera);
  }

  public String format1() {
    return "[" + area.pos() + "] " + bagnino.nome() + " segnala " + bandiera.messaggio;
  }

  public String format2() {
    return  bagnino.nome() + " è alla postazione " + area.pos();
  }
}
