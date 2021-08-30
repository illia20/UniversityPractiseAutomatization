import API.Board;
import API.List;
import API.RetrofitBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrelloApiTests {
    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

    List list = new List();
    String boardName = "Test Board";
    String upBoardName = "Updated";
    String listName = "Test list";
    String boardId;
    Board board = new Board();
    String listId;

    @BeforeClass
    public void setup() throws IOException {
        Board createdBoard = retrofitBuilder.getTrelloApi().createBoard(board, boardName).execute().body();
        boardId = createdBoard.getId();
        List createdList = retrofitBuilder.getTrelloApi().createList(list, listName, boardId).execute().body();
        listId = createdList.getId();
    }

    @Test
    public void checkGetBoard() throws IOException{
        int boardresponse = retrofitBuilder.getTrelloApi().getBoard(boardId, board.getKey(), board.getToken()).execute().code();
        Assert.assertEquals(boardresponse, 200);
    }

    @Test
    public void checkUpdateBoardName() throws IOException {
        Board up = retrofitBuilder.getTrelloApi().updateBoard(board, boardId, upBoardName).execute().body();
        Assert.assertEquals(up.getName(), upBoardName);
    }

    @Test
    public void archiveCardsInList() throws IOException {
        int r = retrofitBuilder.getTrelloApi().acList(listId, list.getKey(), list.getToken()).execute().code();
        Assert.assertEquals(r, 200);
    }

    @AfterClass
    public void clear() throws IOException {
        int r = retrofitBuilder.getTrelloApi().rmBoard(boardId, board.getKey(), board.getToken()).execute().code();
    }
}
