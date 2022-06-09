package cz.czechitas.ukol7.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;
import cz.czechitas.ukol7.barvy.Barvy;

import java.beans.PropertyChangeListener;


public class PreferenceBean implements ObservableBean {
    private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);
    private String prezdivka;
    private Barvy barva;

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        if (prezdivka.isBlank()) {
            prezdivka = null;
        }
        String oldValue = this.prezdivka;
        this.prezdivka = prezdivka;
        pcs.firePropertyChange("prezdivka", oldValue, prezdivka);
    }

    public Barvy getBarva() {
        return barva;
    }

    public void setBarva(Barvy newValue) {
        Barvy oldValue = this.barva;
        this.barva = newValue;
        pcs.firePropertyChange("barva", oldValue, barva);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
