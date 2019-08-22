package example

import java.time.LocalDate
import shapeless.{::, HNil, Generic}

object Main {

  /* Our HList representation of the case classes */
  type LocationH = String :: String :: LocalDate :: LocalDate :: HNil
  type VehicleH = String :: Boolean :: Int :: HNil
  type DriverH = Int :: String :: HNil
  type ReservationH = String :: String :: LocalDate :: LocalDate :: String :: Boolean :: Int :: Int :: String :: HNil

  def main(args: Array[String]): Unit = {
    // Our case class representations of the data
    val location = Location(pickup = "Malaga Airport", dropOff = "Malaga Airport", from = LocalDate.of(2018,8,1), to = LocalDate.of(2018,8,10))
    val vehicle = Vehicle(vehicleCategory = "Economy", automatic = false, numDoors = 4)
    val driver = Driver(driverAge = 35, nationality = "British")

    // HList representations
    val locationH: LocationH = Generic[Location].to(location)
    val vehicleH: VehicleH = Generic[Vehicle].to(vehicle)
    val driverH: DriverH = Generic[Driver].to(driver)

    val reservationH: ReservationH = locationH ++ vehicleH ++ driverH
    val reservation: Reservation = Generic[Reservation].from(reservationH)
    println(s"pickup location: ${reservation.pickup}")
  }

}
