
# API Routes for Review

## Base URL `http://localhost:8080/api/v1`

---

## Reviews
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/reviews/:id`    | Retrieve a review by ID             | N/A                                           |
| **GET**  | `/reviews`        | List all reviews                    | N/A                                           |
| **POST** | `/reviews`        | Create a new review                 | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "userId": 1,                               |
|          |                   |                                     |   "salonId": 2,                              |
|          |                   |                                     |   "rating": 5,                               |
|          |                   |                                     |   "comment": "Amazing service!"              |
|          |                   |                                     | }                                             |
| **DELETE**| `/reviews/:id`    | Delete a review by ID               | N/A                                           |

---