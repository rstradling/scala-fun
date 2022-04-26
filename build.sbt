val Http4sVersion = "0.23.6"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.2.6"
val MunitCatsEffectVersion = "1.0.6"
val DoobieVersion = "1.0.0-RC1"

lazy val root = (project in file("."))
  .settings(
    organization := "com.strad",
    name := "service",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "3.1.0",
    libraryDependencies ++= Seq(
      "ch.qos.logback"  %  "logback-classic"     % LogbackVersion,
      "org.http4s"      %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"      %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"      %% "http4s-circe"        % Http4sVersion,
      "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
      "org.tpolecat"    %% "doobie-core"         % DoobieVersion,
      "org.tpolecat"    %% "doobie-hikari"       % DoobieVersion,
      "org.tpolecat"    %% "doobie-munit"        % DoobieVersion          % Test,
      "org.tpolecat"    %% "doobie-postgres"     % DoobieVersion,
      "org.scalameta"   %% "munit"               % MunitVersion           % Test,
      "org.typelevel"   %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
    ),
    testFrameworks += new TestFramework("munit.Framework")
  )
