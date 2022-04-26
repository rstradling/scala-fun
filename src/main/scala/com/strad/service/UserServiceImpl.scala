package com.strad.service
import cats.*
import cats.implicits.*
import com.strad.service.Models.*
import com.strad.repository.UserRepo

class UserServiceImpl[F[_]](repo: UserRepo[F])(using e : Functor[F]) extends UserService[F]: 
    def getUser(userId: Long) : F[Option[UserResponse]] =
        repo.getUserById(userId).map(u => u.map(Models.toUserResponse))
    def addUser(user: UserRequest): F[UserResponse] =
        repo.insertUser(Models.toUser(user)).map(Models.toUserResponse)
    def deleteUser(userId: Long): F[Unit] =
        repo.deleteUserById(userId)
