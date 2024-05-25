package TableConstrain;

public class DataModifierForInvoice {
    private String[][] data;

    public DataModifierForInvoice(int rows, int cols) {
        data = new String[rows][cols];
    }

    // Method to dynamically resize the data array
    public void resize(int rows, int cols) {
        String[][] newData = new String[rows][cols];
        for (int i = 0; i < Math.min(data.length, newData.length); i++) {
            System.arraycopy(data[i], 0, newData[i], 0, Math.min(data[i].length, newData[i].length));
        }
        data = newData;
    }

    public void setData(int row, String[] rowData) {
        if (row < data.length) {
            // Resize the array if the new data has more columns than the current array
            if (rowData.length > data[row].length) {
                resize(data.length, rowData.length);
            }
            data[row] = rowData;
        }
    }

    public String[][] getData() {
        return data;
    }
}