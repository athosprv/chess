package com.logicnow.hiring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChestPieceTest {

    private ChessBoard chessBoard;
    private ChestPiece testPawn, testRook, testKnight, testBishop, testQueen, testKing;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testPawn = new ChestPiece(chessBoard, PieceColor.BLACK, PieceType.PAWN);
        this.testRook = new ChestPiece(chessBoard, PieceColor.BLACK, PieceType.ROOK);
        this.testKnight = new ChestPiece(chessBoard, PieceColor.WHITE, PieceType.KNIGHT);
        this.testBishop = new ChestPiece(chessBoard, PieceColor.BLACK, PieceType.BISHOP);
        this.testQueen = new ChestPiece(chessBoard, PieceColor.WHITE, PieceType.QUEEN);
        this.testKing = new ChestPiece(chessBoard, PieceColor.WHITE, PieceType.KING);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.Add(testPawn, 6, 3);
        assertEquals(6, testPawn.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.Add(testPawn, 6, 3);
        assertEquals(3, testPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testPawn, 7, 3);
        testPawn.Move(MovementType.MOVE, 8, 3);
        assertEquals(7, testPawn.getXCoordinate());
        assertEquals(3, testPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testPawn, 6, 3);
        testPawn.Move(MovementType.MOVE, 6, 5);
        assertEquals(6, testPawn.getXCoordinate());
        assertEquals(3, testPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Up_UpdatesCoordinates() {
        chessBoard.Add(testPawn, 6, 3);
        testPawn.Move(MovementType.MOVE, 6, 2);
        assertEquals(6, testPawn.getXCoordinate());
        assertEquals(2, testPawn.getYCoordinate());
    }

    @Test
    public void testRook_Move_LegalCoordinates_Down_UpdatesCoordinates() {
        chessBoard.Add(testRook, 7, 5);
        testRook.Move(MovementType.MOVE, 7, 7);
        assertEquals(7, testRook.getXCoordinate());
        assertEquals(7, testRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testRook, 7, 3);
        testRook.Move(MovementType.MOVE, 8, 4);
        assertEquals(7, testRook.getXCoordinate());
        assertEquals(3, testRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_LegalCoordinates_Left_UpdatesCoordinates() {
        chessBoard.Add(testRook, 1, 5);
        testRook.Move(MovementType.MOVE, 0, 5);
        assertEquals(0, testRook.getXCoordinate());
        assertEquals(5, testRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testRook, 7, 3);
        testRook.Move(MovementType.MOVE, 10, 3);
        assertEquals(7, testRook.getXCoordinate());
        assertEquals(3, testRook.getYCoordinate());
    }

    @Test
    public void testKnight_Move_LegalCoordinates_Up_Left_UpdatesCoordinates() {
        chessBoard.Add(testKnight, 5, 5);
        testKnight.Move(MovementType.MOVE, 7, 4);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(4, testKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(testKnight, 7, 3);
        testKnight.Move(MovementType.MOVE, 8, 5);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(3, testKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_LegalCoordinates_Right_Down_UpdatesCoordinates() {
        chessBoard.Add(testKnight, 1, 5);
        testKnight.Move(MovementType.MOVE, 2, 7);
        assertEquals(2, testKnight.getXCoordinate());
        assertEquals(7, testKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_IllegalCoordinates_Down_Left_DoesNotMove() {
        chessBoard.Add(testKnight, 7, 3);
        testKnight.Move(MovementType.MOVE, 5, 5);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(3, testKnight.getYCoordinate());
    }

    @Test
    public void testBishop_Move_LegalCoordinates_Up_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(testBishop, 5, 5);
        testBishop.Move(MovementType.MOVE, 7, 3);
        assertEquals(7, testBishop.getXCoordinate());
        assertEquals(3, testBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_IllegalCoordinates_Up_Left_Diag_DoesNotMove() {
        chessBoard.Add(testBishop, 0, 1);
        testBishop.Move(MovementType.MOVE, -1, -1);
        assertEquals(0, testBishop.getXCoordinate());
        assertEquals(1, testBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_LegalCoordinates_Right_Down_Diag_UpdatesCoordinates() {
        chessBoard.Add(testBishop, 1, 5);
        testBishop.Move(MovementType.MOVE, 2, 6);
        assertEquals(2, testBishop.getXCoordinate());
        assertEquals(6, testBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(testBishop, 4, 3);
        testBishop.Move(MovementType.MOVE, 2, 3);
        assertEquals(4, testBishop.getXCoordinate());
        assertEquals(3, testBishop.getYCoordinate());
    }

    @Test
    public void testQueen_Move_LegalCoordinates_Down_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(testQueen, 5, 5);
        testQueen.Move(MovementType.MOVE, 7, 7);
        assertEquals(7, testQueen.getXCoordinate());
        assertEquals(7, testQueen.getYCoordinate());
    }

    @Test
    public void testQueen_Move_LegalCoordinates_Down_UpdatesCoordinates() {
        chessBoard.Add(testQueen, 3, 1);
        testQueen.Move(MovementType.MOVE, 3, 7);
        assertEquals(3, testQueen.getXCoordinate());
        assertEquals(7, testQueen.getYCoordinate());
    }

    @Test
    public void testQueen_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(testQueen, 3, 1);
        testQueen.Move(MovementType.MOVE, 4, 7);
        assertEquals(3, testQueen.getXCoordinate());
        assertEquals(1, testQueen.getYCoordinate());
    }

    @Test
    public void testKing_Move_LegalCoordinates_Down_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(testKing, 1, 1);
        testKing.Move(MovementType.MOVE, 2, 2);
        assertEquals(2, testKing.getXCoordinate());
        assertEquals(2, testKing.getYCoordinate());
    }

    @Test
    public void testKing_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(testKing, 1, 1);
        testKing.Move(MovementType.MOVE, 2, 3);
        assertEquals(1, testKing.getXCoordinate());
        assertEquals(1, testKing.getYCoordinate());
    }

    @Test
    public void testKing_Move_LegalCoordinates_Right_UpdatesCoordinates() {
        chessBoard.Add(testKing, 1, 1);
        testKing.Move(MovementType.MOVE, 2, 1);
        assertEquals(2, testKing.getXCoordinate());
        assertEquals(1, testKing.getYCoordinate());
    }
}
