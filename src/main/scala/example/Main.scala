package example

import java.time.LocalDate
import shapeless.Generic

object Main {

  def main(args: Array[String]): Unit = {
    // Our case class representations of the data
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", from = LocalDate.of(2018,8,1), to = LocalDate.of(2018,8,10))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4)
    val driver = Driver(driverAge = 35, nationality = "British")

    val locationRepr = Generic[Location].to(location)
    val vehicleRepr = Generic[Vehicle].to(vehicle)
    val driverRepr = Generic[Driver].to(driver)

    val reservationRepr = locationRepr ++ vehicleRepr ++ driverRepr
    val reservation: Reservation = Generic[Reservation].from(reservationRepr)
    println(s"pickup location: ${reservation.pickup}")
  }

}
