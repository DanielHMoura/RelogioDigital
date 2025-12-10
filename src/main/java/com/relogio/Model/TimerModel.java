package com.relogio.Model;

public class TimerModel {
    private int segundosRestantes;

    public void setTempo(int horas, int minutos, int segundos) {
        this.segundosRestantes = horas * 3600 + minutos * 60 + segundos;
    }

    public int getSegundosRestantes() {
        return segundosRestantes;
    }

    public String getTempoFormatado() {
        return formatarTempo();
    }

    public void diminuir(){
        if (segundosRestantes > 0) {
            segundosRestantes--;
        }
    }

    public boolean isTempoEsgotado(){
        return segundosRestantes == 0;
    }

    public String formatarTempo() {
        int horas = segundosRestantes / 3600;
        int minutos = (segundosRestantes % 3600) / 60;
        int segundos = segundosRestantes % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
