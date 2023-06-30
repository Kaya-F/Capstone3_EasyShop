# E-Commerce API
The E-Commerce API is a RESTful web service that provides endpoints for managing products, user accounts, and shopping carts in an e-commerce application. It allows users to browse and search for products, add products to their shopping carts, and perform various operations related to user accounts and orders.

## Features
*Product Management*: Retrieve a list of products, search for products by keywords, and view product details.
*User Authentication*: Register a new user, authenticate user login, and manage user accounts.
*Shopping Cart*: Add products to the shopping cart, update the number of products in the cart, and view and clear the cart.
*Order Management*: Place an order, and view the order history.


## API Endpoints
The following are the main API endpoints provided by the E-Commerce API:

### Products
GET /products: Retrieve a list of all products.
GET /products/{productId}: Get details of a specific product by ID.
GET /products/search?keywords={keywords}: Search for products based on keywords.

### User Authentication
POST /register: Register a new user.
POST /login: Authenticate user login and generate an access token.

### Shopping Cart
GET /cart: Get the shopping cart for the current user.
POST /cart/products/{productId}: Add a product to the shopping cart.
PUT /cart/products/{productId}: Update the quantity of a product in the shopping cart.
DELETE /cart: Clear all products from the shopping cart.

### Orders
POST /orders: Place an order with the products in the shopping cart.
GET /orders: Retrieve the order history for the current user.
Note: These are example endpoints, and you may need to customize them based on your specific requirements.

## Security
The E-Commerce API uses JWT (JSON Web Tokens) for authentication and authorization. Each protected endpoint requires an access token to be included in the request headers.

To obtain an access token, you need to register a new user account using the /register endpoint. Then, you can authenticate the user by sending a POST request to the /login endpoint with the username and password. The response will contain an access token that you can use for subsequent API requests.

## Error Handling
The API provides proper error handling and returns meaningful error messages in case of any issues. If an error occurs, the response will include an appropriate HTTP status code and a corresponding error message.


___________________________________________________________________________________________________________________________________________________

## The following bugs have been corrected:

- The search function was displaying incorrect results for the maximum and minimum price toggles.
![image](https://github.com/Kaya-F/Capstone3_EasyShop/assets/130245473/956316ac-4306-406d-bf2d-10ba28b3836b)

- The update for admin use would create a new product instead of updating it.
![image](https://github.com/Kaya-F/Capstone3_EasyShop/assets/130245473/c9a4fd09-20e6-49e5-9ea5-e9a0eb57d90a)


