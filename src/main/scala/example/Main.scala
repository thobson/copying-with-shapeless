package example

import java.time.LocalDate

object Main {

  import ShapelessOps._
  import shapeless.syntax.singleton._

  def main(args: Array[String]): Unit = {
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", from = LocalDate.of(2018,8,1), to = LocalDate.of(2018,8,10))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4, isDiesel = true)
    val driver = Driver(driverAge = 35, nationality = "British")
    val misalignedReservationRepr = location.repr ++ vehicle.repr ++ driver.repr :+ ('confirmed ->> true)
    /*_*/ val reservation = misalignedReservationRepr.as[Reservation] /*_*/
    println(s"from date: ${reservation.from}")
  }

}
