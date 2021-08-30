package API;

import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {
    @POST("/1/boards")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);
    @GET("/1/boards/{id}")
    Call<Board> getBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
    @POST("/1/lists")
    Call<List> createList(@Body List list, @Query("name") String name, @Query("idBoard") String idBoard);
    @GET("/1/lists/{id}")
    Call<List> getList(@Body List list, @Path("id") String id);
    @DELETE("/1/boards/{id}")
    Call<Board> rmBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
    @PUT("/1/boards/{id}")
    Call<Board> updateBoard(@Body Board board, @Path("id") String id, @Query("name") String name);
    @POST("/1/lists/{id}/archiveAllCards")
    Call<List> acList(@Path("id") String id, @Query("key") String key, @Query("token") String token);
}
