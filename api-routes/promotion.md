
# API Routes for Promotion

## Base URL `http://localhost:8080/api/v1`

---

## Promotions
| Method   | Endpoint             | Description                       | Request Body Example                          |
|----------|----------------------|-----------------------------------|-----------------------------------------------|
| **GET**  | `/promotions/:id`    | Retrieve a promotion by ID        | N/A                                           |
| **GET**  | `/promotions`        | List all promotions               | N/A                                           |
| **POST** | `/promotions`        | Create a new promotion            | ```json                                      |
|          |                      |                                   | {                                             |
|          |                      |                                   |   "code": "DISCOUNT50",                      |
|          |                      |                                   |   "description": "50% off on services",      |
|          |                      |                                   |   "discountPercentage": 50.0,                |
|          |                      |                                   |   "startDate": "2024-11-01",                 |
|          |                      |                                   |   "endDate": "2024-11-30"                    |
|          |                      |                                   | }                                             |
| **DELETE**| `/promotions/:id`    | Delete a promotion by ID         | N/A                                           |

---