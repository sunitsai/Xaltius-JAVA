package com.repository;

import org.springframework.data.repository.CrudRepository;
import com.model.Books;
public interface BooksRepository extends CrudRepository<Books,Integer> {
}
