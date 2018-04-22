package me.arkadzi.imho.data.mapper

import me.arkadzi.imho.data.entity.*
import me.arkadzi.imho.domain.model.*


class Mappers {
    companion object {
        val userMapper: Mapper<UserEntity, User> by lazy {
            object : Mapper<UserEntity, User> {
                override fun map(obj: UserEntity) = User(obj.id, obj.name, obj.username, obj.email, addressMapper.map(obj.address), obj.phone, obj.website, companyMapper.map(obj.company))
            }
        }

        val addressMapper: Mapper<AddressEntity, Address> by lazy {
            object : Mapper<AddressEntity, Address> {
                override fun map(obj: AddressEntity) = Address(obj.street, obj.suite, obj.zipcode, obj.zipcode, geoMapper.map(obj.geo))
            }
        }

        val geoMapper: Mapper<GeoEntity, Geo> by lazy {
            object : Mapper<GeoEntity, Geo> {
                override fun map(obj: GeoEntity) = Geo(obj.lat, obj.lng)
            }
        }

        val companyMapper: Mapper<CompanyEntity, Company> by lazy {
            object : Mapper<CompanyEntity, Company> {
                override fun map(obj: CompanyEntity) = Company(obj.name, obj.catchPhrase, obj.bs)
            }
        }

        val postMapper: Mapper<PostEntity, Post> by lazy {
            object : Mapper<PostEntity, Post> {
                override fun map(obj: PostEntity) = Post(obj.userId, obj.id, obj.title, obj.body)
            }
        }

        val commentMapper: Mapper<CommentEntity, Comment> by lazy {
            object : Mapper<CommentEntity, Comment> {
                override fun map(obj: CommentEntity) = Comment(obj.postId, obj.id, obj.name, obj.email, obj.body)
            }
        }
    }
}
