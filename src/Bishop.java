public class Bishop extends ChessPiece {
    Bishop(String color) {
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
                !((toColumn == column) && (toLine == line)) &&
                (((toLine - line) == (toColumn - column)) ||
                        ((toLine - line) == -(toColumn - column)) ||
                        (-(toLine - line) == (toColumn - column)) ||
                        (-(toLine - line) == -(toColumn - column))) &&
                (chessBoard.board[toLine][toColumn] == null)) {
            boolean isBlockCell = false;
            if ((toLine > line) && (toColumn > column)) {
                int n_cell = toLine - line;
                for (int i = 1; i < n_cell; i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        isBlockCell = true;
                        break;
                    }
                }
            } else if (toLine > line) {
                int n_cell = toLine - line;
                for (int i = 1; i < n_cell; i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        isBlockCell = true;
                        break;
                    }
                }
            } else if ((toLine < line) && (toColumn < column)) {
                int n_cell = -(toLine - line);
                for (int i = 1; i < n_cell; i++) {
                    if (chessBoard.board[line - i][column - i] != null) {
                        isBlockCell = true;
                        break;
                    }
                }
            } else if (toLine < line) {
                int n_cell = -(toLine - line);
                for (int i = 1; i < n_cell; i++) {
                    if (chessBoard.board[line - i][column + i] != null) {
                        isBlockCell = true;
                        break;
                    }
                }
            }
            return !isBlockCell;
        } else return false;
    }

    public boolean hasAttackToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isBeatToPosition = false;
        boolean isLastCell = false;
        if ((((line >= 0) && (line <= 7)) &&
                ((column >= 0) && (column <= 7)) &&
                ((toLine >= 0) && (toLine <= 7)) &&
                ((toColumn >= 0) && (toColumn <= 7))) &&
                !((toColumn == column) && (toLine == line)) &&
                (((toLine - line) == (toColumn - column)) ||
                        ((toLine - line) == -(toColumn - column)) ||
                        (-(toLine - line) == (toColumn - column)) ||
                        (-(toLine - line) == -(toColumn - column)))) {
            if ((toLine > line) && (toColumn > column)) {
                int n_cell = toLine - line;
                for (int i = 1; i <= n_cell; i++) {
                    isBeatToPosition = true;
                    if (isLastCell) {
                        isBeatToPosition = false;
                        break;
                    }
                    if (chessBoard.board[line + i][column + i] != null) isLastCell = true;
                }
            } else if (toLine > line) {
                int n_cell = toLine - line;
                for (int i = 1; i <= n_cell; i++) {
                    isBeatToPosition = true;
                    if (isLastCell) {
                        isBeatToPosition = false;
                        break;
                    }
                    if (chessBoard.board[line + i][column - i] != null) isLastCell = true;
                }
            } else if (toColumn < column) {
                int n_cell = -(toLine - line);
                for (int i = 1; i <= n_cell; i++) {
                    isBeatToPosition = true;
                    if (isLastCell) {
                        isBeatToPosition = false;
                        break;
                    }
                    if (chessBoard.board[line - i][column - i] != null) isLastCell = true;
                }
            } else {
                int n_cell = -(toLine - line);
                for (int i = 1; i <= n_cell; i++) {
                    isBeatToPosition = true;
                    if (isLastCell) {
                        isBeatToPosition = false;
                        break;
                    }
                    if (chessBoard.board[line - i][column + i] != null) isLastCell = true;
                }
            }
            return isBeatToPosition;
        } else return false;
    }

    public String getSymbol() {
        return "B";
    }
}
