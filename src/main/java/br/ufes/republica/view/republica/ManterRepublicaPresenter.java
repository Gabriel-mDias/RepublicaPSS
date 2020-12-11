/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.republica.view.republica;

import br.ufes.republica.models.Endereco;
import br.ufes.republica.models.Republica;
import br.ufes.republica.service.RepublicaService;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import br.ufes.republica.view.republica.state.EditarRepublicaPresenter;
import br.ufes.republica.view.republica.state.ManterRepublicaState;
import br.ufes.republica.view.republica.state.NovaRepublicaPresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class ManterRepublicaPresenter extends BaseInternalFramePresenter<EditarRepublicaView>{
    
    private ManterRepublicaState state;
    protected Republica entrada;
    
    public ManterRepublicaPresenter(JDesktopPane container, Republica republica){
        super(container, new EditarRepublicaView());
        
        try{
                republica = new RepublicaService().getRepublicaUsuario(Long.valueOf(5));
        }catch(Exception ex){
            
        }
        
        
        if(republica == null){
            JOptionPane.showMessageDialog(getView(), "Usuário sem república ou informação não foi encontrada", "Editar República", JOptionPane.OK_OPTION);
        }else{
        
            this.state = new EditarRepublicaPresenter(republica, this);
            this.entrada = republica;

            this.inserirTela(entrada);

            this.getView().getBtnConfirmar().addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        state.confirmarAction(obterTela());
                        JOptionPane.showMessageDialog(getView(), "República editada!", "Editar República", JOptionPane.OK_OPTION);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Editar República", JOptionPane.OK_OPTION);
                    }
                }
            });

            this.getView().setVisible(true);
        }
    }
    
    public ManterRepublicaPresenter(JDesktopPane container){
        super(container, new EditarRepublicaView());
        this.state = new NovaRepublicaPresenter(this);
        
        this.getView().getBtnConfirmar().addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    state.confirmarAction(obterTela());
                    JOptionPane.showMessageDialog(getView(), "República salva!", "Cadastrar República", JOptionPane.OK_OPTION);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getView(), ex, "Cadastrar República", JOptionPane.OK_OPTION);
                }
            }
        });
        
        this.getView().setVisible(true);
    }
    
    
    protected void inserirTela(Republica republica){
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
    
    protected Republica obterTela(){
        Republica republica = new Republica();
        if(this.entrada != null){
            republica.setId(this.entrada.getId());
        }
        
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
        
        return republica;
    }
    
}
