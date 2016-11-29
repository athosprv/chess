package com.logicnow.hiring;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        //System.out.println(xCoordinate + ", " + yCoordinate);
        if (IsLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
        else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);            
        }
//        throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate > MAX_BOARD_WIDTH-1 || yCoordinate < 0 || yCoordinate > MAX_BOARD_HEIGHT-1) {
            return false;
        }
        return true;

//throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
