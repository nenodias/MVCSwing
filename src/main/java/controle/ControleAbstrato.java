package controle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import modelo.ModeloAbstrato;
import visao.VisaoPainelAbstrato;

public abstract class ControleAbstrato implements PropertyChangeListener {
    
    
    private ArrayList<VisaoPainelAbstrato> visoesRegistradas;
    private ArrayList<ModeloAbstrato> modelosRegistrados;
    
    public ControleAbstrato() {
        visoesRegistradas = new ArrayList<VisaoPainelAbstrato>();
        modelosRegistrados = new ArrayList<ModeloAbstrato>();
    }

    public void adicionarModelo(ModeloAbstrato model) {
        modelosRegistrados.add(model);
        model.adicionarObservadorPropriedade(this);
    }

    public void removerModelo(ModeloAbstrato model) {
        modelosRegistrados.remove(model);
        model.removerObservadorPropriedade(this);
    }
    
    public void adicionarVisao(VisaoPainelAbstrato view) {
        visoesRegistradas.add(view);
    }

    public void removerVisao(VisaoPainelAbstrato view) {
        visoesRegistradas.remove(view);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        
        for (VisaoPainelAbstrato view: visoesRegistradas) {
            view.modeloAtualizacaoPropriedade(evt);
        }
    }
  
    protected void setPropriedadeModelo(String nomePropriedade, Object novoValor) {
        for (ModeloAbstrato modelo: modelosRegistrados) {
            try {
                Method metodo = modelo.getClass().getMethod("set"+nomePropriedade, new Class[] { novoValor.getClass() } );
                metodo.invoke(modelo, novoValor);
            } catch (Exception ex) {
            	
            }
        }
    }
    
}
