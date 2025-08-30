# Movie-Booking-API
Movie Booking Backend API

A movie booking backend built with Java, Spring Boot, MySQL, and JWT. It allows normal users to book and cancel tickets, and admins to manage movies, theaters, and shows.

Features

For Users:

- Register/login with JWT

- Browse movies, theaters, and shows

Book tickets with seat selection

Cancel bookings and view history

For Admins:

Register admin users

Add, update, delete movies, theaters, shows

Manage show schedules and seats

API Endpoints with Examples

AuthController

POST /api/auth/registernormaluser – Register a user

{
  "username": "john",
  "email": "john@example.com",
  "password": "password123"
}


POST /api/auth/login – Login

{
  "email": "john@example.com",
  "password": "password123"
}


AdminController

POST /api/admin/registeradminuser – Create admin

MovieController

POST /api/movies/addmovie – Add a movie

GET /api/movies/getallmovies – List all movies

TheaterController

POST /api/theater/addtheater – Add a theater

GET /api/theater/gettheaterbylocation?location=city – List theaters by location

ShowController

POST /api/show/createshow – Create a show

GET /api/show/getshowsbymovie/{id} – Get shows by movie

BookingController

POST /api/booking/createbooking – Book tickets

PUT /api/booking/{id}/cancel – Cancel booking

GET /api/booking/getuserbookings/{id} – View user bookings

Tech Stack

Java, Spring Boot

MySQL

JWT for security

Maven

Installation

Clone the repo: git clone <repo-url>

Open in IDE as Maven project

Configure MySQL in application.properties

Run Spring Boot app

Test APIs using Postman
