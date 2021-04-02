package io.pragra.learning.jpalearning.repo;

import io.pragra.learning.jpalearning.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
    List<Blog> findAllByCategory(String category);

    @Query("select b from Blog b where length(b.blogText) >20")
    List<Blog> findAllByWithMoreThan20();

    @Query("SELECT COUNT(b) from Blog b")
    Integer getCountOfALL();

    @Query(value = "SELECT * FROM BLOG", nativeQuery = true)
    Integer getByNative();

    @Query(value = "SELECT B.* FROM BLOG B, TABLE_USER U WHERE B.USER_ID = U.ID AND U.NAME = :name", nativeQuery =true)
    List<Blog> getALlforUserName(@Param("name") String name);


}
