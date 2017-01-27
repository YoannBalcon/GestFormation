/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ybalcon.gestform.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ybalcon
 */
public class TblStagiaire extends AbstractTableModel {

    private final String[] titre = {"matricule", "prénom", "nom", "formation"};
    private List<Stagiaire> stagiaires;

    public TblStagiaire(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public void setModel(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
        fireTableDataChanged();
    }

    public  void addStagiaire(Stagiaire stagiaire) {
        this.stagiaires.add(stagiaire);
        this.fireTableDataChanged();
    }
    
    public  void delStagiaire(Stagiaire stagiaire) {
        this.stagiaires.remove(stagiaire);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return stagiaires.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    public Stagiaire getStagiaire(int rowIndex) {
        return stagiaires.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return stagiaires.get(rowIndex).getMatricule();

            case 1:
                return stagiaires.get(rowIndex).getPrenom();

            case 2:
                return stagiaires.get(rowIndex).getNom();

            case 3:
                return stagiaires.get(rowIndex).getFormation();

            default:
                throw new IllegalArgumentException();
        }
    }

}
