package com.gabrielczar.simpleappvalidation.services

interface IGenericService<T> {
    fun create(entity : T) : T
    fun update(entity: T) : T
    fun delete(id : Long)
    fun get(id : Long) : T
    fun list() : List<T>
    fun exists(id: Long) : Boolean
}