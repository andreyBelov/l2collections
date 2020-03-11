package com.example.l2cachecollections;

import com.example.l2cachecollections.entity.Child;
import com.example.l2cachecollections.entity.Parent;
import com.example.l2cachecollections.entity.SimpleEntity;
import com.example.l2cachecollections.service.ParentService;
import com.example.l2cachecollections.service.SimpleEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class L2cacheCollectionsApplication implements CommandLineRunner {

    private final SimpleEntityService simpleEntityService;

    private final ParentService parentService;

	public static void main(String[] args) {
		SpringApplication.run(L2cacheCollectionsApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        log.info("--- simple entity: save --- ");
//        SimpleEntity entity = new SimpleEntity(1L, "simple entity");
//        simpleEntityService.save(entity); // 2 stmts: select + insert
//        log.info("--- simple entity: find by id --- ");
//        simpleEntityService.findById(entity.getId()); // 0 stmts: get from cache

	    Child child1 = new Child(1L, "child1 name", null);
	    Child child2 = new Child(2L, "child2 name", null);
        Parent p = new Parent(1L, "parent name", List.of(child1, child2));
        child1.setParent(p);
        child2.setParent(p);
        log.info("--- parent entity: save --- ");
        parentService.save(p); // 6 statements: 3 select + 3 insert

        log.info("--- parent entity: save second --- ");
        parentService.save(p);
    }
}
