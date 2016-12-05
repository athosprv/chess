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
public class CollisionTest {

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
    public void testPawn_Move_And_Check_For_Collisions() {
        chessBoard.Add(whitePawn, 3, 3);
        chessBoard.Add(blackPawn, 3, 4);
        whitePawn.Move(MovementType.MOVE, 3, 4);
        blackPawn.Move(MovementType.MOVE, 3, 3);
        assertEquals(whitePawn, chessBoard.Retrieve(3, 3));
        assertEquals(blackPawn, chessBoard.Retrieve(3, 4));
    }

    @Test
    public void testBishop_Move_And_Check_For_Collisions() {
        chessBoard.Add(blackBishop, 3, 3);
        chessBoard.Add(whiteKnight, 1, 1);
        chessBoard.Add(whiteKing, 5, 1);
        chessBoard.Add(whitePawn, 5, 5);
        chessBoard.Add(blackPawn, 1, 5);
        assertEquals(blackBishop, chessBoard.Retrieve(3, 3));
        blackBishop.Move(MovementType.MOVE, 0, 0);
        assertEquals(blackBishop, chessBoard.Retrieve(3, 3));
        blackBishop.Move(MovementType.MOVE, 6, 0);
        assertEquals(blackBishop, chessBoard.Retrieve(3, 3));
        blackBishop.Move(MovementType.MOVE, 0, 6);
        assertEquals(blackBishop, chessBoard.Retrieve(3, 3));
        blackBishop.Move(MovementType.MOVE, 6, 6);
        assertEquals(blackBishop, chessBoard.Retrieve(3, 3));
        blackBishop.Move(MovementType.MOVE, 4, 4);
        assertEquals(blackBishop, chessBoard.Retrieve(4, 4));
    }

    @Test
    public void testKnight_Move_And_Check_For_Collisions() {
        chessBoard.Add(whiteKnight, 3, 3);
        chessBoard.Add(blackRook, 4, 1);
        chessBoard.Add(whiteKing, 5, 4);
        chessBoard.Add(whitePawn, 1, 4);
        chessBoard.Add(blackPawn, 2, 1);
        assertEquals(whiteKnight, chessBoard.Retrieve(3, 3));
        whiteKnight.Move(MovementType.MOVE, 4, 1);
        assertEquals(whiteKnight, chessBoard.Retrieve(3, 3));
        whiteKnight.Move(MovementType.MOVE, 5, 4);
        assertEquals(whiteKnight, chessBoard.Retrieve(3, 3));
        whiteKnight.Move(MovementType.MOVE, 1, 4);
        assertEquals(whiteKnight, chessBoard.Retrieve(3, 3));
        whiteKnight.Move(MovementType.MOVE, 2, 1);
        assertEquals(whiteKnight, chessBoard.Retrieve(3, 3));
        whiteKnight.Move(MovementType.MOVE, 2, 5);
        assertEquals(whiteKnight, chessBoard.Retrieve(2, 5));
    }

    @Test
    public void testRook_Move_And_Check_For_Collisions() {
        chessBoard.Add(blackRook, 3, 3);
        chessBoard.Add(whiteKnight, 1, 3);
        chessBoard.Add(whiteKing, 5, 3);
        chessBoard.Add(whitePawn, 3, 1);
        chessBoard.Add(blackPawn, 3, 6);
        assertEquals(blackRook, chessBoard.Retrieve(3, 3));
        blackRook.Move(MovementType.MOVE, 0, 3);
        assertEquals(blackRook, chessBoard.Retrieve(3, 3));
        blackRook.Move(MovementType.MOVE, 6, 3);
        assertEquals(blackRook, chessBoard.Retrieve(3, 3));
        blackRook.Move(MovementType.MOVE, 3, 0);
        assertEquals(blackRook, chessBoard.Retrieve(3, 3));
        blackRook.Move(MovementType.MOVE, 3, 7);
        assertEquals(blackRook, chessBoard.Retrieve(3, 3));
        blackRook.Move(MovementType.MOVE, 3, 5);
        assertEquals(blackRook, chessBoard.Retrieve(3, 5));
    }

    @Test
    public void testKing_Move_And_Check_For_Collisions() {
        chessBoard.Add(whiteKing, 3, 3);
        chessBoard.Add(whiteKnight, 3, 2);
        chessBoard.Add(whitePawn, 2, 2);
        chessBoard.Add(whitePawn, 2, 3);
        chessBoard.Add(blackPawn, 2, 4);
        chessBoard.Add(blackPawn, 3, 4);
        chessBoard.Add(blackPawn, 4, 4);
        chessBoard.Add(blackPawn, 4, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 3, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 2, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 2, 3);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 2, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 3, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 4, 4);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 4, 2);
        assertEquals(whiteKing, chessBoard.Retrieve(3, 3));
        whiteKing.Move(MovementType.MOVE, 4, 3);
        assertEquals(whiteKing, chessBoard.Retrieve(4, 3));
    }

    @Test
    public void testQueen_Move_And_Check_For_Collisions() {
        // As Queen is a combination of Rook and Bishop, It is already Tested.     
    }

}
