package me.arkadzi.imho.data.mapper

interface Mapper<A, B> {
    @Throws(RuntimeException::class)
    fun map(obj: A): B
}
