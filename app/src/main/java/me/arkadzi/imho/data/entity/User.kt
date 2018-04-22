package me.arkadzi.imho.data.entity


data class UserEntity(
        var id: Integer,
        var name: String,
        var username: String,
        var email: String,
        var address: AddressEntity,
        var phone: String,
        var website: String,
        var company: CompanyEntity
)

data class AddressEntity(
        var street: String,
        var suite: String,
        var city: String,
        var zipcode: String,
        var geo: GeoEntity
)

data class GeoEntity(
        var lat: String,
        var lng: String
)

data class CompanyEntity(
        var name: String,
        var catchPhrase: String,
        var bs: String
)
