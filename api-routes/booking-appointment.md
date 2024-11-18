
# API Routes for Booking and Appointment

## Base URL `http://localhost:8080/api/v1`

---

## Bookings and Appointments
| Method   | Endpoint                 | Description                                  | Request Body Example                          |
|----------|--------------------------|----------------------------------------------|-----------------------------------------------|
| **GET**  | `/bookings/:id`          | Retrieve a booking by ID                     | N/A                                           |
| **GET**  | `/bookings`              | List all bookings                           | N/A                                           |
| **POST** | `/bookings`              | Create a booking (without scheduling an appointment) | ```json                              |
|          |                          |                                              | {                                             |
|          |                          |                                              |   "userId": 1,                                |
|          |                          |                                              |   "salonId": 2,                               |
|          |                          |                                              |   "serviceId": 3,                             |
|          |                          |                                              |   "stylistId": 4                              |
|          |                          |                                              | }                                             |
| **POST** | `/appointments`          | Schedule an appointment for an existing booking | ```json                                    |
|          |                          |                                              | {                                             |
|          |                          |                                              |   "bookingId": 1,                             |
|          |                          |                                              |   "startTime": "2024-11-20T14:00:00",         |
|          |                          |                                              |   "endTime": "2024-11-20T15:00:00"            |
|          |                          |                                              | }                                             |
| **POST** | `/book-appointment`      | Create a booking with an appointment         | ```json                                      |
|          |                          |                                              | {                                             |
|          |                          |                                              |   "bookingDetails": {                         |
|          |                          |                                              |     "userId": 1,                              |
|          |                          |                                              |     "salonId": 2,                             |
|          |                          |                                              |     "serviceId": 3,                           |
|          |                          |                                              |     "stylistId": 4                            |
|          |                          |                                              |   },                                          |
|          |                          |                                              |   "appointmentDetails": {                     |
|          |                          |                                              |     "startTime": "2024-11-20T14:00:00",       |
|          |                          |                                              |     "endTime": "2024-11-20T15:00:00"          |
|          |                          |                                              |   }                                           |
|          |                          |                                              | }                                             |
| **PUT**  | `/bookings/:id`          | Update a booking                             | ```json                                      |
|          |                          |                                              | {                                             |
|          |                          |                                              |   "salonId": 5,                               |
|          |                          |                                              |   "serviceId": 6,                             |
|          |                          |                                              |   "stylistId": 7                              |
|          |                          |                                              | }                                             |
| **PUT**  | `/appointments/:id`      | Update an appointment for an existing booking | ```json                                     |
|          |                          |                                              | {                                             |
|          |                          |                                              |   "startTime": "2024-11-21T14:00:00",         |
|          |                          |                                              |   "endTime": "2024-11-21T15:00:00"            |
|          |                          |                                              | }                                             |
| **DELETE**| `/bookings/:id`          | Delete a booking (also removes linked appointment) | N/A                                       |
| **DELETE**| `/appointments/:id`      | Delete an appointment without deleting the booking | N/A                                       |

---

### Notes:
- **`/bookings`**: This endpoint handles the creation, updating, and deletion of bookings. Appointments can be scheduled later.
- **`/appointments`**: This endpoint schedules an appointment for an already created booking.
- **`/book-appointment`**: This unified endpoint creates both a booking and its associated appointment in one request.
- **`/appointments` endpoints**: These allow management of appointments independently of bookings, if required.

---

### Workflow Example:
1. **Booking Without Appointment:**
    - Call `POST /bookings` with booking details.
    - Later, schedule an appointment using `POST /appointments`.

2. **Booking With Appointment (One Button):**
    - Call `POST /book-appointment` with combined booking and appointment details.
    - The backend handles creating both booking and appointment in a single operation.

---

This version ensures that **`POST /appointments`** is included, making it clear how to add an appointment for an existing booking in a separate workflow.
