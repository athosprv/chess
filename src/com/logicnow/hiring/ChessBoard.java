package com.logicnow.hiring;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private ChestPiece[][] pieces;

    public ChessBoard() {
        pieces = new ChestPiece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(ChestPiece pawn, int xCoordinate, int yCoordinate) {
        if (IsLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= MAX_BOARD_WIDTH - 1 && yCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT - 1;
    }
}
