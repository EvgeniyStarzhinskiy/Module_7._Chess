public class Horse extends ChessPiece {
    Horse(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((((toLine - line == 1) && (toColumn - column == 2)) ||
                ((toLine - line == 2) && (toColumn - column == 1)) ||
                ((toLine - line == 2) && (toColumn - column == -1)) ||
                ((toLine - line == 1) && (toColumn - column == -2)) ||
                ((toLine - line == -1) && (toColumn - column == -2)) ||
                ((toLine - line == -2) && (toColumn - column == -1)) ||
                ((toLine - line == -2) && (toColumn - column == 1)) ||
                ((toLine - line == -1) && (toColumn - column == 2))) &&
                (((line >= 0) && (line <= 7)) &&
                        ((column >= 0) && (column <= 7)) &&
                        ((toLine >= 0) && (toLine <= 7)) &&
                        ((toColumn >= 0) && (toColumn <= 7))) &&
                (chessBoard.board[toLine][toColumn] == null))
            return true;
        else return false;
    }

    public boolean hasAttackToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((((toLine - line == 1) && (toColumn - column == 2)) ||
                ((toLine - line == 2) && (toColumn - column == 1)) ||
                ((toLine - line == 2) && (toColumn - column == -1)) ||
                ((toLine - line == 1) && (toColumn - column == -2)) ||
                ((toLine - line == -1) && (toColumn - column == -2)) ||
                ((toLine - line == -2) && (toColumn - column == -1)) ||
                ((toLine - line == -2) && (toColumn - column == 1)) ||
                ((toLine - line == -1) && (toColumn - column == 2))) &&
                (((line >= 0) && (line <= 7)) &&
                        ((column >= 0) && (column <= 7)) &&
                        ((toLine >= 0) && (toLine <= 7)) &&
                        ((toColumn >= 0) && (toColumn <= 7))))
            return true;
        else return false;
    }

    public String getSymbol() {
        return "H";
    }
}
