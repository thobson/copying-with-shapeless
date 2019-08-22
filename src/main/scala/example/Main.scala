package example

import java.time.LocalDate
import shapeless.LabelledGeneric
import shapeless.record._
import shapeless.syntax.singleton._

object Main {

  def main(args: Array[String]): Unit = {
    // Our case class representations of the data
    // See the updated case class declaration for Location
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", from = LocalDate.of(2018,8,1), to = LocalDate.of(2018,8,10))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4, isDiesel = true)
    val driver = Driver(driverAge = 35, nationality = "British")

    val LocationGen = LabelledGeneric[Location]
    val VehicleGen = LabelledGeneric[Vehicle]
    val DriverGen = LabelledGeneric[Driver]
    val ReservationGen = LabelledGeneric[Reservation]

    val locationRepr = LocationGen.to(location)
    val (_, vehicleRepr) = VehicleGen.to(vehicle).remove('isDiesel)
    val driverRepr = DriverGen.to(driver)

    val misalignedReservationRepr = locationRepr ++ vehicleRepr ++ driverRepr :+ ('confirmed ->> true)

    // closer!
    val reservation: Reservation = ReservationGen.from(misalignedReservationRepr)
    println(s"from date: ${reservation.from}")
  }

}
