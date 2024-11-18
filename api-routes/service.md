
# API Routes for Service

## Base URL `http://localhost:8080/api/v1`

---

## Services
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/services/:id`   | Retrieve a service by ID            | N/A                                           |
| **GET**  | `/services`       | List all services                   | N/A                                           |
| **POST** | `/services`       | Create a new service                | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Hair Cut",                        |
|          |                   |                                     |   "description": "Basic hair cutting",       |
|          |                   |                                     |   "price": 25.0,                             |
|          |                   |                                     |   "duration": 30,                            |
|          |                   |                                     |   "categoryId": 1                            |
|          |                   |                                     | }                                             |
| **PUT**  | `/services/:id`   | Update a service by ID              | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Luxury Hair Cut",                 |
|          |                   |                                     |   "description": "Includes hair wash",       |
|          |                   |                                     |   "price": 50.0,                             |
|          |                   |                                     |   "duration": 60,                            |
|          |                   |                                     |   "categoryId": 2                            |
|          |                   |                                     | }                                             |
| **DELETE**| `/services/:id`   | Delete a service by ID              | N/A                                           |

---