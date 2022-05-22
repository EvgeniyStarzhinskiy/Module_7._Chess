public class King extends ChessPiece {
    King(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (((line >= 0) && (line <= 7)) &&
                ((column >= 0) && (column <= 7)) &&
                ((toLine >= 0) && (toLine <= 7)) &&
                ((toColumn >= 0) && (toColumn <= 7)) &&
                !((toColumn == column) && (toLine == line)) &&
                (Math.abs(toLine - line) < 2 && Math.abs(toColumn - column) < 2) &&
                (chessBoard.board[toLine][toColumn] == null)) return true;
        else return false;
    }

    public boolean hasAttackToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (((line >= 0) && (line <= 7)) &&
                ((column >= 0) && (column <= 7)) &&
                ((toLine >= 0) && (toLine <= 7)) &&
                ((toColumn >= 0) && (toColumn <= 7)) &&
                !((toColumn == column) && (toLine == line)) &&
                (Math.abs(toLine - line) < 2 && Math.abs(toColumn - column) < 2))
            return true;
        else return false;
    }

    public boolean isUnderAttack(ChessPiece selfPiece, ChessBoard chessBoard, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 7; i > -1; i--) {
            for (int j = 0; j < 8; j++) {
                if ((chessBoard.board[i][j] != null) &&
                        !chessBoard.board[i][j].equals(selfPiece) &&
                        !selfPiece.getColor().equals(chessBoard.board[i][j].getColor()) &&
                        chessBoard.board[i][j].hasAttackToPosition(chessBoard, i, j, line, column)) {
                    isUnderAttack = true;
                    break;
                }
            }
        }
        return isUnderAttack;
    }

    public String getSymbol() {
        return "K";
    }
}
