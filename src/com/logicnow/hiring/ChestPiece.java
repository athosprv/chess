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

    /**
     *
     * @param chessBoard
     * @param pieceColor
     * @param pieceType
     */
    protected ChestPiece(ChessBoard chessBoard, PieceColor pieceColor, PieceType pieceType) {
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

        String movementMessage = "Trying to move a "
                + this.getPieceType() + " from: " + this.getXCoordinate() + "," + this.getYCoordinate()
                + " to " + newX + "," + newY + ". ";
        if (getChesssBoard().IsLegalBoardPosition(newX, newY)) {
            if (movementType.equals(MovementType.MOVE)) {
                if (DefineMovement.getChessPieceMovement(this, newX, newY)) {
                    movementMessage += "Success.";
                } else {
                    movementMessage += "Failure. Can't move in that Pattern";
                }
            } else if (movementType.equals(MovementType.CAPTURE)) {
                System.out.println("To be defined (or removed)");
            }
        } else {
            movementMessage += "Failure. Chest Piece out of Range";
        }
        System.out.println(movementMessage);
    }

    @Override
    public String toString() {
        return "Current X: {" + xCoordinate + "}Current Y: {" + yCoordinate + "}Piece Color: {" + pieceColor + "}+ Piece Type: {" + pieceType + "}";
    }

}
