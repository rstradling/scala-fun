package com.strad.repository

object Models:
  case class User(userId : Long, firstName: String, lastName: String,
                  email: Option[String], phone: Option[String], address: Option[String])