package br.ufes.republica.grafico.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public abstract class GraficoConcreto extends Grafico {

    protected DefaultCategoryDataset dataset;

    public GraficoConcreto(DefaultCategoryDataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public abstract JFreeChart plotar();

}
