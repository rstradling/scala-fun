package com.strad.service.repository

import com.strad.repository.*
import com.strad.repository.Models.*
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import doobie.*
import doobie.implicits.*
import _root_.munit.*


// TODO: Move to integration test suite vs unit tests
class UserRepoPostgresTest extends FunSuite with doobie.munit.IOChecker:
    override val colors = doobie.util.Colors.None
    val transactor = Transactor.fromDriverManager[IO](
        "org.postgresql.Driver", "jdbc:postgresql:scalafun-test", "rstradling", "password")
    val repo = new UserRepoPostgres(transactor)
    val ret = UserRepoPostgres.createTable(transactor).unsafeRunSync()
    test("insertUserQuery") { check(repo.getByUserIdQuery(2L))}
    test("deleteUserByIdQuery") { check(repo.deleteUserByIdQuery(2L))}
    val user = new User(0L, "first", "last", Some("email"), Some("phone"), Some("Address"))
    test("insertUserQuery") { check(repo.insertUserQuery(user)) }