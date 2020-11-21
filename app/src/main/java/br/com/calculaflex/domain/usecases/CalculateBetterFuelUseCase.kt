package br.com.calculaflex.domain.usecases

import br.com.calculaflex.domain.entity.RequestState
import br.com.calculaflex.domain.entity.enums.FuelType
import br.com.calculaflex.domain.entity.holder.BetterFuelHolder
import br.com.calculaflex.domain.utils.FuelCalculator
import java.lang.Exception

class CalculateBetterFuelUseCase (val fuelCalculator : FuelCalculator) {

    suspend fun calculate(params: Params): RequestState<FuelType> {
//        val performanceOfMyCar = betterFuelHolder.ethanolAverage / betterFuelHolder.gasAverage
//
//        val priceOfFuelIndice = betterFuelHolder.ethanolPrice / betterFuelHolder.gasPrice
//
//        return if (priceOfFuelIndice <= performanceOfMyCar) {
//            RequestState.Success(FuelType.ETHANOL)
//        } else {
//            RequestState.Success(FuelType.GASOLINE)
//        }

        return try {
            val betterFuel = fuelCalculator.betterFuel(params.betterFuelHolder)
            RequestState.Success(betterFuel)
        } catch (ex: Exception) {
            RequestState.Error(ex)
        }
    }

    data class Params(
            val betterFuelHolder : BetterFuelHolder
    )
}