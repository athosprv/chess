/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicnow.hiring;

import com.logicnow.hiring.Enum.PieceColor;
import com.logicnow.hiring.Enum.PieceType;
import com.logicnow.hiring.Movement.MovementType;
import com.logicnow.hiring.Movement.DefineMovement;

/**
 *
 * @author Kimchi
 */
public class ChessPiece {

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
    public ChessPiece(ChessBoard chessBoard, PieceColor pieceColor, PieceType pieceType) {
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
        int oldX = this.getXCoordinate();
        int oldY = this.getYCoordinate();
        if (getChesssBoard().IsLegalBoardPosition(newX, newY)) {
            if (newX == oldX && newY == oldY) {
                movementMessage += "Failure. Old and New move is the same";
            } else if (getChesssBoard().Retrieve(newX, newY) != null && movementType != MovementType.CAPTURE) {
                movementMessage += "Failure. Another Chess Piece of the same color exists at that location";
            } else if (movementType.equals(MovementType.MOVE) || movementType.equals(MovementType.CAPTURE)) {
                if (DefineMovement.getChessPieceMovement(this, movementType, newX, newY)) {
                    this.chessBoard.UpdateChessPieceMove(oldX, oldY, newX, newY);
                    if (movementType.equals(MovementType.MOVE)) {
                        movementMessage += "Movement Success.";
                    } else if (movementType.equals(MovementType.CAPTURE)) {
                        movementMessage += "Capture Success.";
                    }
                } else {
                    movementMessage += "Failure. Can't move in that Pattern, or path blocked";
                }
            }
        } else {
            movementMessage += "Failure. Chest Piece out of Range";
        }
        //System.out.println(movementMessage);
    }

    @Override
    public String toString() {
        return "Current X: {" + xCoordinate + "}Current Y: {" + yCoordinate + "}Piece Color: {" + pieceColor + "} Piece Type: {" + pieceType + "}";
    }

}
