package com.demo.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mvc.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{

}
