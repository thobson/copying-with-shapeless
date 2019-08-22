package example

import java.time.LocalDate
import shapeless.Generic

object Main {

  def main(args: Array[String]): Unit = {
    // Our case class representations of the data
    // See the updated case class declaration for Location
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", to = LocalDate.of(2018,8,10), from = LocalDate.of(2018,8,1))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4)
    val driver = Driver(driverAge = 35, nationality = "British")

    val locationRepr = Generic[Location].to(location)
    val vehicleRepr = Generic[Vehicle].to(vehicle)
    val driverRepr = Generic[Driver].to(driver)

    val reservationRepr = locationRepr ++ vehicleRepr ++ driverRepr
    val reservation: Reservation = Generic[Reservation].from(reservationRepr)
    println(s"from date: ${reservation.from}")
  }

}
