
package br.ufes.republica.view.republica.state;

import br.ufes.republica.models.Republica;
import br.ufes.republica.service.RepublicaService;
import br.ufes.republica.view.republica.ManterRepublicaPresenter;


public abstract class ManterRepublicaState {
    
    protected Republica entrada;
    protected RepublicaService service;
    protected ManterRepublicaPresenter controler;

    public ManterRepublicaState(Republica entradar, ManterRepublicaPresenter controler) {
        this.entrada = entrada;
        this.controler = controler;
    }

    public ManterRepublicaState(ManterRepublicaPresenter controler) {
        this.controler = controler;
    }
    
    public abstract void confirmarAction(Republica republica) throws Exception;
    
}
