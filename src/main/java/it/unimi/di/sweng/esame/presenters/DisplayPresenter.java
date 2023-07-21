package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.model.Modello;
import it.unimi.di.sweng.esame.model.Postazione;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisplayPresenter implements Observer<List<Postazione>> {
  private final @NotNull DisplayView view;

  public DisplayPresenter(@NotNull DisplayView view, @NotNull Modello model) {
    model.addObserver(this);
    this.view = view;
  }

  @Override
  public void update(Observable<List<Postazione>> subj) {
    for (int i = 0; i < Main.NUMPOSTAZIONI; i++) {
      view.set(i,"postazione non presidiata");
    }

    for (Postazione postazione : subj.getState()) {
      view.set(postazione.area().pos(), postazione.format1());
    }
  }
}
