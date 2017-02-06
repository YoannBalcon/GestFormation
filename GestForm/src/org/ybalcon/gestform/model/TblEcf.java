package org.ybalcon.gestform.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ybalcon
 */
public class TblEcf extends AbstractTableModel {

    private final String[] titre = {"id", "ecf"};
    private List<ECF> ecfs;

    public TblEcf(List<ECF> ecfs) {
        this.ecfs = ecfs;
    } 
    public void setModel(List<ECF> ecfs) {
        this.ecfs = ecfs;
        fireTableDataChanged();
    }

    public  void addEcf(ECF ecf) {
        this.ecfs.add(ecf);
        this.fireTableDataChanged();
    }
    
    public  void delEcf(ECF ecf) {
        this.ecfs.remove(ecf);
        this.fireTableDataChanged();
    }
 @Override
    public int getRowCount() {
        return ecfs.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    public ECF getEcf(int rowIndex) {
        return ecfs.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ecfs.get(rowIndex).getId();

            case 1:
                return ecfs.get(rowIndex).getNom();

            default:
                throw new IllegalArgumentException();
        }
    }

  

}
