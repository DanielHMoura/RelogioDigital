package com.relogio.Controller;

import com.relogio.Model.TimerModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FuncionamentoRelogio {
    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Timeline timeline;
    private TimerModel timerModel = new TimerModel();
    private Timeline timelineTimer;

    @FXML
    private Label lblRelogio;

    @FXML
    private Spinner<Integer> spHoras;

    @FXML
    private Spinner<Integer> spMinutos;

    @FXML
    private Spinner<Integer> spSegundos;

    @FXML
    private Button bIniciar;

    @FXML
    private Button bPausar;

    @FXML
    private Button bParar;

    @FXML
    private Label lblTimer;


    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> lblRelogio.setText(LocalTime.now().format(formatoHora))),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        SpinnerValueFactory<Integer> valueFactoryHoras = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0);
        SpinnerValueFactory<Integer> valueFactoryMinutos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        SpinnerValueFactory<Integer> valueFactorySegundos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

        spHoras.setValueFactory(valueFactoryHoras);
        spMinutos.setValueFactory(valueFactoryMinutos);
        spSegundos.setValueFactory(valueFactorySegundos);

        bIniciar.setOnAction(e -> iniciarTimer());

        bPausar.setOnAction(e -> pausarTimer());

        bParar.setOnAction(e -> pararTimer());
    }
    @FXML
    public void iniciarTimer() {
        int horas = spHoras.getValue();
        int minutos = spMinutos.getValue();
        int segundos = spSegundos.getValue();

        timerModel.setTempo(horas, minutos, segundos);

        if (timerModel.isTempoEsgotado()) {
            timelineTimer.stop();
            bIniciar.setDisable(false);
            bPausar.setText("Pausar");  // reseta o texto também
        }

        timelineTimer = new Timeline(
                new KeyFrame(Duration.ZERO, e -> atualizarDisplayTimer()),
                new KeyFrame(Duration.seconds(1), e -> {
                    timerModel.diminuir();
                    if (timerModel.isTempoEsgotado()) {
                        timelineTimer.stop();
                    }
                })
        );
        timelineTimer.setCycleCount(Animation.INDEFINITE);
        timelineTimer.play();
        bIniciar.setDisable(true);

        bIniciar.setDisable(true);
        spHoras.setDisable(true);
        spMinutos.setDisable(true);
        spSegundos.setDisable(true);

        atualizarDisplayTimer();
    }

    private void atualizarDisplayTimer() {
        lblTimer.setText(timerModel.getTempoFormatado());
    }

    @FXML
    private void pausarTimer() {
        if (timelineTimer == null) return;
        if (timelineTimer.getStatus() == Animation.Status.RUNNING) {
            timelineTimer.pause();
            bPausar.setText("Continuar");
        } else {
            timelineTimer.play();
            bPausar.setText("Pausar");
        }
    }

        @FXML
        private void pararTimer() {
            if (timelineTimer != null) {
                timelineTimer.stop();
            }
            timerModel.setTempo(0, 0, 0);

            spHoras.getValueFactory().setValue(0);
            spMinutos.getValueFactory().setValue(0);
            spSegundos.getValueFactory().setValue(0);

            atualizarDisplayTimer();
            reabilitarControles();
            bIniciar.setDisable(false);
            bPausar.setText("Pausar");
        }

    private void reabilitarControles() {
        bIniciar.setDisable(false);
        spHoras.setDisable(false);
        spMinutos.setDisable(false);
        spSegundos.setDisable(false);
        bPausar.setText("Pausar");
    }
    }