package com.tjetc.dao;

import java.util.List;

import com.tjetc.domain.Books;

public interface BooksDAO {
   Books findById(int id);
   List<Books> findAll();
}
