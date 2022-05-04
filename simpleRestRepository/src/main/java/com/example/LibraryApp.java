package com.example;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApp {

    @Autowired
    private BookRepository repository;

    @Component
    class DataSetup implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            repository.save(Book.builder().author("Author1").title("Book1").build());
            repository.save(Book.builder().author("Author2").title("Book2").build());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
