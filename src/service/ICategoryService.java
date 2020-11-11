package service;

import model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryByID(int categoryID);

    List<Category> getAllCategory();
}
