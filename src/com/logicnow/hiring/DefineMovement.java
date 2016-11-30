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
     * @param cpt
     * @return
     */
    public static String getChessPieceMovement(PieceType cpt) {
        // use the enum values in our switch statement here
        switch (cpt) {
            case KING:
                return "";
            case QUEEN:
                return "";
            case ROOK:
                return "";
            case BISHOP:
                return "";
            case KNIGHT:
                return "";
            case PAWN:
                return "";
            default:
                return null;
        }
    }
}
