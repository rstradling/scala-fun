package com.strad.service
import com.strad.repository.Models.*

object Models:
  case class UserResponse(userId : Long, firstName: String, lastName: String,
                  email: Option[String], phone: Option[String], address: Option[String])
  case class UserRequest(firstName: String, lastName: String,
                  email: Option[String], phone: Option[String], address: Option[String])

  def toUserResponse(user: User) : UserResponse =
      UserResponse(userId = user.userId, firstName = user.firstName, lastName = user.lastName,
      email = user.email, phone = user.phone, address = user.address)

  def toUser(userReq: UserRequest) =
      // Purposely setting to -1 because this is going to be overriten by the db
      User(userId = -1L, firstName = userReq.firstName, lastName = userReq.lastName,
      email = userReq.email, phone = userReq.phone, address = userReq.address)
