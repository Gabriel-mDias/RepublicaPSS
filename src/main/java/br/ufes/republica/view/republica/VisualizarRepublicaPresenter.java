/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica;

import br.ufes.republica.collection.EstadoRepublicaCollection;
import br.ufes.republica.models.Endereco;
import br.ufes.republica.models.Republica;
import br.ufes.republica.service.RepublicaService;
import br.ufes.republica.view.moradores.ListaMoradoresPresenter;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import br.ufes.republica.view.republica.state.EditarRepublicaPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class VisualizarRepublicaPresenter extends BaseInternalFramePresenter<VisualizarRepublicaView> {
    
    private Republica republica;
    private RepublicaService service;

    public VisualizarRepublicaPresenter(Republica republica, JDesktopPane container) {
        super(container, new VisualizarRepublicaView());
        this.republica = republica;
        this.service = new RepublicaService();

        
        this.getView().getBtnExcluir().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    republica.setEstado(EstadoRepublicaCollection.getInstancia().cria("EstadoExtinta"));
                    service.update(republica);
                    JOptionPane.showMessageDialog(getView(), "República excluida!", "Excluir República", JOptionPane.OK_OPTION);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Excluir República", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        this.getView().getBtnManterMoradores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.add(new ListaMoradoresPresenter(republica, container).getView());
            }
        });
        
        this.getView().getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterRepublicaPresenter(container, republica);
            }
        });
        
        
        this.getView().setVisible(true);
    }
    
    
    private void inserirTela(Republica republica){
        this.getView().getTxtNome().setText(republica.getNome());
        this.getView().getTxtFundacao().setText(republica.getDataFundacao().toString());
        this.getView().getTxtDespesaMedia().setText(String.valueOf(republica.getDespesaMediaMorador()));
        this.getView().getTxtTotalVagas().setText(String.valueOf(republica.getNumeroTotalVagas()));
        this.getView().getTxtVantagens().setText(republica.getVantagens());
        this.getView().getTxtEstatuto().setText(republica.getEstatuto());
        
            //Endereço
        this.getView().getTxtLogradouro().setText(republica.getEndereco().getLogradouro());
        this.getView().getTxtBairro().setText(republica.getEndereco().getBairro());
        this.getView().getTxtPontoReferencia().setText(republica.getEndereco().getPontoReferencia());
        this.getView().getTxtLocalizacaoGeografica().setText(republica.getEndereco().getLocalizacaoGeografica());
        this.getView().getTxtCEP().setText(republica.getEndereco().getCep());
    }
    
    private void obterTela(Republica republica){
        republica.setNome(this.getView().getTxtNome().getText());
        republica.setDataFundacao(LocalDate.now());
        republica.setDespesaMediaMorador( Integer.valueOf(this.getView().getTxtDespesaMedia().getText()) );
        republica.setNumeroTotalVagas( Integer.valueOf(this.getView().getTxtTotalVagas().getText()));
        republica.setVantagens(this.getView().getTxtVantagens().getText());
        republica.setEstatuto(this.getView().getTxtEstatuto().getText());
        
        republica.setEndereco(new Endereco());
            //Endereço
        republica.getEndereco().setLogradouro(this.getView().getTxtLogradouro().getText());
        republica.getEndereco().setBairro(this.getView().getTxtBairro().getText());
        republica.getEndereco().setPontoReferencia(this.getView().getTxtPontoReferencia().getText());
        republica.getEndereco().setLocalizacaoGeografica(this.getView().getTxtLocalizacaoGeografica().getText());
        republica.getEndereco().setCep(this.getView().getTxtCEP().getText());
    }
}
