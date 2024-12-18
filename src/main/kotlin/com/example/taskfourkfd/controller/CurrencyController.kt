package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.Currency
import com.example.taskfourkfd.service.CurrencyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/currency")
class CurrencyController (private val currencyService: CurrencyService) {

    @GetMapping
    fun getAllCurrencies(): List<Currency> = currencyService.getAllCurrencies()

    @GetMapping("/{currencyId}")
    fun getCurrencyById(@PathVariable currencyId: Long): Currency? =
        currencyService.getCurrencyById(currencyId)

    @PostMapping
    fun createCurrency(@RequestBody currency: Currency): Currency =
        currencyService.createCurrency(currency)

    @PostMapping("/list")
    fun createListCurrencies(@RequestBody listCurrency: List<Currency>): List<Currency> =
        currencyService.createListCurrency(listCurrency)

}