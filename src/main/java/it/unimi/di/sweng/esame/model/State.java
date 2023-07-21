package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class State {
  private final @NotNull Map<Bagnino, Postazione> postazioni = new HashMap<>();
  private final @NotNull Set<Area> areeOccupate = new HashSet<>();

  public void arriva(@NotNull Bagnino bagnino, @NotNull Area area) {
    if (areeOccupate.contains(area)) throw new IllegalArgumentException("postazione già occupata");
    if (postazioni.containsKey(bagnino)) throw new IllegalArgumentException("bagnino già presente in altra postazione");
    postazioni.put(bagnino, new Postazione(bagnino, area, Bandiera.NONE));
    areeOccupate.add(area);
  }

  public @NotNull List<Postazione> getListaPostazioni() {
    return new ArrayList<>(postazioni.values());
  }

  public void segnala(@NotNull Bagnino bagnino, @NotNull Bandiera bandiera) {
    if (!postazioni.containsKey(bagnino)) throw new IllegalArgumentException("postazione non presidiata");

    postazioni.put(bagnino, postazioni.get(bagnino).segnala(bandiera));
  }

  public void vaVia(Bagnino bagnino) {
    if (!postazioni.containsKey(bagnino)) throw new IllegalArgumentException("Bagnino non presente");

    var x = postazioni.remove(bagnino);
    areeOccupate.remove(x.area());
  }
}
