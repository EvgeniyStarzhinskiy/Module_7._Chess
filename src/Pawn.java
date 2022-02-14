public class Pawn extends ChessPiece {
    Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((((line >= 0) && (line <= 7)) &&
                ((column >= 0) && (column <= 7)) &&
                ((toLine >= 0) && (toLine <= 7)) &&
                ((toColumn >= 0) && (toColumn <= 7))) &&
                ((chessBoard.board[line][column].getColor().equals("White") && (
                        ((line == 1) && (toLine == 3) && (column == toColumn) && (chessBoard.board[3][toColumn] == null) && (chessBoard.board[2][toColumn] == null)) ||
                                ((line >= 1) && (toLine == line + 1) && (column == toColumn) && (chessBoard.board[toLine][toColumn] == null)))) ||
                        (chessBoard.board[line][column].getColor().equals("Black") && (
                                ((line == 6) && (toLine == 4) && (column == toColumn) && (chessBoard.board[4][toColumn] == null) && (chessBoard.board[5][toColumn] == null)) ||
                                        ((line <= 6) && (toLine == line - 1) && (column == toColumn) && (chessBoard.board[toLine][toColumn] == null))))))
            return true;
        else return false;

    }

    public boolean hasAttackToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((((line >= 0) && (line <= 7)) &&
                ((column >= 0) && (column <= 7)) &&
                ((toLine >= 0) && (toLine <= 7)) &&
                ((toColumn >= 0) && (toColumn <= 7))) &&
                ((chessBoard.board[line][column].getColor().equals("White") && (
                        ((line == 4) && (toLine == 6) && ((toColumn == column + 1) || (toColumn == column - 1))) ||
                                ((line >= 1) && (toLine == line + 1) && ((toColumn == column + 1) || (toColumn == column - 1))))) ||
                        (chessBoard.board[line][column].getColor().equals("Black") && (
                                ((line == 3) && (toLine == 1) && ((toColumn == column + 1) || (toColumn == column - 1))) ||
                                        ((line <= 6) && (toLine == line - 1) && ((toColumn == column + 1) || (toColumn == column - 1)))))))
            return true;
        else return false;

    }

    public String getSymbol() {
        return "P";
    }
}
