package br.ufes.republica.grafico.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarraHorizontal extends GraficoConcreto {

    public GraficoBarraHorizontal(DefaultCategoryDataset dataset) {
        super(dataset);
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.HORIZONTAL, true, false, false);
        return grafico;
    }

}
