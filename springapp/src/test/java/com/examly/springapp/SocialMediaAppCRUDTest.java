package com.examly.springapp;

import com.examly.springapp.model.*;
import com.examly.springapp.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest
public class SocialMediaAppCRUDTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private PostService postService;

    @MockBean
    private CommentService commentService;

    @MockBean
    private LikeService likeService;

    // ----------- USER CRUD TESTS -----------

    @Test
    public void CRUD_test_Get_All_Users() throws Exception {
        User user1 = new User(1L, "John Doe", "john@example.com", "password123", null, null, null, null);
        User user2 = new User(2L, "Jane Smith", "jane@example.com", "password456", null, null, null, null);
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));
    }

    @Test
    public void CRUD_test_Create_User() throws Exception {
        User user = new User(1L, "Alice", "alice@example.com", "pass789", null, null, null, null);
        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"password\":\"pass789\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void CRUD_test_Update_User() throws Exception {
        User updatedUser = new User(1L, "Alice Updated", "alice@example.com", "pass789", null, null, null, null);
        when(userService.updateUser(eq(1L), any(User.class))).thenReturn(updatedUser);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Alice Updated\",\"email\":\"alice@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Updated"));
    }

    @Test
    public void CRUD_test_Delete_User() throws Exception {
        doNothing().when(userService).deleteUser(1L);
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }

    // ----------- POST CRUD TESTS -----------

    @Test
    public void CRUD_test_Get_All_Posts() throws Exception {
        Post post1 = new Post(1L, "First post!", "image1.jpg", "2024-02-20", 1L);
        Post post2 = new Post(2L, "Second post!", "image2.jpg", "2024-02-21", 1L);
        when(postService.getAllPosts()).thenReturn(Arrays.asList(post1, post2));

        mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content").value("First post!"))
                .andExpect(jsonPath("$[1].content").value("Second post!"));
    }

    @Test
    public void CRUD_test_Create_Post() throws Exception {
        Post post = new Post(1L, "New Post", "image.jpg", "2024-02-22", 1L);
        when(postService.createPost(any(Post.class))).thenReturn(post);

        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\"New Post\",\"imageUrl\":\"image.jpg\",\"userId\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("New Post"));
    }

    @Test
    public void CRUD_test_Update_Post() throws Exception {
        Post updatedPost = new Post(1L, "Updated Post", "image.jpg", "2024-02-22", 1L);
        when(postService.updatePost(eq(1L), any(Post.class))).thenReturn(updatedPost);

        mockMvc.perform(put("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\"Updated Post\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Updated Post"));
    }

    @Test
    public void CRUD_test_Delete_Post() throws Exception {
        doNothing().when(postService).deletePost(1L);
        mockMvc.perform(delete("/api/posts/1"))
                .andExpect(status().isOk());
    }

    // ----------- COMMENT CRUD TESTS -----------

    // @Test
    // public void CRUD_test_Get_All_Comments() throws Exception {
    //     Comment comment1 = new Comment(1L, "Nice post!", "2024-02-22", 1L, 1L);
    //     Comment comment2 = new Comment(2L, "Interesting!", "2024-02-23", 2L, 1L);
    //     when(commentService.getAllComments()).thenReturn(Arrays.asList(comment1, comment2));

    //     mockMvc.perform(get("/api/comments"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$[0].content").value("Nice post!"))
    //             .andExpect(jsonPath("$[1].content").value("Interesting!"));
    // }

    // @Test
    // public void CRUD_test_Create_Comment() throws Exception {
    //     Comment comment = new Comment(1L, "Great post!", "2024-02-24", 1L, 1L);
    //     when(commentService.createComment(any(Comment.class))).thenReturn(comment);

    //     mockMvc.perform(post("/api/comments")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content("{\"content\":\"Great post!\",\"userId\":1,\"postId\":1}"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.content").value("Great post!"));
    // }

    // @Test
    // public void CRUD_test_Update_Comment() throws Exception {
    //     Comment updatedComment = new Comment(1L, "Updated Comment!", "2024-02-24", 1L, 1L);
    //     when(commentService.updateComment(eq(1L), any(Comment.class))).thenReturn(updatedComment);

    //     mockMvc.perform(put("/api/comments/1")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content("{\"content\":\"Updated Comment!\"}"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.content").value("Updated Comment!"));
    // }

    // @Test
    // public void CRUD_test_Delete_Comment() throws Exception {
    //     doNothing().when(commentService).deleteComment(1L);
    //     mockMvc.perform(delete("/api/comments/1"))
    //             .andExpect(status().isOk());
    // }

    // // ----------- LIKE CRUD TESTS -----------

    // @Test
    // public void CRUD_test_Get_All_Likes() throws Exception {
    //     Like like1 = new Like(1L, 1L, 1L, "2024-02-25");
    //     Like like2 = new Like(2L, 2L, 1L, "2024-02-25");
    //     when(likeService.getAllLikes()).thenReturn(Arrays.asList(like1, like2));

    //     mockMvc.perform(get("/api/likes"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$[0].userId").value(1))
    //             .andExpect(jsonPath("$[1].userId").value(2));
    // }

    // @Test
    // public void CRUD_test_Create_Like() throws Exception {
    //     Like like = new Like(1L, 1L, 1L, "2024-02-25");
    //     when(likeService.createLike(any(Like.class))).thenReturn(like);

    //     mockMvc.perform(post("/api/likes")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content("{\"userId\":1,\"postId\":1}"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.userId").value(1));
    // }

    // @Test
    // public void CRUD_test_Delete_Like() throws Exception {
    //     doNothing().when(likeService).deleteLike(1L);
    //     mockMvc.perform(delete("/api/likes/1"))
    //             .andExpect(status().isOk());
    // }
}
