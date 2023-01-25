package controlleur.gestiontables;

import javax.swing.JTable;

public interface TableEditor<T> {
	public T lireLigneTable(int index);
	public void ecrireLigneTable(T data, int numeroLigne);
	
	static void viderTable(JTable table) {
        int row = table.getRowCount();
        int column = table.getColumnCount();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (table.getValueAt(row, column) != null) {
                    table.setValueAt(null, row, column);
                }
            }
        }
    }
}
