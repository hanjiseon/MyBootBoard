package kr.myproject.category.repository;

import org.springframework.data.repository.CrudRepository;

import kr.myproject.category.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {

}
