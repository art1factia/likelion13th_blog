package likelion13th.blog.service;

import likelion13th.blog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {
    private final List<Article> articleDB = new ArrayList<>(); //데이터를 저장할 임시DB
    private  Long nextId = 1L; //고유번호 업데이트
    public Article addArticle(Article article){

        if (article.getAuthor() == null
                || article.getPassword() == null
                || article.getTitle() == null
                || article.getContent() == null
        ) {
            throw new IllegalArgumentException("제목, 내용, 작성자, 비밀번호는 필수 입력 항목입니다.");
        }
        //Article 객체 생성
        Article newArticle = new Article(
                article.getContent(),
                nextId++,
                article.getTitle(),
                article.getAuthor(),
                article.getPassword()
        );

        //DB에 객체 저장
        articleDB.add(newArticle);

        return newArticle;

    }

    public List<Article> findAll() {
        return articleDB;
    }

    public Article findById(long id) {
        for (Article article : articleDB) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        throw new NoSuchElementException("해당 id 게시물을 찾을 수 없습니다");
    }
}
