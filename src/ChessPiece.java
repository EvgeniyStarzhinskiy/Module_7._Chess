public abstract class ChessPiece {
    public String color;
    public boolean check = true; //check

    ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    // В аргементы метода isUnderAttack() добавляем selfPiece для исклучения из проверки самой себя(фигуры).
    //Т.к. сама себя фигура отаковать не может.
    // Метод isUnderAttack() не абстрактный, поскольку пока применяется только к королю
    public boolean isUnderAttack(ChessPiece selfPiece, ChessBoard chessBoard, int line, int column) {
        return false;
    }

    //Переопределяем метод canMoveToPosition() для каждого класса(фигуры), с учетом атаки "занятого поля".
    //Другими словами определение "битого поля".
    // Например: король не может встать на поле f7 и забрать там белого коня,
    //поскольку оно бито белым слоном.
    //Так же, для пешки поля, на которые она может встать и поля, на которые она может встать ПРИ ВЗЯТИИ различны
    public abstract boolean hasAttackToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

}
