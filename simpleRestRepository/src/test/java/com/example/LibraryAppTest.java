package com.example;

import com.example.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
class LibraryAppTest {
    @Autowired
    private BookRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void repositoryNotEmpty() {
        assertThat(repository.findAll()).isNotEqualTo(Matchers.emptyIterable());
        assertThat(repository.findAll().size()).isEqualTo(2);
    }
}
