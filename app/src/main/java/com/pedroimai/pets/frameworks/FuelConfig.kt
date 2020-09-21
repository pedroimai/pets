package com.pedroimai.pets.frameworks

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.interceptors.cUrlLoggingRequestInterceptor
import com.pedroimai.pets.BuildConfig.DOGS_API_KEY

fun fuelSetup() {
    FuelManager.instance.addRequestInterceptor(cUrlLoggingRequestInterceptor())
    FuelManager.instance.addRequestInterceptor(tokenInterceptor())
}

fun tokenInterceptor() = { next: (Request) -> Request ->
    { req: Request ->
        req.header(mapOf("x-api-key" to DOGS_API_KEY))
        next(req)
    }
}