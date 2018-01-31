package com.example.picked.openweather.forecast.domain.usecase

import com.example.picked.openweather.UseCase
import io.reactivex.Observable
import javax.inject.Inject


class KelvinToCelsius : UseCase<KelvinToCelsius.Result, KelvinToCelsius.Request> {
    @Inject constructor()
    override fun execute(request: Request): Observable<Result> {
        return Observable.fromCallable {
            val kelvin = request.kelvin
            val celsius = kelvin - 273.15
            return@fromCallable Result(celsius)
        }
    }

    data class Request(val kelvin: Double) : UseCase.Request
    data class Result(val celsius: Double) : UseCase.Result
}
