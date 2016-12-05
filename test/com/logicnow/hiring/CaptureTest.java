/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicnow.hiring;

import com.logicnow.hiring.Enum.PieceColor;
import com.logicnow.hiring.Enum.PieceType;
import com.logicnow.hiring.Movement.MovementType;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author georgia
 */
public class CaptureTest {

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
    public void testPawn_Capture() {
        chessBoard.Add(whitePawn, 2, 3);
        chessBoard.Add(whitePawn, 3, 2);
        chessBoard.Add(blackPawn, 3, 4);
        blackPawn.Move(MovementType.CAPTURE, 2, 3);
        assertEquals(blackPawn, chessBoard.Retrieve(2, 3));
        blackPawn.Move(MovementType.CAPTURE, 3, 2);
        assertEquals(blackPawn, chessBoard.Retrieve(3, 2));
    }

    @Test
    public void testBishop_Capture() {
        chessBoard.Add(whitePawn, 1, 5);
        chessBoard.Add(whitePawn, 5, 1);
        chessBoard.Add(blackBishop, 3, 3);
        blackBishop.Move(MovementType.CAPTURE, 1, 5);
        assertEquals(blackBishop, chessBoard.Retrieve(1, 5));
        blackBishop.Move(MovementType.CAPTURE, 5, 1);
        assertEquals(blackBishop, chessBoard.Retrieve(5, 1));
    }

    @Test
    public void testKnight_Capture() {
        chessBoard.Add(blackPawn, 4, 1);
        chessBoard.Add(blackPawn, 2, 0);
        chessBoard.Add(whiteKnight, 3, 3);
        whiteKnight.Move(MovementType.CAPTURE, 4, 1);
        assertEquals(whiteKnight, chessBoard.Retrieve(4, 1));
        whiteKnight.Move(MovementType.CAPTURE, 2, 0);
        assertEquals(whiteKnight, chessBoard.Retrieve(2, 0));
    }

    @Test
    public void testRook_Capture() {
        chessBoard.Add(whitePawn, 0, 2);
        chessBoard.Add(whitePawn, 0, 7);
        chessBoard.Add(blackRook, 3, 2);
        blackRook.Move(MovementType.CAPTURE, 0, 2);
        assertEquals(blackRook, chessBoard.Retrieve(0, 2));
        blackRook.Move(MovementType.CAPTURE, 0, 7);
        assertEquals(blackRook, chessBoard.Retrieve(0, 7));
    }

    @Test
    public void testQueen_Capture() {
        chessBoard.Add(blackPawn, 0, 3);
        chessBoard.Add(blackPawn, 0, 0);
        chessBoard.Add(blackPawn, 7, 7);
        chessBoard.Add(whiteQueen, 3, 3);
        whiteQueen.Move(MovementType.CAPTURE, 0, 3);
        assertEquals(whiteQueen, chessBoard.Retrieve(0, 3));
        whiteQueen.Move(MovementType.CAPTURE, 0, 0);
        assertEquals(whiteQueen, chessBoard.Retrieve(0, 0));
        whiteQueen.Move(MovementType.CAPTURE, 7, 7);
        assertEquals(whiteQueen, chessBoard.Retrieve(7, 7));
    }

    @Test
    public void testKing_Capture() {
        chessBoard.Add(whiteKing, 3, 3);
        chessBoard.Add(blackPawn, 3, 2);
        chessBoard.Add(blackPawn, 2, 2);
        chessBoard.Add(blackPawn, 2, 3);
        chessBoard.Add(blackPawn, 2, 4);
        chessBoard.Add(blackPawn, 3, 4);
        chessBoard.Add(blackPawn, 4, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.CAPTURE, 3, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 2));
        whiteKing.Move(MovementType.CAPTURE, 2, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(2, 2));
        whiteKing.Move(MovementType.CAPTURE, 2, 3);
        assertEquals(whiteKing, chessBoard.Retrieve(2, 3));
        whiteKing.Move(MovementType.CAPTURE, 2, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(2, 4));
        whiteKing.Move(MovementType.CAPTURE, 3, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 4));
        whiteKing.Move(MovementType.CAPTURE, 4, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(4, 4));
    }
}
