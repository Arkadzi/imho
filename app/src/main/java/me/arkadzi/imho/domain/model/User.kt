package me.arkadzi.imho.domain.model

data class User(
        var id: Integer,
        var name: String,
        var username: String,
        var email: String,
        var address: Address,
        var phone: String,
        var website: String,
        var company: Company
)

data class Address(
        var street: String,
        var suite: String,
        var city: String,
        var zipcode: String,
        var geo: Geo
)

data class Geo(
        var lat: String,
        var lng: String
)

data class Company(
        var name: String,
        var catchPhrase: String,
        var bs: String
)
