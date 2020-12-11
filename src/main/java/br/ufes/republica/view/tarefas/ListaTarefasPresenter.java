package br.ufes.republica.view.tarefas;

import br.ufes.republica.models.Tarefa;
import br.ufes.republica.service.TarefaService;
import br.ufes.republica.view.presenter.BaseInternalFramePresenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ListaTarefasPresenter extends BaseInternalFramePresenter<ListaTarefasView> {

    private DefaultTableModel tmTarefas;
    private List<Tarefa> tarefas;
    private TarefaService tarefaService;

    public ListaTarefasPresenter(JDesktopPane container) {
        super(container, new ListaTarefasView());
        ListaTarefasView view = getView();
        tarefaService = new TarefaService();
        
        tarefas = new ArrayList<>();
        
        tmTarefas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tmTarefas.setDataVector(new Object[][]{}, new String[]{"Tarefa", "Responsáveis", "Data Agendamento", "Data de Término", "Realizada"});
        
        try {
            // TODO: Mudar para república atual
            buscar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        view.getTbTarefa().setModel(tmTarefas);
        
        view.getTbTarefa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        view.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buscar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getBtnCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    excluir();
                    buscar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.setVisible(true);
    }
    
    private void buscar() throws Exception {
        String pessoa = null;
        String descricao = null;
        
        tmTarefas.setNumRows(0);
        
        if (getView().getCbBusca().getSelectedItem().toString().equalsIgnoreCase("Pessoa")) {
            pessoa = getView().getTxtBusca().getText();
        }
        
        if (getView().getCbBusca().getSelectedItem().toString().equalsIgnoreCase("Descrição")) {
            descricao = getView().getTxtBusca().getText();
        }
        
        this.tarefas = tarefaService.filter(1L, pessoa, descricao);
        for(Tarefa tarefa : tarefas) {
            String dataAgendameto = tarefa.getDataAgendamento() != null ? tarefa.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
            String dataTermino = tarefa.getDataTermino() != null ? tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
            tmTarefas.addRow(new Object[]{ tarefa.getDescricao(), tarefa.getMoradores(), dataAgendameto, dataTermino, tarefa.isFinalizada() ? "Sim" : "Não" });
        }
    }
    
    private void excluir() throws Exception {
        int linhaSelecionada = getView().getTbTarefa().getSelectedRow();
        if (linhaSelecionada >= 0) {
            Tarefa tarefa = tarefas.get(linhaSelecionada);
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a tarefa", "", JOptionPane.YES_NO_OPTION);
            
            if (opcao == 0) {
                tarefaService.delete(tarefa.getId());
                JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso!", "", JOptionPane.OK_OPTION);
            }
        }
    }

}
