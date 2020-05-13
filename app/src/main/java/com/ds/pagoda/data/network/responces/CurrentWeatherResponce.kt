package com.ds.pagoda.data.network.responces

data class CurrentWeatherResponce (

    var coord: Coord?,
    var weather: List<Weather>?,
    var base: String?,
    var main: Main?,
    var visibility: String?,
    var wind: Wind?,
    var clouds: Clouds?,
    var dt: Double?,
    var sys: Sys?,
    var id: Double?,
    var name: String?,
    var cod: Double?
)

data class Coord(

    var lon: String?,
    var lat: String?
)

data class Weather(
    var id: Int?,
    var main: String?,
    var description: String?,
    var icon: String?
)

data class Main(
    var temp: Double?,
    var pressure: Double?,
    var humidity: Double?,
    var temp_min: Double?,
    var temp_max: Double?
)

data class Wind(
    var speed: Double?,
    var deg: Double?
)

data class Clouds(
    var all: Double?
)

data class Sys(
    var type: Double?,
    var id: Double?,
    var message: Double?,
    var country: String?,
    var sunrise: Double?,
    var sunset: Double?
)
