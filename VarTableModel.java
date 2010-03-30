import javax.swing.table.*;
import java.util.regex.*;

/* ************
*   VarTableModel describes the data in the table
*  ************
*/

public class VarTableModel extends AbstractTableModel {
    private Object[][] data;
    private String[] columnNames;
    
    private Pattern digits = Pattern.compile("^-?\\d+$");
    
    public VarTableModel(String[][] inData, String[] colN) {
        data = new Object[inData.length][inData[0].length];
        columnNames = colN;
        
        for ( int i = 0; i < inData.length; i++) {
            for (int j = 0; j < inData[i].length; j++) {
                
                if (digits.matcher(inData[i][j]).find()) {
                    data[i][j] = Integer.parseInt(inData[i][j]);
                }
                else {
                    data[i][j] = inData[i][j];
                }
            }
        }
    }

    public int getRowCount() {
        return data.length;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0,c).getClass();
    }
}
