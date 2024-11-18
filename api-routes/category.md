
# API Routes for Category

## Base URL `http://localhost:8080/api/v1`

---

## Categories
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/categories/:id` | Retrieve a category by ID           | N/A                                           |
| **GET**  | `/categories`     | List all categories                 | N/A                                           |
| **POST** | `/categories`     | Create a new category               | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Hair Services"                    |
|          |                   |                                     | }                                             |
| **PUT**  | `/categories/:id` | Update a category by ID             | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Makeup Services"                  |
|          |                   |                                     | }                                             |
| **DELETE**| `/categories/:id` | Delete a category by ID             | N/A                                           |

---