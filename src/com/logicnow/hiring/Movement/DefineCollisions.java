/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicnow.hiring.Movement;

import com.logicnow.hiring.ChessPiece;

/**
 *
 * @author Kimchi
 */
public class DefineCollisions {

    public static boolean ensureNoCollisions(ChessPiece cp, MovementType movementType, int newX, int newY) {
        switch (cp.getPieceType()) {
            case KING:
                return ensureNoCollisionsKing(cp, movementType, newX, newY);
            case QUEEN:
                return ensureNoCollisionsQueen(cp, movementType, newX, newY);
            case BISHOP:
                return ensureNoCollisionsBishop(cp, movementType, newX, newY);
            case KNIGHT:
                return ensureNoCollisionsKnight(cp, movementType, newX, newY);
            case ROOK:
                return ensureNoCollisionsRook(cp, movementType, newX, newY);
            case PAWN:
                return ensureNoCollisionsPawn(cp, movementType, newX, newY);
        }
        return false;
    }

    private static boolean ensureNoCollisionsKing(ChessPiece cp, MovementType movementType, int newX, int newY) {
        return MoveOrCapture(cp, movementType, newX, newY);
    }

    private static boolean ensureNoCollisionsQueen(ChessPiece cp, MovementType movementType, int newX, int newY) {
        return ensureNoCollisionsRook(cp, movementType, newX, newY) || ensureNoCollisionsBishop(cp, movementType, newX, newY);
    }

    private static boolean ensureNoCollisionsBishop(ChessPiece cp, MovementType movementType, int newX, int newY) {

        if (Math.abs(cp.getXCoordinate() - newX) == (Math.abs(cp.getYCoordinate() - newY))) {
            int stepX = cp.getXCoordinate(), stepY = cp.getYCoordinate();
            while (stepX < newX && stepY < newY) {
                stepX++;
                stepY++;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
            while (stepX > newX && stepY < newY) {
                stepX--;
                stepY++;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
            while (stepX > newX && stepY > newY) {
                stepX--;
                stepY--;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
            while (stepX < newX && stepY > newY) {
                stepX++;
                stepY--;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean ensureNoCollisionsKnight(ChessPiece cp, MovementType movementType, int newX, int newY) {
        return MoveOrCapture(cp, movementType, newX, newY);
    }

    private static boolean ensureNoCollisionsRook(ChessPiece cp, MovementType movementType, int newX, int newY) {
        int stepX = cp.getXCoordinate(), stepY = cp.getYCoordinate();

        if (stepX != newX && stepY == newY) {
            while (stepX < newX) {
                stepX++;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
            while (stepX > newX) {
                stepX--;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
        } else if (stepX == newX && stepY != newY) {
            while (stepY < newY) {
                stepY++;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
            while (stepY > newY) {
                stepY--;
                if (!MoveOrCapture(cp, movementType, stepX, stepY)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean ensureNoCollisionsPawn(ChessPiece cp, MovementType movementType, int newX, int newY) {
        return MoveOrCapture(cp, movementType, newX, newY);
    }

    private static boolean MoveOrCapture(ChessPiece cp, MovementType movementType, int stepX, int stepY) {
        if (movementType.equals(MovementType.MOVE)) {
            return cp.getChesssBoard().Retrieve(stepX, stepY) == null;
        } else if (movementType.equals(MovementType.CAPTURE)) {
            return cp.getChesssBoard().Retrieve(stepX, stepY) == null || cp.getChesssBoard().Retrieve(stepX, stepY).getPieceColor() != cp.getPieceColor();
        }
        return false;
    }
}
