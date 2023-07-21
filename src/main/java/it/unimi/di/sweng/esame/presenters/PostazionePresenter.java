package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Bagnino;
import it.unimi.di.sweng.esame.views.PostazioneView;
import org.jetbrains.annotations.NotNull;

public class PostazionePresenter implements Presenter{
  private @NotNull  final PostazioneView view;

  public PostazionePresenter(@NotNull PostazioneView view) {
    this.view = view;
    view.addHandlers(this);
  }

  @Override
  public void action(@NotNull String comando, @NotNull String args) {
    try {
      Bagnino bagnino = new Bagnino(args);
      //model.arriva(bagnino, pos);
      view.showSuccess();
    } catch (IllegalArgumentException e) {
      view.showError(e.getMessage());
    }

  }
}
