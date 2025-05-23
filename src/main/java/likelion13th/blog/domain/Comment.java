package likelion13th.blog.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Article article;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;

    public Comment(Long id, String author, String password, Article article, String content){
        this.id = id;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }






}
