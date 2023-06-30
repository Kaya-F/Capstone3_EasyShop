package org.yearup.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    @Autowired
    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public ShoppingCart getByUserId(int userId) {
//        List<ShoppingCartItem> cartItems = new ArrayList<>();
//        ShoppingCart shoppingCart = new ShoppingCart();
//
//        String sql = "SELECT * FROM shopping_cart WHERE user_id = ?";
//
//        try (
//                Connection connection = getConnection();
//                PreparedStatement statement = connection.prepareStatement(sql)) {
//                ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int productId = resultSet.getInt("product_id");
//                Product product = productDao.getById(productId);
//                int quantity = resultSet.getInt("quantity");
//
//                ShoppingCartItem cartItem = new ShoppingCartItem(product, quantity);
//                cartItems.add(cartItem);
//            }
//
//            shoppingCart.setItems(cartItems);
//        } catch (SQLException e) {
//            // Handle any potential exceptions here
//            throw new RuntimeException("Error retrieving shopping cart.", e);
//        }
//
        return null; //shoppingCart//
    }

    @Override
    public void addProduct(int userId, Product productId) {

    }

    @Override
    public void updateProduct(int userId, int productId) {

    }

    @Override
    public void clearCart() {

    }
}
