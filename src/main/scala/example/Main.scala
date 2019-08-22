package example

import java.time.LocalDate
import shapeless.{::, HNil}

object Main {

  /* Our HList representation of the case classes */
  type LocationH = String :: String :: LocalDate :: LocalDate :: HNil
  type VehicleH = String :: Boolean :: Int :: HNil
  type DriverH = Int :: String :: HNil
  type ReservationH = String :: String :: LocalDate :: LocalDate :: String :: Boolean :: Int :: Int :: String :: HNil

  def main(args: Array[String]): Unit = {
    val locationH: LocationH = "Malaga Airport" :: "Malaga Airport" :: LocalDate.of(2018,8,1) :: LocalDate.of(2018,8,10) :: HNil
    val vehicleH: VehicleH = "Economy" :: false :: 4 :: HNil
    val driverH: DriverH = 35 :: "British" :: HNil

    val reservationH: ReservationH = locationH ++ vehicleH ++ driverH

    reservationH match {
      case
        pickup ::
        dropOff ::
        from ::
        to ::
        vehicleCategory ::
        automatic ::
        numDoors ::
        driverAge ::
        nationality ::
        HNil =>
        println(s"pickup location: $pickup")
    }
  }

}
