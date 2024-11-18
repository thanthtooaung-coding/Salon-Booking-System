
# API Routes for Notification

## Base URL `http://localhost:8080/api/v1`

---

## Notifications
| Method   | Endpoint             | Description                       | Request Body Example                          |
|----------|----------------------|-----------------------------------|-----------------------------------------------|
| **GET**  | `/notifications/:id` | Retrieve a notification by ID     | N/A                                           |
| **GET**  | `/notifications`     | List all notifications            | N/A                                           |
| **POST** | `/notifications`     | Create a new notification         | ```json                                      |
|          |                      |                                   | {                                             |
|          |                      |                                   |   "userId": 1,                               |
|          |                      |                                   |   "message": "Your appointment is confirmed",|
|          |                      |                                   |   "type": "EMAIL",                           |
|          |                      |                                   |   "status": "PENDING"                        |
|          |                      |                                   | }                                             |

---