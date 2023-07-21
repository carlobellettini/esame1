package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public enum Bandiera {
  ROSSA("pericolo elevato"),
  GIALLA("rischio medio"),
  VERDE("nuoto sicuro"),
  VIOLA("pericolo meduse"),
  NONE("ancora nulla");

  public final @NotNull String messaggio;

  Bandiera(@NotNull String messaggio) {
    this.messaggio = messaggio;
  }
}
