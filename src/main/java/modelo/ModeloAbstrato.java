package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ModeloAbstrato
{
    
    protected PropertyChangeSupport suporteTrocaPropriedade;

    public ModeloAbstrato() {
        suporteTrocaPropriedade = new PropertyChangeSupport(this);
    }
    
    public void adicionarObservadorPropriedade(PropertyChangeListener ouvinte) {
        suporteTrocaPropriedade.addPropertyChangeListener(ouvinte);
    }
    
    public void removerObservadorPropriedade(PropertyChangeListener ouvinte) {
        suporteTrocaPropriedade.removePropertyChangeListener(ouvinte);
    }
    
    protected void dispararTrocaPropriedade(String nomePropriedade, Object valorAntigo, Object novoValor) {
        suporteTrocaPropriedade.firePropertyChange(nomePropriedade, valorAntigo, novoValor);
    }
        
  
}
    

