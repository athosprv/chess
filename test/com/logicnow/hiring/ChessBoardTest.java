package com.logicnow.hiring;


import com.logicnow.hiring.Enum.PieceColor;
import com.logicnow.hiring.Enum.PieceType;
import com.logicnow.hiring.Movement.MovementType;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessBoardTest extends TestCase {

    private ChessBoard testChessBoard;

    @Before
    @Override
    public void setUp() throws Exception {
        this.testChessBoard = new ChessBoard();
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
        ChessPiece firstPawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChessPiece secondPawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        testChessBoard.Add(firstPawn, 6, 3);
        testChessBoard.Add(secondPawn, 6, 3);
        assertEquals(6, firstPawn.getXCoordinate());
        assertEquals(3, firstPawn.getYCoordinate());
        assertEquals(-1, secondPawn.getXCoordinate());
        assertEquals(-1, secondPawn.getYCoordinate());
    }

    @Test
    public void testLimits_The_Number_Of_Pawns() {
        for (int i = 0; i < 10; i++) {
            ChessPiece pawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
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
        ChessPiece whitePawn = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.PAWN);
        ChessPiece blackPawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChessPiece bishop = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.BISHOP);        
        testChessBoard.Add(whitePawn, 5, 0);
        testChessBoard.Add(blackPawn, 4, 5);        
        blackPawn.Move(MovementType.MOVE, 4, 6);
        assertEquals(testChessBoard.Retrieve(4, 5), blackPawn);
        assertEquals(testChessBoard.Retrieve(4, 6), null);        
        blackPawn.Move(MovementType.MOVE, 2, 6);
        assertEquals(testChessBoard.Retrieve(2, 6), null);
        assertEquals(testChessBoard.Retrieve(4, 5), blackPawn);
        testChessBoard.Add(bishop, 5, 6);
        bishop.Move(MovementType.MOVE, 5, 6);
        bishop.Move(MovementType.MOVE, 6, 7);
        assertEquals(testChessBoard.Retrieve(5, 6), null);
        assertEquals(testChessBoard.Retrieve(6, 7), bishop);
        
    }

    @Test
    public void testUpdate_ChessBoard_With_Chestpiece_Collisions() {
        ChessPiece blackPawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChessPiece whitePawn = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.PAWN);
        ChessPiece king = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.KING);
        ChessPiece bishop = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.BISHOP);
        ChessPiece queen = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.QUEEN);
        testChessBoard.Add(whitePawn, 3, 3);
        testChessBoard.Add(blackPawn, 3, 5);
        whitePawn.Move(MovementType.MOVE, 3, 4);
        assertEquals(testChessBoard.Retrieve(3, 4), whitePawn);
        whitePawn.Move(MovementType.MOVE, 3, 4);
        assertEquals(testChessBoard.Retrieve(3, 4), whitePawn);
        blackPawn.Move(MovementType.MOVE, 3, 3);
        assertEquals(testChessBoard.Retrieve(3,5), blackPawn);
        testChessBoard.Add(king, 3, 6);
        king.Move(MovementType.MOVE, 2, 5);
        assertEquals(testChessBoard.Retrieve(2, 5), king);
        king.Move(MovementType.MOVE, 1, 6);
        assertEquals(testChessBoard.Retrieve(1, 6), king);
        testChessBoard.Add(bishop, 6, 7);
        bishop.Move(MovementType.MOVE, 2, 3);
        assertEquals(testChessBoard.Retrieve(6, 7), bishop);
        testChessBoard.Add(queen, 3, 7);
        queen.Move(MovementType.MOVE, 3, 2);
        assertEquals(testChessBoard.Retrieve(3, 7), queen);
        queen.Move(MovementType.MOVE, 7, 7);
        assertEquals(testChessBoard.Retrieve(3, 7), queen);
        queen.Move(MovementType.MOVE, 5, 7);
        assertEquals(testChessBoard.Retrieve(5, 7), queen);
    }

    @Test
    public void testUpdate_ChessBoard_With_Chestpiece_Capture() {
        ChessPiece blackPawn = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChessPiece blackPawn2 = new ChessPiece(testChessBoard, PieceColor.BLACK, PieceType.PAWN);
        ChessPiece whitePawn = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.PAWN);
        ChessPiece queen = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.QUEEN);
        ChessPiece knight = new ChessPiece(testChessBoard, PieceColor.WHITE, PieceType.KNIGHT);
        testChessBoard.Add(blackPawn, 0, 0);
        testChessBoard.Add(blackPawn2, 1, 0);
        testChessBoard.Add(whitePawn, 7, 0);
        testChessBoard.Add(queen, 1, 7);
        queen.Move(MovementType.CAPTURE, 1, 0);
        assertEquals(testChessBoard.Retrieve(1, 0), queen);
        queen.Move(MovementType.CAPTURE, 0, 0);
        assertEquals(testChessBoard.Retrieve(0, 0), queen);
        queen.Move(MovementType.CAPTURE, 7, 0);
        assertEquals(testChessBoard.Retrieve(0, 0), queen);
        testChessBoard.Add(blackPawn2, 1, 0);
        testChessBoard.Add(whitePawn, 7, 0);
        testChessBoard.Add(knight, 2, 2);
        knight.Move(MovementType.MOVE, 1, 0);
        assertEquals(testChessBoard.Retrieve(2, 2), knight);
        knight.Move(MovementType.MOVE, 0, 1);
        assertEquals(testChessBoard.Retrieve(0, 1), knight);
        
    }
}
