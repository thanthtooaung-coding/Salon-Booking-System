
# API Routes for Salon

## Base URL `http://localhost:8080/api/v1`

---

## Salons
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/salons/:id`     | Retrieve a salon by ID              | N/A                                           |
| **GET**  | `/salons`         | List all salons                     | N/A                                           |
| **POST** | `/salons`         | Create a new salon                  | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Glamour Spa",                     |
|          |                   |                                     |   "address": "123 Main Street, NY"           |
|          |                   |                                     | }                                             |
| **PUT**  | `/salons/:id`     | Update a salon by ID                | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Glamour Salon",                   |
|          |                   |                                     |   "address": "456 Broadway, NY"              |
|          |                   |                                     | }                                             |
| **DELETE**| `/salons/:id`     | Delete a salon by ID                | N/A                                           |

---