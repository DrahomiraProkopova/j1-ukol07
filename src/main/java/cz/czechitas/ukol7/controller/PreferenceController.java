package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.PreferenceBean;

import javax.swing.*;
import java.beans.PropertyChangeEvent;


public class PreferenceController {
    private final PresentationModel<PreferenceBean> model;
    private final Action ulozitAction;

    public PreferenceController() {
        model = new PresentationModel<>(new PreferenceBean());
        ulozitAction = ActionBuilder.create("&Uložit", this::handleUlozit);
        model.addBeanPropertyChangeListener(this::handlePropertyChange);
        vypoctiStavAkci();
    }

    private void handlePropertyChange(PropertyChangeEvent propertyChangeEvent) {
        vypoctiStavAkci();
    }

    public PresentationModel<PreferenceBean> getModel() {
        return model;
    }

    public Action getUlozitAction() {
        return ulozitAction;
    }

    private void vypoctiStavAkci() {
        if (model.getBean().getPrezdivka() != null
                && model.getBean().getBarva() != null) {
            System.out.println("enabled true");
            ulozitAction.setEnabled(true);
        } else {
            System.out.println("enabled false");
            ulozitAction.setEnabled(false);
        }
    }

    public void handleUlozit() {
        PreferenceBean bean = this.model.getBean();
        System.out.println("-- Ukládám kontakty osoby --");
        System.out.printf("Přezdívka uživatele: %s", bean.getPrezdivka()).println();
        System.out.printf("Jím vybraná barva: %s", bean.getBarva().getText()).println();
    }
}
