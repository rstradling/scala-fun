package com.strad.repository

import com.strad.repository.Models.*

trait UserRepo[F[_]]:
  def insertUser(user: User): F[User]
  def deleteUserById(userId: Long): F[Unit]
  def getUserById(userId: Long): F[Option[User]]
