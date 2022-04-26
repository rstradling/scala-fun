package com.strad.service

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp.Simple:
  def run: IO[Unit] =
    ServiceServer.stream[IO].compile.drain.as(ExitCode.Success)

