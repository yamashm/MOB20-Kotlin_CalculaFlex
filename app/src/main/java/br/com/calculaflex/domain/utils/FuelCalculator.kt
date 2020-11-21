package br.com.calculaflex.domain.utils

import br.com.calculaflex.domain.entity.enums.FuelType
import br.com.calculaflex.domain.entity.holder.BetterFuelHolder

class FuelCalculator {
    fun betterFuel(
            betterFuelHolder: BetterFuelHolder
    ): FuelType {
        val performanceOfMyCar = calculatePerformance(betterFuelHolder.ethanolAverage, betterFuelHolder.gasAverage)
        val priceOfFuelIndex = calculatePriceOfFuelIndex(betterFuelHolder.ethanolPrice, betterFuelHolder.gasPrice)

        return if (priceOfFuelIndex <= performanceOfMyCar) {
            FuelType.ETHANOL
        } else {
            FuelType.GASOLINE
        }
    }

    fun calculatePerformance(ethanolAverage: Double, gasAverage: Double): Double{
        return ethanolAverage/gasAverage
    }

    fun calculatePriceOfFuelIndex(ethanolPrice: Double, gasPrice: Double): Double {
        return ethanolPrice / gasPrice
    }
}