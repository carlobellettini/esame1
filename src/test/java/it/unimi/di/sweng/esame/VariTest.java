package it.unimi.di.sweng.esame;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import it.unimi.di.sweng.esame.model.*;
import it.unimi.di.sweng.esame.presenters.PostazionePresenter;
import it.unimi.di.sweng.esame.views.PostazioneView;
import org.junit.jupiter.api.Test;


class VariTest {

  private Modello model = mock(Modello.class);
  private Area pos = mock(Area.class);

  @Test
  void presenterCheckNomeVuoto() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Arriva", "");

    verify(view).showError("nome vuoto");
  }

  @Test
  void presenterCheckNomeTroppoLungo() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Arriva", "Dimitri Kunz d’Asburgo Lorena Piast Bielitz Bielice Belluno Spalia Rasponi Spinelli Romano Principe Dimitri Miesko Leopoldo");

    verify(view).showError("nome troppo lungo");
  }

  @Test
  void presenterCheckNomeLungOK() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Arriva", "Carlo");

    verify(view).showSuccess();
  }


  @Test
  void presenterCheckBandieraValida() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Segnala", "Carlo,TURCHESE");

    verify(view).showError("Bandiera non valida");
  }

  @Test
  void presenterCheckBandieraNonSpecificata() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Segnala", "Carlo,");

    verify(view).showError("Indicare colore bandiera");
  }


  @Test
  void presenterCheckBandieraOK() {
    PostazioneView view = mock(PostazioneView.class);
    PostazionePresenter SUT = new PostazionePresenter(view, model, pos);
    SUT.action("Segnala", "Carlo,ROSSA");

    verify(view).showSuccess();
  }


  @Test
  void checkModelloArrivoBagnino() {

    Modello SUT = new Modello();
    final var bagnino = mock(Bagnino.class);
    final var area = mock(Area.class);

    SUT.arriva(bagnino, area);
    //assertThat(SUT.getListaPostazioni()).extracting("bagnino", "area").contains(tuple(new Bagnino("Carlo"), new Area(1)));
    assertThat(SUT.getListaPostazioni()).containsExactly(new Postazione(bagnino, area, Bandiera.NONE));
  }


  @Test
  void checkModelloSegnalaBandiera() {

    Modello SUT = new Modello();
    final var bagnino = mock(Bagnino.class);
    final var area = mock(Area.class);
    final var bandiera = mock(Bandiera.class);

    SUT.arriva(bagnino, area);
    SUT.segnala(bagnino, bandiera);
    //assertThat(SUT.getListaPostazioni()).extracting("bagnino", "area").contains(tuple(new Bagnino("Carlo"), new Area(1)));
    assertThat(SUT.getListaPostazioni()).containsExactly(new Postazione(bagnino, area, bandiera));
  }

  @Test
  void checkModelloSegnalaBandieraDaBagninoNonPresente() {

    Modello SUT = new Modello();
    final var bagnino = mock(Bagnino.class);
    final var area = mock(Area.class);
    final var bandiera = mock(Bandiera.class);

    assertThatThrownBy(() -> SUT.segnala(bagnino, bandiera))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("postazione non presidiata");


  }

  @Test
  void checkModelloArrivoBagninoInPostazioneOccupata() {

    Modello SUT = new Modello();
    final var bagnino = mock(Bagnino.class);
    final var bagnino1 = mock(Bagnino.class);
    final var area = mock(Area.class);
    SUT.arriva(bagnino1, area);

    assertThatThrownBy(() -> SUT.arriva(bagnino, area))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("postazione già occupata");

  }

  @Test
  void checkModelloArrivoBagninoGiàInAltraPostazione() {

    Modello SUT = new Modello();
    final var bagnino = mock(Bagnino.class);
    final var area = mock(Area.class);
    SUT.arriva(bagnino, mock(Area.class));

    assertThatThrownBy(() -> SUT.arriva(bagnino, area))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("bagnino già presente in altra postazione");

  }

}