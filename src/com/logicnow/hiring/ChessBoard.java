package com.logicnow.hiring;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 8;
    public static int MAX_BOARD_HEIGHT = 8;

    private final ChestPiece[][] chessBoard;

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

    public void printChessBoard() {
        for (int j = 0; j < MAX_BOARD_WIDTH; j++) {
            for (int i = 0; i < MAX_BOARD_HEIGHT; i++) {
                if (chessBoard[i][j] == null) {
                    System.out.print("[" + i + " " + j + "]");
                } else if (chessBoard[i][j].getPieceColor().equals("WHITE")) {
                    System.out.print("[" + i + "o" + j + "]");
                } else {
                    System.out.print("[" + i + "*" + j + "]");
                }
            }
            System.out.println("");
        }
    }
}
