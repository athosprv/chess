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
public class DefineMovement {

    /**
     *
     * @param cp
     * @return
     */
    public static String getChessPieceMovement(ChestPiece cp, int newX, int newY) {
        // use the enum values in our switch statement here
        String movementMessage = "Trying to move a "
                + cp.getPieceType() + " from: " + cp.getXCoordinate() + "," + cp.getYCoordinate()
                + " to " + newX + "," + newY + ". ";
        switch (cp.getPieceType()) {
            /*case KING:
                return "";
            case QUEEN:
                return "";
            case ROOK:
                return "";
            case BISHOP:
                return "";
             */
            case KNIGHT:
                if (Math.abs(cp.getXCoordinate() - newX) <= 7 && cp.getYCoordinate() == newY) {
                    cp.setXCoordinate(newX);
                } else if (Math.abs(cp.getYCoordinate() - newX) <= 7 && cp.getXCoordinate() == newX) {
                    cp.setYCoordinate(newY);
                } else {
                    return movementMessage += "Failure.";
                }
                return movementMessage += "Success.";
            case PAWN:
                if (Math.abs(cp.getXCoordinate() - newX) == 1 && Math.abs(cp.getYCoordinate() - newY) == 0) {
                    cp.setXCoordinate(newX);
                } else if (Math.abs(cp.getXCoordinate() - newX) == 0 && Math.abs(cp.getYCoordinate() - newY) == 1) {
                    cp.setYCoordinate(newY);
                } else {
                    return movementMessage += "Failure.";
                }
                return movementMessage += "Success.";
            default:
                return "Nothing happened";
        }
    }

}
