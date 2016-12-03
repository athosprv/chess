package com.logicnow.hiring;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends TestCase {

    private ChessBoard testChessBoard;

    @Before
    @Override
    public void setUp() throws Exception {
        testChessBoard = new ChessBoard();
    }

    @Test
    public void testHas_MaxBoardWidth_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_8() {
        assertEquals(8, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(0, 0);
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(5, 5);
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(11, 5);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(0, 9);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(11, 0);
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testChessBoard.IsLegalBoardPosition(5, -1);
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testAvoids_Duplicate_Positioning() {
        ChestPiece firstPawn = new ChestPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChestPiece secondPawn = new ChestPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChestPiece thirdPawn = new ChestPiece(testChessBoard, PieceColor.WHITE, PieceType.PAWN);
        testChessBoard.Add(firstPawn, 6, 3);
        testChessBoard.Add(secondPawn, 6, 3);
        assertEquals(6, firstPawn.getXCoordinate());
        assertEquals(3, firstPawn.getYCoordinate());
        assertEquals(-1, secondPawn.getXCoordinate());
        assertEquals(-1, secondPawn.getYCoordinate());
        testChessBoard.Add(thirdPawn, 6, 3);
        assertEquals(6, thirdPawn.getXCoordinate());
        assertEquals(3, thirdPawn.getYCoordinate());
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        for (int i = 0; i < 10; i++) {
            ChestPiece pawn = new ChestPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            testChessBoard.Add(pawn, 7 + row, i % ChessBoard.MAX_BOARD_WIDTH);
            if (row < 1) {
                assertEquals(7 + row, pawn.getXCoordinate());
                assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, pawn.getYCoordinate());
            } else {
                assertEquals(-1, pawn.getXCoordinate());
                Assert.assertEquals(-1, pawn.getYCoordinate());
            }
        }

    }

    @Test
    public void testsUpdate_ChessBoard_WithCHestPiece_Movement() {
        ChestPiece pawn = new ChestPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChestPiece bishop = new ChestPiece(testChessBoard, PieceColor.WHITE, PieceType.BISHOP);
        testChessBoard.Add(pawn, 4, 5);
        pawn.Move(MovementType.MOVE, 4, 6);
        assertEquals(testChessBoard.Retrieve(4, 5), null);
        assertEquals(testChessBoard.Retrieve(4, 6), pawn);
        pawn.Move(MovementType.MOVE, 2, 6);
        assertEquals(testChessBoard.Retrieve(2, 6), null);
        assertEquals(testChessBoard.Retrieve(4, 6), pawn);
        testChessBoard.Add(bishop, 4, 5);
        bishop.Move(MovementType.MOVE, 4, 5);
        bishop.Move(MovementType.MOVE, 5, 6);
        assertEquals(testChessBoard.Retrieve(4, 5), null);
        assertEquals(testChessBoard.Retrieve(5, 6), bishop);
    }
}
