package org.yearup.data.mysql;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * From categories;";
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
            ) {

            while (resultSet.next()){

                Category category = mapRow(resultSet);

                categories.add(category);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String sql = "SELECT * FROM categories WHERE category_id=?;";

        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ){
                preparedStatement.setInt(1, categoryId);

              try(
                      ResultSet resultSet = preparedStatement.executeQuery();

                  ){
                  if(resultSet.next()){
                      return mapRow(resultSet);
                  } else {
                      System.out.println("Category not found.");
                  }
              }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category create(Category category) {
        String sql = "INSERT INTO categories(description, name) VALUES(?, ?);";
        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)

        ){
            preparedStatement.setString(1, category.getDescription());
            preparedStatement.setString(2, category.getName());

            preparedStatement.executeUpdate();

            try (
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            ){
                if (generatedKeys.next()) {
                    int category_id = generatedKeys.getInt(1);
                    category.setCategoryId(category_id);
                    return category;
                } else {
                    System.out.println("Category has been created successfully.");
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(int categoryId, Category category) {
        String sql = "UPDATE categories SET name=?, description=?, WHERE category_id=?;";

        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, categoryId);
            preparedStatement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        String sql = "DELETE FROM categories WHERE category_id=?;";

        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
