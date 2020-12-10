package br.ufes.republica.grafico;

import br.ufes.republica.grafico.decorator.Grafico;
import br.ufes.republica.grafico.decorator.GraficoBarraHorizontal;
import br.ufes.republica.grafico.decorator.GraficoBarraVertical;
import br.ufes.republica.grafico.decorator.TituloEixoX;
import br.ufes.republica.grafico.decorator.TituloEixoY;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoPresenter {

    private GraficoView view;
    private Grafico grafico;
    private DefaultCategoryDataset dataset;

    public GraficoPresenter(DefaultCategoryDataset dataset) {
        this.view = new GraficoView();
        this.dataset = dataset;
        this.grafico = new GraficoBarraHorizontal(dataset);

        initListeners();

        plotarGrafico();

        this.view.setVisible(true);
    }

    private void initListeners() {
        this.view.getCbTipoGrafico().addActionListener((e) -> {
            if (this.view.getCbTipoGrafico().getSelectedItem().toString().equals("Barra Horizontal")) {
                this.grafico = new GraficoBarraHorizontal(dataset);
            } else if (this.view.getCbTipoGrafico().getSelectedItem().toString().equals("Barra Vertical")) {
                this.grafico = new GraficoBarraVertical(dataset);
            }

            this.view.updateUI();
            this.view.getCbTituloEixo().setSelected(false);

            plotarGrafico();
        });

        this.view.getCbTituloEixo().addActionListener((e) -> {
            boolean selected = this.view.getCbTituloEixo().isSelected();

            if (selected) {
                String tituloEixoX = JOptionPane.showInputDialog(view, "Titulo eixo X");
                String tituloEixoY = JOptionPane.showInputDialog(view, "Titulo eixo Y");

                grafico = new TituloEixoX(grafico, tituloEixoX);
                grafico = new TituloEixoY(grafico, tituloEixoY);
            } else {
                grafico = new TituloEixoX(grafico, "");
                grafico = new TituloEixoY(grafico, "");
            }

            this.view.updateUI();

            plotarGrafico();
        });
    }

    private void plotarGrafico() {
        ChartPanel painelGrafico = new ChartPanel(grafico.plotar());
        this.view.getPnlGrafico().setLayout(new BorderLayout());
        this.view.getPnlGrafico().removeAll();
        this.view.getPnlGrafico().add(painelGrafico);
    }

    public GraficoView getView() {
        return view;
    }

}
