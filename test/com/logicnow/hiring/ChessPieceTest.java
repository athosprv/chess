package com.logicnow.hiring;

import com.logicnow.hiring.Enum.PieceType;
import com.logicnow.hiring.Enum.PieceColor;
import com.logicnow.hiring.Movement.MovementType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessPieceTest {

    private ChessBoard chessBoard;
    private ChessPiece whitePawn, blackPawn, blackRook, whiteKnight, blackBishop, whiteQueen, whiteKing;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.whitePawn = new ChessPiece(chessBoard, PieceColor.WHITE, PieceType.PAWN);
        this.blackPawn = new ChessPiece(chessBoard, PieceColor.BLACK, PieceType.PAWN);
        this.blackRook = new ChessPiece(chessBoard, PieceColor.BLACK, PieceType.ROOK);
        this.whiteKnight = new ChessPiece(chessBoard, PieceColor.WHITE, PieceType.KNIGHT);
        this.blackBishop = new ChessPiece(chessBoard, PieceColor.BLACK, PieceType.BISHOP);
        this.whiteQueen = new ChessPiece(chessBoard, PieceColor.WHITE, PieceType.QUEEN);
        this.whiteKing = new ChessPiece(chessBoard, PieceColor.WHITE, PieceType.KING);
    }

    @Test
    public void testChessBoard_Add_Sets_XCoordinate() {
        this.chessBoard.Add(whitePawn, 6, 3);
        assertEquals(6, whitePawn.getXCoordinate());
    }

    @Test
    public void testChessBoard_Add_Sets_YCoordinate() {
        this.chessBoard.Add(whitePawn, 6, 3);
        assertEquals(3, whitePawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(whitePawn, 7, 3);
        whitePawn.Move(MovementType.MOVE, 8, 3);
        assertEquals(7, whitePawn.getXCoordinate());
        assertEquals(3, whitePawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(whitePawn, 6, 3);
        whitePawn.Move(MovementType.MOVE, 6, 5);
        assertEquals(6, whitePawn.getXCoordinate());
        assertEquals(3, whitePawn.getYCoordinate());
    }

    @Test
    public void testPawn_Move_LegalCoordinates_Up_UpdatesCoordinates() {
        chessBoard.Add(blackPawn, 4, 4);
        blackPawn.Move(MovementType.MOVE, 4, 3);
        assertEquals(4, blackPawn.getXCoordinate());
        assertEquals(3, blackPawn.getYCoordinate());

    }

    @Test
    public void testPawn_Move_IllegalCoordinates_Down_DoesNotMove() {
        chessBoard.Add(whitePawn, 6, 3);
        whitePawn.Move(MovementType.MOVE, 6, 4);
        assertEquals(6, whitePawn.getXCoordinate());
        assertEquals(4, whitePawn.getYCoordinate());
    }

    @Test
    public void testRook_Move_LegalCoordinates_Down_UpdatesCoordinates() {
        chessBoard.Add(blackRook, 7, 5);
        blackRook.Move(MovementType.MOVE, 7, 7);
        assertEquals(7, blackRook.getXCoordinate());
        assertEquals(7, blackRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_IllegalCoordinates_Right_DoesNotMove() {
        chessBoard.Add(blackRook, 7, 3);
        blackRook.Move(MovementType.MOVE, 8, 4);
        assertEquals(7, blackRook.getXCoordinate());
        assertEquals(3, blackRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_LegalCoordinates_Left_UpdatesCoordinates() {
        chessBoard.Add(blackRook, 1, 5);
        blackRook.Move(MovementType.MOVE, 0, 5);
        assertEquals(0, blackRook.getXCoordinate());
        assertEquals(5, blackRook.getYCoordinate());
    }

    @Test
    public void testRook_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(blackRook, 7, 3);
        blackRook.Move(MovementType.MOVE, 10, 3);
        assertEquals(7, blackRook.getXCoordinate());
        assertEquals(3, blackRook.getYCoordinate());
    }

    @Test
    public void testKnight_Move_LegalCoordinates_Up_Left_UpdatesCoordinates() {
        chessBoard.Add(whiteKnight, 5, 5);
        whiteKnight.Move(MovementType.MOVE, 7, 4);
        assertEquals(7, whiteKnight.getXCoordinate());
        assertEquals(4, whiteKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(whiteKnight, 7, 3);
        whiteKnight.Move(MovementType.MOVE, 8, 5);
        assertEquals(7, whiteKnight.getXCoordinate());
        assertEquals(3, whiteKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_LegalCoordinates_Right_Down_UpdatesCoordinates() {
        chessBoard.Add(whiteKnight, 1, 5);
        whiteKnight.Move(MovementType.MOVE, 2, 7);
        assertEquals(2, whiteKnight.getXCoordinate());
        assertEquals(7, whiteKnight.getYCoordinate());
    }

    @Test
    public void testKnight_Move_IllegalCoordinates_Down_Left_DoesNotMove() {
        chessBoard.Add(whiteKnight, 7, 3);
        whiteKnight.Move(MovementType.MOVE, 5, 5);
        assertEquals(7, whiteKnight.getXCoordinate());
        assertEquals(3, whiteKnight.getYCoordinate());
    }

    @Test
    public void testBishop_Move_LegalCoordinates_Up_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(blackBishop, 5, 5);
        blackBishop.Move(MovementType.MOVE, 7, 3);
        assertEquals(7, blackBishop.getXCoordinate());
        assertEquals(3, blackBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_IllegalCoordinates_Up_Left_Diag_DoesNotMove() {
        chessBoard.Add(blackBishop, 0, 1);
        blackBishop.Move(MovementType.MOVE, -1, -1);
        assertEquals(0, blackBishop.getXCoordinate());
        assertEquals(1, blackBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_LegalCoordinates_Right_Down_Diag_UpdatesCoordinates() {
        chessBoard.Add(blackBishop, 1, 5);
        blackBishop.Move(MovementType.MOVE, 2, 6);
        assertEquals(2, blackBishop.getXCoordinate());
        assertEquals(6, blackBishop.getYCoordinate());
    }

    @Test
    public void testBishop_Move_IllegalCoordinates_Left_DoesNotMove() {
        chessBoard.Add(blackBishop, 4, 3);
        blackBishop.Move(MovementType.MOVE, 2, 3);
        assertEquals(4, blackBishop.getXCoordinate());
        assertEquals(3, blackBishop.getYCoordinate());
    }

    @Test
    public void testQueen_Move_LegalCoordinates_Down_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(whiteQueen, 5, 5);
        whiteQueen.Move(MovementType.MOVE, 7, 7);
        assertEquals(7, whiteQueen.getXCoordinate());
        assertEquals(7, whiteQueen.getYCoordinate());
    }

    @Test
    public void testQueen_Move_LegalCoordinates_Down_UpdatesCoordinates() {
        chessBoard.Add(whiteQueen, 3, 1);
        whiteQueen.Move(MovementType.MOVE, 3, 7);
        assertEquals(3, whiteQueen.getXCoordinate());
        assertEquals(7, whiteQueen.getYCoordinate());
    }

    @Test
    public void testQueen_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(whiteQueen, 3, 1);
        whiteQueen.Move(MovementType.MOVE, 4, 7);
        assertEquals(3, whiteQueen.getXCoordinate());
        assertEquals(1, whiteQueen.getYCoordinate());
    }

    @Test
    public void testKing_Move_LegalCoordinates_Down_Right_Diag_UpdatesCoordinates() {
        chessBoard.Add(whiteKing, 1, 1);
        whiteKing.Move(MovementType.MOVE, 2, 2);
        assertEquals(2, whiteKing.getXCoordinate());
        assertEquals(2, whiteKing.getYCoordinate());
    }

    @Test
    public void testKing_Move_IllegalCoordinates_Down_Right_DoesNotMove() {
        chessBoard.Add(whiteKing, 1, 1);
        whiteKing.Move(MovementType.MOVE, 2, 3);
        assertEquals(1, whiteKing.getXCoordinate());
        assertEquals(1, whiteKing.getYCoordinate());
    }

    @Test
    public void testKing_Move_LegalCoordinates_Right_UpdatesCoordinates() {
        chessBoard.Add(whiteKing, 1, 1);
        whiteKing.Move(MovementType.MOVE, 2, 1);
        assertEquals(2, whiteKing.getXCoordinate());
        assertEquals(1, whiteKing.getYCoordinate());
    }


}
