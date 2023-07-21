package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modello {
  private final @NotNull Map<Bagnino, Postazione> postazioni = new HashMap<>();

  public void arriva(@NotNull Bagnino bagnino, @NotNull Area area) {
    postazioni.put(bagnino, new Postazione(bagnino, area, Bandiera.NONE));
  }

  public @NotNull List<Postazione> getListaPostazioni() {
    return new ArrayList<>(postazioni.values());
  }

  public void segnala(@NotNull Bagnino bagnino, @NotNull Bandiera bandiera) {
    if (!postazioni.containsKey(bagnino)) throw new IllegalArgumentException("postazione non presidiata");

    postazioni.put(bagnino, new Postazione(bagnino, postazioni.get(bagnino).area(), bandiera));
  }
}
