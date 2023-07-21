package it.unimi.di.sweng.esame.presenters;

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
    if (args.isBlank()) view.showError("nome vuoto");
    else if (args.length()>30) view.showError("nome troppo lungo");
  }
}
