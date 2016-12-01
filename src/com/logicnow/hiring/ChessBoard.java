package com.logicnow.hiring;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;

    private final ChestPiece[][] pieces;

    public ChessBoard() {
        pieces = new ChestPiece[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void Add(ChestPiece cp, int xCoordinate, int yCoordinate) {
        if (IsLegalBoardPosition(xCoordinate, yCoordinate) && (pieces[xCoordinate][yCoordinate] == null || pieces[xCoordinate][yCoordinate].getPieceColor() != cp.getPieceColor())) {
            cp.setXCoordinate(xCoordinate);
            cp.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = cp;
        } else {
            cp.setXCoordinate(-1);
            cp.setYCoordinate(-1);
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT;
    }

    public void printChessBoard() {
        for (int i = 0; i < MAX_BOARD_WIDTH; i++) {
            for (int j = 0; j < MAX_BOARD_HEIGHT; j++) {
                if (pieces[i][j] == null) {
                    System.out.print("[ ]");
                } else if (pieces[i][j].getPieceColor().equals("WHITE")) {
                    System.out.print("[o]");
                } else {
                    System.out.print("[*]");
                }
            }
                System.out.println("");            
        }
    }
}
