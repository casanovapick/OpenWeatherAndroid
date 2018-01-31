package com.example.picked.openweather

import io.reactivex.Observable


interface UseCase<P : UseCase.Result, in Q : UseCase.Request> {
    fun execute(request: Q): Observable<P>
    interface Result
    interface Request
}