package br.ufes.republica.models;

public class FeedbackMorador {
 
    private Feedback feedback;
    private Pessoa morador;

    public FeedbackMorador(Feedback feedback, Pessoa morador) {
        this.feedback = feedback;
        this.morador = morador;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public Pessoa getMorador() {
        return morador;
    }
    
}
