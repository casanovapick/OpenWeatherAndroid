package com.example.picked.openweather.forecast.domain.usecase

import com.example.picked.openweather.UseCase
import io.reactivex.Observable
import javax.inject.Inject


class KelvinToFahrenheit : UseCase<KelvinToFahrenheit.Result, KelvinToFahrenheit.Request> {
    @Inject constructor()
    override fun execute(request: Request): Observable<Result> {
        return Observable.fromCallable {
            val kelvin = request.kelvin
            val fahrenheit = (kelvin * 1.80) - 459.67
            return@fromCallable Result(fahrenheit)
        }
    }

    data class Request(val kelvin: Double) : UseCase.Request
    data class Result(val fahrenheit: Double) : UseCase.Result
}
