/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicnow.hiring.Movement;

import com.logicnow.hiring.ChessPiece;
import com.logicnow.hiring.Enum.PieceColor;

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
    public static boolean getChessPieceMovement(ChessPiece cp, MovementType movementType, int newX, int newY) {
        if (DefineCollisions.ensureNoCollisions(cp, movementType, newX, newY)) {
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
                    return ValidatePawnMovement(cp, movementType, newX, newY);
            }
        }
        return false;
    }

    private static boolean ValidateBishopMovement(ChessPiece cp, int newX, int newY) {
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

    private static boolean ValidateKnightMovement(ChessPiece cp, int newX, int newY) {
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

    private static boolean ValidateRookMovement(ChessPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) <= 7 && cp.getYCoordinate() == newY) {
            cp.setXCoordinate(newX);
        } else if (Math.abs(cp.getYCoordinate() - newX) <= 7 && cp.getXCoordinate() == newX) {
            cp.setYCoordinate(newY);
        } else {
            return false;
        }
        return true;
    }

    private static boolean ValidatePawnMovement(ChessPiece cp, MovementType mt, int newX, int newY) {
        switch (mt) {
            case MOVE:
                if (Math.abs(cp.getXCoordinate() - newX) == 0) {
                    if (cp.getPieceColor().equals(PieceColor.WHITE) && ((cp.getYCoordinate() - newY) == -1)) {
                        cp.setYCoordinate(newY);
                    } else if (cp.getPieceColor().equals(PieceColor.BLACK) && ((cp.getYCoordinate() - newY) == 1)) {
                        cp.setYCoordinate(newY);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }   break;
            case CAPTURE:
                switch (cp.getPieceColor()) {
                    case WHITE:
                        boolean downLeftCapture = (cp.getXCoordinate() - newX == 1 && cp.getYCoordinate() - newY == -1);
                        boolean downRightCapture = (cp.getXCoordinate() - newX == -1 && cp.getYCoordinate() - newY == 1);
                        
                        if (downLeftCapture || downRightCapture) {
                            cp.setXCoordinate(newX);
                            cp.setYCoordinate(newY);
                        }
                    case BLACK:
                        boolean upLeftCapture = (cp.getXCoordinate() - newX == 1 && cp.getYCoordinate() - newY == 1);
                        boolean upRightCapture = (cp.getXCoordinate() - newX == -1 && cp.getYCoordinate() - newY == -1);
                        if (upLeftCapture || upRightCapture) {
                            cp.setXCoordinate(newX);
                            cp.setYCoordinate(newY);
                        }
                        
                }   break;
            default:
                return false;
        }
        
        return true;

    }

    private static boolean ValidateQueenMovement(ChessPiece cp, int newX, int newY) {
        return ValidateBishopMovement(cp, newX, newY) || ValidateRookMovement(cp, newX, newY);
    }

    private static boolean ValidateKingMovement(ChessPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == 1 && Math.abs(cp.getYCoordinate() - newY) == 0) {
            cp.setXCoordinate(newX);
        } else if (Math.abs(cp.getXCoordinate() - newX) == 0 && Math.abs(cp.getYCoordinate() - newY) == 1) {
            cp.setYCoordinate(newY);
        } else if (Math.abs(cp.getXCoordinate() - newX) == 1 && Math.abs(cp.getYCoordinate() - newY) == 1) {
            cp.setXCoordinate(newX);
            cp.setYCoordinate(newY);
        } else {
            return false;
        }

        return true;
    }
}
