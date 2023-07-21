package it.unimi.di.sweng.esame;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import it.unimi.di.sweng.esame.presenters.PostazionePresenter;
import it.unimi.di.sweng.esame.views.PostazioneView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class VariTest {

  @Test
  void presenterCheckNomeVuoto() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view);
    SUT.action("Arriva", "");

    verify(view).showError("nome vuoto");
  }

  @Test
  void presenterCheckNomeTroppoLungo() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view);
    SUT.action("Arriva", "Dimitri Kunz d’Asburgo Lorena Piast Bielitz Bielice Belluno Spalia Rasponi Spinelli Romano Principe Dimitri Miesko Leopoldo");

    verify(view).showError("nome troppo lungo");
  }

  @Test
  void presenterCheckNomeLungOK() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view);
    SUT.action("Arriva", "Carlo");

    verify(view).showSuccess();
  }
}