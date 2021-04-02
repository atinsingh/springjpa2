package io.pragra.learning.jpalearning;

import io.pragra.learning.jpalearning.entity.Blog;
import io.pragra.learning.jpalearning.entity.User;
import io.pragra.learning.jpalearning.repo.BlogRepo;
import io.pragra.learning.jpalearning.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.Instant;
import java.util.Scanner;

@SpringBootApplication
public class JpaLearningApplication {

    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(JpaLearningApplication.class, args);
        UserService service = context.getBean(UserService.class);

        service.addUser(User.builder().id(1L).name("PRAKASH M").createDateTime(Instant.ofEpochSecond(220392023)).build());
        service.addUser(User.builder().id(2L).name("Naveleen").build());


        BlogRepo repo = context.getBean(BlogRepo.class);
        Blog blog = Blog.builder().userId(2L).category("JAVA").blogText(
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Tempora ipsa delectus consequuntur unde dicta accusamus saepe nisi, odio earum provident minima voluptas hic magnam blanditiis, neque facere vero molestias molestiae."
        ).build();
        blog = repo.save(blog);

        System.out.println(blog);

        blog.setCategory("DevOps");
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Execute Update");
        //scanner.next();
        repo.save(blog);

        repo.save(Blog.builder().blogText("ajksjdjd").category("JAVA").build());
        repo.save(Blog.builder().blogText("oikdjd").category("JAVA").build());
        repo.save(Blog.builder().blogText("kjdj").category("JAVA").build());
        repo.save(Blog.builder().blogText("Learning JPA is more fun than JDBC").userId(2L).category("JAVA").build());

        System.out.println(repo.findAllByCategory("JAVA"));

        System.out.println(repo.findAllByWithMoreThan20());
        System.out.println("ALL COUNT " + repo.getCountOfALL());
        System.out.println("NATIVE COUNT " + repo.getCountOfALL());


     System.out.println(repo.getALlforUserName("Naveleen"));





    }

}
