/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicnow.hiring;

/**
 *
 * @author Kimchi
 */
public class ChestPiece {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private final PieceColor pieceColor;
    private final PieceType pieceType;

    public ChestPiece(ChessBoard chessBoard, PieceColor pieceColor, PieceType pieceType) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        this.chessBoard = chessBoard;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        
        if (getChesssBoard().IsLegalBoardPosition(newX, newY)) {
            if (movementType.equals(MovementType.MOVE)) {
                System.out.println(DefineMovement.getChessPieceMovement(this, newX, newY));
            } else if (movementType.equals(MovementType.CAPTURE)) {
                System.out.println("To be defined (or removed)");
            }
        } else {
            //System.out.println("Illegal move attempt: Chest Piece out of Range");
        }
    }

    @Override
    public String toString() {
        return "Current X: {" + xCoordinate + "}Current Y: {" + yCoordinate + "}Piece Color: {" + pieceColor + "}+ Piece Type: {" + pieceType + "}";
    }

}
