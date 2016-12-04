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

    public static boolean ensureNoCollisions(ChessPiece cp, int newX, int newY) {
        switch (cp.getPieceType()) {
            case KING:
                return ensureNoCollisionsKing(cp, newX, newY);
            case QUEEN:
                return ensureNoCollisionsQueen(cp, newX, newY);
            case BISHOP:
                return ensureNoCollisionsBishop(cp, newX, newY);
            case KNIGHT:
                return ensureNoCollisionsKnight(cp, newX, newY);
            case ROOK:
                return ensureNoCollisionsRook(cp, newX, newY);
            case PAWN:
                return ensureNoCollisionsPawn(cp, newX, newY);
        }
        return false;
    }

    private static boolean ensureNoCollisionsKing(ChessPiece cp, int newX, int newY) {
        return cp.getChesssBoard().Retrieve(newX, newY) == null;
    }

    private static boolean ensureNoCollisionsQueen(ChessPiece cp, int newX, int newY) {
        return ensureNoCollisionsRook(cp, newX, newY) || ensureNoCollisionsBishop(cp, newX, newY);
    }

    private static boolean ensureNoCollisionsBishop(ChessPiece cp, int newX, int newY) {
        if (Math.abs(cp.getXCoordinate() - newX) == (Math.abs(cp.getYCoordinate() - newY))) {
            int stepX = cp.getXCoordinate(), stepY = cp.getYCoordinate();
            while (stepX < newX && stepY < newY) {
                stepX++;
                stepY++;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
            while (stepX > newX && stepY < newY) {
                stepX--;
                stepY++;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
            while (stepX > newX && stepY > newY) {
                stepX--;
                stepY--;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
            while (stepX < newX && stepY > newY) {
                stepX++;
                stepY--;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean ensureNoCollisionsKnight(ChessPiece cp, int newX, int newY) {
        return cp.getChesssBoard().Retrieve(newX, newY) == null;
    }

    private static boolean ensureNoCollisionsRook(ChessPiece cp, int newX, int newY) {
        int stepX = cp.getXCoordinate(), stepY = cp.getYCoordinate();

        if (stepX != newX && stepY == newY) {
            while (stepX < newX) {
                stepX++;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
            while (stepX > newX) {
                stepX--;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
        } else if (stepX == newX && stepY != newY) {
            while (stepY < newY) {
                stepY++;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
            while (stepY > newY) {
                stepY--;
                if (cp.getChesssBoard().Retrieve(stepX, stepY) != null) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean ensureNoCollisionsPawn(ChessPiece cp, int newX, int newY) {
        return cp.getChesssBoard().Retrieve(newX, newY) == null;
    }
}
