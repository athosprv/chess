package com.logicnow.hiring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChestPieceTest {

    private ChessBoard chessBoard;
    private ChestPiece testPawn, testKnight;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testPawn = new ChestPiece(chessBoard, PieceColor.BLACK, PieceType.PAWN);
        this.testKnight = new ChestPiece(chessBoard, PieceColor.BLACK, PieceType.KNIGHT);
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
        testPawn.Move(MovementType.MOVE, 4, 3);
        assertEquals(6, testPawn.getXCoordinate());
        assertEquals(3, testPawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.Add(testPawn, 6, 3);
        testPawn.Move(MovementType.MOVE, 6, 2);
        assertEquals(6, testPawn.getXCoordinate());
        assertEquals(2, testPawn.getYCoordinate());
    }

    @Test
    public void testKnight_Move_LegalCoordinates_Forward_UpdatesCoordinates() {
        chessBoard.Add(testKnight, 7, 5);
        testKnight.Move(MovementType.MOVE, 7, 2);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(2, testKnight.getYCoordinate());
    }
    
    @Test
    public void testKnight_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(testKnight, 7, 3);
        testKnight.Move(MovementType.MOVE, 8, 4);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(3, testKnight.getYCoordinate());
    }    


    @Test
    public void testKnight_Move_LegalCoordinates_RIGHT_UpdatesCoordinates() {
        chessBoard.Add(testKnight, 1, 5);
        testKnight.Move(MovementType.MOVE, 4, 5);
        assertEquals(4, testKnight.getXCoordinate());
        assertEquals(5, testKnight.getYCoordinate());
    }
    
    @Test
    public void testKnight_Move_IllegalCoordinates_LEFT_DoesNotMove() {
        chessBoard.Add(testKnight, 7, 3);
        testKnight.Move(MovementType.MOVE, 10, 3);
        assertEquals(7, testKnight.getXCoordinate());
        assertEquals(3, testKnight.getYCoordinate());
    }        

}
