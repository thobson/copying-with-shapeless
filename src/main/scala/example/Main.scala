package example

import java.time.LocalDate

import shapeless.LabelledGeneric

object Main {

  def main(args: Array[String]): Unit = {
    // Our case class representations of the data
    // See the updated case class declaration for Location
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", to = LocalDate.of(2018,8,10), from = LocalDate.of(2018,8,1))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4)
    val driver = Driver(driverAge = 35, nationality = "British")

    val LocationGen = LabelledGeneric[Location]
    val VehicleGen = LabelledGeneric[Vehicle]
    val DriverGen = LabelledGeneric[Driver]
    val ReservationGen = LabelledGeneric[Reservation]

    val locationRepr = LocationGen.to(location)
    val vehicleRepr = VehicleGen.to(vehicle)
    val driverRepr = DriverGen.to(driver)

    val reservationRepr = locationRepr ++ vehicleRepr ++ driverRepr
    // This won't compile
    val reservation: Reservation = ReservationGen.from(reservationRepr)
  }

}
