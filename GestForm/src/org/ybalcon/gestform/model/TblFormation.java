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
public class TblFormation extends AbstractTableModel {

    private final String[] title = {"id", "formation"};
    private List<Formation> formations;

    public TblFormation(List<Formation> formations) {
        this.formations = formations;
    }
 public void setModel(List<Formation> formations) {
        this.formations = formations;
        fireTableDataChanged();
    }

    public  void addFormation(Formation formation) {
        this.formations.add(formation);
        this.fireTableDataChanged();
    }
    
    public  void delFormation(Formation formation) {
        this.formations.remove(formation);
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int column) {
        return title[column];
    }

    public Formation getFormation(int rowIndex) {
        return formations.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return formations.size();
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return formations.get(rowIndex).getId();

            case 1:
                return formations.get(rowIndex).getNom();

            default:
                throw new IllegalArgumentException();
        }
    }

}
