
# API Routes for History

## Base URL `http://localhost:8080/api/v1`

---

## Histories
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/histories/:id`  | Retrieve a history by ID            | N/A                                           |
| **GET**  | `/histories`      | List all histories                  | N/A                                           |
| **POST** | `/histories`      | Record a new history                | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "userName": "John Doe",                    |
|          |                   |                                     |   "categoryName": "Hair Services",           |
|          |                   |                                     |   "bookingDate": "2024-11-21",               |
|          |                   |                                     |   "bookingTime": "14:00:00",                 |
|          |                   |                                     |   "paymentMethod": "CARD",                   |
|          |                   |                                     |   "cost": 50.0                               |
|          |                   |                                     | }                                             |

---