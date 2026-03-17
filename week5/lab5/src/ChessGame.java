/*class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
abstract class Piece {
    Position a; 

    public Piece(Position a) {
        this.a = a;
    }
    public abstract boolean isLegalMove(Position b);

    protected boolean isBasicValid(Position b) {
        if (a.x == b.x && a.y == b.y) return false; 
        return b.x >= 0 && b.x <= 7 && b.y >= 0 && b.y <= 7; 
    }
}

//ЛАДЬЯ: только по прямой
class Rook extends Piece {
    public Rook(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        return a.x == b.x || a.y == b.y;
    }
}

//СЛОН: только по диагонали
class Bishop extends Piece {
    public Bishop(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        return Math.abs(a.x - b.x) == Math.abs(a.y - b.y);
    }
}

//ФЕРЗЬ:Ладья+Слон
class Queen extends Piece {
    public Queen(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        return (a.x == b.x || a.y == b.y) || (Math.abs(a.x - b.x) == Math.abs(a.y - b.y));
    }
}

//КОРОЛЬ:на 1шаг в любую сторону
class King extends Piece {
    public King(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        return Math.abs(a.x - b.x) <= 1 && Math.abs(a.y - b.y) <= 1;
    }
}

//КОНЬ:буквой "Г"
class Knight extends Piece {
    public Knight(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        int dx = Math.abs(a.x - b.x);
        int dy = Math.abs(a.y - b.y);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }
}

//ПЕШКА:упрощенно на 1 вперед
class Pawn extends Piece {
    public Pawn(Position a) { super(a); }

    @Override
    public boolean isLegalMove(Position b) {
        if (!isBasicValid(b)) return false;
        return a.x == b.x && (b.y - a.y == 1);
    }
}
public class ChessGame {
    public static void main(String[] args) {
        Position start = new Position(3, 3); 
        
        Piece knight = new Knight(start);
        Piece bishop = new Bishop(start);

        Position targetOk = new Position(5, 4);  
        Position targetFail = new Position(5, 5); 

        System.out.println("Конь d4 -> f5: " + knight.isLegalMove(targetOk));   
        System.out.println("Конь d4 -> f6: " + knight.isLegalMove(targetFail)); 
        System.out.println("Слон d4 -> f6: " + bishop.isLegalMove(targetFail)); 
    }
}
 */