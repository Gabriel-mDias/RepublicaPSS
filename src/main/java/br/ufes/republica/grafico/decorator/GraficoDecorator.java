package br.ufes.republica.grafico.decorator;

import org.jfree.chart.JFreeChart;

public abstract class GraficoDecorator extends Grafico {

    protected Grafico elementoDecorado;

    public GraficoDecorator(Grafico elementoDecorado) {
        this.elementoDecorado = elementoDecorado;
    }

    @Override
    public abstract JFreeChart plotar();

}
