package example

import java.time.LocalDate

/* Represents the individual "pages" of our application */

case class Location(pickup: String, dropOff: String, to: LocalDate, from: LocalDate)

case class Vehicle(vehicleCategory: String, automatic: Boolean, numDoors: Int, isDiesel: Boolean)

case class Driver(driverAge: Int, nationality: String)

/* We will merge the all data into this one class */

case class Reservation(
  pickup: String,
  dropOff: String,
  from: LocalDate,
  to: LocalDate,
  vehicleCategory: String,
  automatic: Boolean,
  numDoors: Int,
  driverAge: Int,
  nationality: String,
  confirmed: Boolean // this is new
)