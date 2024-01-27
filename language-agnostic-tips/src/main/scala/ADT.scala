object ADT { // Algebraic Data Types

  // way of structuring your data

  // sealed = no other scala file can extend this trait other than this file
  sealed trait Weather // "Sum type"

  case object Sunny extends Weather

  case object Windy extends Weather

  case object Rainy extends Weather

  case object Cloudy extends Weather

  // Weather = Sunny + Windy + Rainy + Cloudy == SUM type

  def feeling(weather: Weather): String = weather match
    case Sunny => ":)"
    case Cloudy => ":|"
    case Rainy => ":("

  case class WeatherForecastRequest(latitude: Double, longitude: Double)
  // (Double, Double) => WeatherForecastRequest (WFR)
  // type WFR = Double x Double = Product type

  // hybrid type
  sealed trait WeatherForecastResponse // SUM type

  case class Valid(weather: Weather) extends WeatherForecastResponse // PRODUCT type

  case class Invalid(error: String, description: String) extends WeatherForecastResponse // PRODUCT type

  // advantages
  // 1. illegal states are NOT representable
  // 2. highly composable
  // 3. immutable data structures
  // 4. just data, not functionality => structure our code

  type NaiveWeather = String

  def naiveFeeling(weather: String) = weather match
    case "sunny" => ":)"
  // other cases

  naiveFeeling("45 degrees")

  // complexity = number of possible values of that ADT
  // goal: reduce complexity

  sealed trait WeatherServerError

  case object NotAvailable extends WeatherServerError
  // other cases

}
