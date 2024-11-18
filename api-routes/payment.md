
# API Routes for Payment

## Base URL `http://localhost:8080/api/v1`

---

## Payments
| Method   | Endpoint             | Description                       | Request Body Example                          |
|----------|----------------------|-----------------------------------|-----------------------------------------------|
| **GET**  | `/payments/:id`      | Retrieve a payment by ID          | N/A                                           |
| **GET**  | `/payments`          | List all payments                 | N/A                                           |
| **POST** | `/payments`          | Record a new payment              | ```json                                      |
|          |                      |                                   | {                                             |
|          |                      |                                   |   "bookingId": 1,                            |
|          |                      |                                   |   "amount": 150.0,                           |
|          |                      |                                   |   "paymentMethod": "CARD",                   |
|          |                      |                                   |   "paymentDate": "2024-11-21T10:00:00"        |
|          |                      |                                   | }                                             |

---