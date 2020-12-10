package br.ufes.republica.grafico.decorator;

import org.jfree.chart.JFreeChart;

public class TituloEixoY extends GraficoDecorator {

    private String descricao;

    public TituloEixoY(Grafico elementoDecorado, String descricao) {
        super(elementoDecorado);
        this.descricao = descricao;
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = this.elementoDecorado.plotar();
        grafico.getCategoryPlot().getRangeAxis().setLabel(descricao);

        return grafico;
    }

}
