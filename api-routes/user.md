
# API Routes for User

## Base URL `http://localhost:8080/api/v1`

---

## Users
| Method   | Endpoint       | Description                            | Request Body Example             |
|----------|----------------|----------------------------------------|----------------------------------|
| **GET**  | `/users/:id`   | Retrieve a user by ID                  | N/A                              |
| **GET**  | `/users`       | List all users                         | N/A                              |
| **POST** | `/users`       | Create a new user                      | ```json                          |
|          |                |                                        | {                                |
|          |                |                                        | "name": "John Doe",              |
|          |                |                                        | "email": "john.doe@example.com", |
|          |                |                                        | "password": "password123",       |
|          |                |                                        | "role": "ROLE_USER",             |
|          |                |                                        | "isPremium": false               |
|          |                |                                        | }                                |
| **PUT**  | `/users/:id`   | Update a user by ID                    | ```json                          |
|          |                |                                        | {                                |
|          |                |                                        | "name": "Jane Doe",              |
|          |                |                                        | "email": "jane.doe@example.com", |
|          |                |                                        | "role": "ROLE_ADMIN",            |
|          |                |                                        | "isPremium": true                |
|          |                |                                        | }                                |
| **DELETE**| `/users/:id`   | Delete a user by ID                    | N/A                              |

---