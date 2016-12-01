package com.logicnow.hiring;

public class ChestPiece extends abstractChestPiece {

    public ChestPiece(ChessBoard chessBoard, PieceColor pieceColor, PieceType pieceType) {
        super(chessBoard, pieceColor, pieceType);
    }

    public void Move(MovementType movementType, int newX, int newY) {
        if (getChesssBoard().IsLegalBoardPosition(newX, newY)) {
            if (movementType.equals(MovementType.MOVE)) {
                //System.out.println(DefineMovement.getChessPieceMovement(this, newX, newY));
                DefineMovement.getChessPieceMovement(this, newX, newY);
            } else if (movementType.equals(MovementType.CAPTURE)) {
                System.out.println("To be defined (or removed)");
            }
        } else {
            //System.out.println("Illegal move attempt: Chest Piece out of Range");
        }
    }
}
