package it.unimi.di.sweng.esame.model;

import java.util.Objects;

public record Bagnino(String nome) {
  public Bagnino {
    if (nome.isBlank()) throw new IllegalArgumentException("nome vuoto");
    if (nome.length() > 30) throw new IllegalArgumentException("nome troppo lungo");
  }


}
