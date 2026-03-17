class Position {
    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}

abstract class Piece {
    protected Position a;

    public Piece(Position a) {
        this.a = a;
    }

    public abstract boolean isLegalMove(Position b);
    public abstract String getSymbol(); 
}

class Rook extends Piece {
    private final String symbol = "R";
    public Rook(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        return a.getCol() == b.getCol() || a.getRow() == b.getRow();
    }
}

class Bishop extends Piece {
    private final String symbol = "B";
    public Bishop(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        return Math.abs(a.getRow() - b.getRow()) == Math.abs(a.getCol() - b.getCol());
    }
}

class Knight extends Piece {
    private final String symbol = "k";
    public Knight(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        int rowDiff = Math.abs(b.getRow() - a.getRow());
        int collDiff = Math.abs(a.getCol() - b.getCol());
        return (rowDiff == 2 && collDiff == 1) || (rowDiff == 1 && collDiff == 2);
    }
}

class Queen extends Piece {
    private final String symbol = "Q";
    public Queen(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        boolean direct = (a.getCol() == b.getCol()) || (b.getRow() == a.getRow());
        boolean diagonal = (Math.abs(a.getCol() - b.getCol())) == (Math.abs(b.getRow() - a.getRow()));
        return direct || diagonal;
    }
}

class King extends Piece {
    private final String symbol = "K";
    public King(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        return Math.abs(a.getRow() - b.getRow()) <= 1 && Math.abs(a.getCol() - b.getCol()) <= 1;
    }
}

class Pawn extends Piece {
    private final String symbol = "P";
    public Pawn(Position a) { super(a); }
    @Override
    public String getSymbol() { return symbol; }
    @Override
    public boolean isLegalMove(Position b) {
        if ((b.getCol() < 1 || b.getCol() > 8) || (b.getRow() > 8 || b.getRow() < 1)) return false;
        return b.getCol() == a.getCol() && b.getRow() == a.getRow() + 1;
    }
}

public class Board {
    private Piece[][] cells = new Piece[8][8];

    public void drawBoard() {
        System.out.println("\n   1 2 3 4 5 6 7 8");
        System.out.println("  -----------------");
        for (int i = 7; i >= 0; i--) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < 8; j++) {
                if (cells[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(cells[i][j].getSymbol() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  -----------------");
    }

    public void setPiece(int r, int c, Piece p) {
        cells[r - 1][c - 1] = p;
    }

    public void moveTo(Piece p, int c, int r) {
        if (p.isLegalMove(new Position(c, r))) {
            if (cells[r - 1][c - 1] != null) {
                System.out.println("Error: Cell (" + c + "," + r + ") is occupied!");
                return;
            }
            cells[p.a.getRow() - 1][p.a.getCol() - 1] = null;
            cells[r - 1][c - 1] = p;
            p.a = new Position(c, r);
            System.out.println("Moved to " + c + "," + r);
            drawBoard();
        } else {
            System.out.println("Move to " + c + "," + r + " is illegal for " + p.getSymbol());
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        
        Rook r1 = new Rook(new Position(1, 1));
        Knight kn1 = new Knight(new Position(2, 1));
        Bishop b1 = new Bishop(new Position(3, 1));
        Queen q1 = new Queen(new Position(4, 1));
        King k1 = new King(new Position(5, 1));
        Pawn p1 = new Pawn(new Position(8, 2));

        b.setPiece(1, 1, r1);
        b.setPiece(1, 2, kn1);
        b.setPiece(1, 3, b1);
        b.setPiece(1, 4, q1);
        b.setPiece(1, 5, k1);
        b.setPiece(2, 8, p1);

        System.out.println("    Starting Game:   ");
        b.drawBoard();

        b.moveTo(r1, 1, 4); // a1->a4
        b.moveTo(kn1, 3, 3); // b1->c3
    }
}