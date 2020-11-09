package lesson4;

public class Cinema {

    private final String name;
    private final int rowsNumber;
    private final int seatsRowNumber;

    public Cinema(String name, int rowsNumber, int seatsRowNumber) {
        this.name = name;
        this.rowsNumber = rowsNumber;
        this.seatsRowNumber = seatsRowNumber;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getSeatsRowNumber() {
        return seatsRowNumber;
    }
}
