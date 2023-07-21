package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Bagnino;
import it.unimi.di.sweng.esame.model.Bandiera;
import it.unimi.di.sweng.esame.views.PostazioneView;
import org.jetbrains.annotations.NotNull;

public class PostazionePresenter implements Presenter {
  private @NotNull
  final PostazioneView view;

  public PostazionePresenter(@NotNull PostazioneView view) {
    this.view = view;
    view.addHandlers(this);
  }

  @Override
  public void action(@NotNull String comando, @NotNull String args) {
    try {
      if (comando.equals("Arriva")) {
        Bagnino bagnino = new Bagnino(args);
        //model.arriva(bagnino, pos);
      } else if (comando.equals("Segnala")) {
        String[] argomenti = args.split(",", 2);
        if (argomenti.length != 2)  throw new IllegalArgumentException("numero parametri non valido");
        if (argomenti[1].isBlank()) throw new IllegalArgumentException("Indicare colore bandiera");
        Bagnino bagnino = new Bagnino(argomenti[0]);
        Bandiera bandiera = Bandiera.valueOf(argomenti[1]);
        //model.segnala(bagnino, bandiera);
      }
      view.showSuccess();
    } catch (IllegalArgumentException e) {
      if (e.getMessage().startsWith("No enum constant it.unimi.di.sweng.esame.model.Bandiera."))
        view.showError("Bandiera non valida");
      else
        view.showError(e.getMessage());
    }

  }
}
