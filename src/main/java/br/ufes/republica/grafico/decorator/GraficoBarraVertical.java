package br.ufes.republica.grafico.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarraVertical extends GraficoConcreto {

    public GraficoBarraVertical(DefaultCategoryDataset dataset) {
        super(dataset);
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, true, false, false);
        return grafico;
    }

}
