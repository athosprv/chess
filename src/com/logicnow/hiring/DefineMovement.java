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
     * @param newX
     * @param newY
     * @return
     */
    public static boolean getChessPieceMovement(ChestPiece cp, int newX, int newY) {
        switch (cp.getPieceType()) {
            case KING:
                return ValidateKingMovement(cp, newX, newY);
            case QUEEN:
                return ValidateQueenMovement(cp, newX, newY);
            case BISHOP:
                return ValidateBishopMovement(cp, newX, newY);
            case KNIGHT:
                return ValidateKnightMovement(cp, newX, newY);
            case ROOK:
                return ValidateRookMovement(cp, newX, newY);
            case PAWN:
                return ValidatePawnMovement(cp, newX, newY);
        }
        return false;
    }

    private static boolean ValidateBishopMovement(ChestPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == (Math.abs(cp.getYCoordinate() - newY))) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else if ((cp.getXCoordinate() != newX) && (cp.getYCoordinate() != newY) && ((cp.getXCoordinate() - newX) == (cp.getYCoordinate() - newY))) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidateKnightMovement(ChestPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == 2 && (Math.abs(cp.getYCoordinate() - newY) == 1) && Math.abs(cp.getYCoordinate() - newY) == 1) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else if (Math.abs(cp.getYCoordinate() - newY) == 2 && (Math.abs(cp.getXCoordinate() - newX) == 1) && Math.abs(cp.getXCoordinate() - newX) == 1) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidateRookMovement(ChestPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) <= 7 && cp.getYCoordinate() == newY) {
            cp.setXCoordinate(newX);
        } else if (Math.abs(cp.getYCoordinate() - newX) <= 7 && cp.getXCoordinate() == newX) {
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidatePawnMovement(ChestPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == 0 && Math.abs(cp.getYCoordinate() - newY) == 1) {
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidateQueenMovement(ChestPiece cp, int newX, int newY) {
        return ValidateBishopMovement(cp, newX, newY) || ValidateRookMovement(cp, newX, newY);
    }

    private static boolean ValidateKingMovement(ChestPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == 1 && Math.abs(cp.getYCoordinate() - newY) == 0) {
            cp.setXCoordinate(newX);
        } else if (Math.abs(cp.getXCoordinate() - newX) == 0 && Math.abs(cp.getYCoordinate() - newY) == 1) {
            cp.setYCoordinate(newY);
        } else if (Math.abs(cp.getXCoordinate() - newX) == (Math.abs(cp.getYCoordinate() - newY))) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else if ((cp.getXCoordinate() != newX) && (cp.getYCoordinate() != newY) && ((cp.getXCoordinate() - newX) == (cp.getYCoordinate() - newY))) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }
}
