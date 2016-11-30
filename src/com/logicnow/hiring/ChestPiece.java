package com.logicnow.hiring;

public class ChestPiece extends abstractChestPiece {

    public ChestPiece(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public void Move(MovementType movementType, int newX, int newY) {

        if (movementType.equals(MovementType.MOVE)) {
            if (super.getXCoordinate() - newX == 1 && super.getYCoordinate() - newY == 0) {
                this.setXCoordinate(newX);
            } else if (super.getXCoordinate() - newX == 0 && super.getYCoordinate() - newY == 1) {
                this.setYCoordinate(newY);
            }
        }
    }

}
