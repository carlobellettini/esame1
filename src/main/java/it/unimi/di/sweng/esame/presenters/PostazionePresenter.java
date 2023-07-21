package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.PostazioneView;

public class PostazionePresenter implements Presenter{
  private final PostazioneView view;

  public PostazionePresenter(PostazioneView view) {
    this.view = view;
  }

  @Override
  public void action(String text1, String text2) {
    view.showError("nome vuoto");
  }
}
