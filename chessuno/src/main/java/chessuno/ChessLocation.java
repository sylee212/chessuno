package chessuno;

public class ChessLocation {

    // stores the x and y coordinates
    private int chessRowCoordinate;
    private int chessColumnCoordinate;

    public ChessLocation(int chessColumnCoordinate, int chessRowCoordinate) {
        
        setChessRowCoordinate(chessRowCoordinate);
        setChessColumnCoordinate(chessColumnCoordinate);
    }


    /**
     * @return int return the chessRowCoordinate
     */
    public int getChessRowCoordinate() {
        return chessRowCoordinate;
    }

    /**
     * @param chessRowCoordinate the chessRowCoordinate to set
     */
    public void setChessRowCoordinate(int chessRowCoordinate) {
        this.chessRowCoordinate = chessRowCoordinate;
    }

    /**
     * @return int return the chessColumnCoordinate
     */
    public int getChessColumnCoordinate() {
        return chessColumnCoordinate;
    }

    /**
     * @param chessColumnCoordinate the chessColumnCoordinate to set
     */
    public void setChessColumnCoordinate(int chessColumnCoordinate) {
        this.chessColumnCoordinate = chessColumnCoordinate;
    }

}
