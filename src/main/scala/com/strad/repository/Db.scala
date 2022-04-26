package com.strad.repository

import cats.effect.*
import cats.implicits.*
import doobie.*
import doobie.implicits.*
import doobie.hikari.*

object Db: 
    def mkConnection[F[_]: Sync: Async](
        driverName: String,
        url: String,
        user: String,
        password: String
    ): Resource[F, HikariTransactor[F]] =
        for
        ce <- ExecutionContexts.fixedThreadPool[F](32)
        xa <- HikariTransactor.newHikariTransactor[F](driverName, url, user, password, ce)
        yield xa
