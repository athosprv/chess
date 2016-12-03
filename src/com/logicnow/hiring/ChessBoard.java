package com.logicnow.hiring;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;

    private ChestPiece[][] chessBoard;

    public ChessBoard() {
        chessBoard = new ChestPiece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void Add(ChestPiece cp, int xCoordinate, int yCoordinate) {
        if (IsLegalBoardPosition(xCoordinate, yCoordinate) && (chessBoard[xCoordinate][yCoordinate] == null || chessBoard[xCoordinate][yCoordinate].getPieceColor() != cp.getPieceColor())) {
            cp.setXCoordinate(xCoordinate);
            cp.setYCoordinate(yCoordinate);
            chessBoard[xCoordinate][yCoordinate] = cp;
        } else {
            cp.setXCoordinate(-1);
            cp.setYCoordinate(-1);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT;
    }

    public ChestPiece Retrieve(int x, int y) {
        if (this.chessBoard[x][y] == null) {
            return null;
        } else {
            return this.chessBoard[x][y];
        }
    }

    public void UpdateChestPieceMove(int oldX, int oldY, int newX, int newY) {
        this.chessBoard[newX][newY] = this.chessBoard[oldX][oldY];
        this.chessBoard[oldX][oldY] = null;
    }

    @Override
    public String toString() {
        StringBuilder chessBoard2D = new StringBuilder();
        for (int j = 0; j < MAX_BOARD_WIDTH; j++) {
            for (int i = 0; i < MAX_BOARD_HEIGHT; i++) {
                if (chessBoard[i][j] == null) {
                    chessBoard2D.append("[").append(i).append(" ").append(j).append("]");
                } else if (chessBoard[i][j].getPieceColor() == PieceColor.WHITE) {
                    chessBoard2D.append("[").append(i).append("o").append(j).append("]");
                } else if (chessBoard[i][j].getPieceColor() == PieceColor.BLACK) {
                    chessBoard2D.append("[").append(i).append("*").append(j).append("]");
                }
            }
            chessBoard2D.append("\n");
        }
        return chessBoard2D.toString();
    }

}
