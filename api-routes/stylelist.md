
# API Routes for Stylelist

## Base URL `http://localhost:8080/api/v1`

---

## Stylists
| Method   | Endpoint          | Description                         | Request Body Example                          |
|----------|-------------------|-------------------------------------|-----------------------------------------------|
| **GET**  | `/stylists/:id`   | Retrieve a stylist by ID            | N/A                                           |
| **GET**  | `/stylists`       | List all stylists                   | N/A                                           |
| **POST** | `/stylists`       | Create a new stylist                | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "John Stylist",                    |
|          |                   |                                     |   "specialty": "Hair Styling",               |
|          |                   |                                     |   "experienceLevel": "Expert",               |
|          |                   |                                     |   "availability": "Mon-Fri, 9am-5pm",        |
|          |                   |                                     |   "salonId": 1                               |
|          |                   |                                     | }                                             |
| **PUT**  | `/stylists/:id`   | Update a stylist by ID              | ```json                                      |
|          |                   |                                     | {                                             |
|          |                   |                                     |   "name": "Jane Stylist",                    |
|          |                   |                                     |   "specialty": "Makeup",                     |
|          |                   |                                     |   "experienceLevel": "Intermediate",         |
|          |                   |                                     |   "availability": "Weekends",                |
|          |                   |                                     |   "salonId": 2                               |
|          |                   |                                     | }                                             |
| **DELETE**| `/stylists/:id`   | Delete a stylist by ID              | N/A                                           |

---