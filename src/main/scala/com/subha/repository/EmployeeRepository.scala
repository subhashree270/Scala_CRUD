package com.subha.repository

import com.subha.model.Employee
import com.typesafe.config.ConfigFactory

import java.sql.{Connection, DriverManager}

class EmployeeRepository {

  // Load database configuration
   val config = ConfigFactory.load()
   val dbUrl = config.getString("db.url")
   val dbUser = config.getString("db.user")
   val dbPassword = config.getString("db.password")

  // Get database connection
  private def getConnection: Connection = {
    DriverManager.getConnection(dbUrl, dbUser, dbPassword)
  }

  // Create emp
  def create(emp: Employee): Unit = {
    val connection = getConnection
    val statement = connection.prepareStatement("INSERT INTO emp (name, salary) VALUES (?, ?)")
    statement.setString(1, emp.name)
    statement.setDouble(2, emp.salary)
    statement.executeUpdate()
    connection.close()
  }

  // Read emps
  def read(): List[Employee] = {
    val connection = getConnection
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM emp")
    val emps = Iterator.continually((resultSet.next(), resultSet)).takeWhile(_._1).map { case (_, rs) =>
      Employee(Some(rs.getInt("id")) ,rs.getString("name"), rs.getDouble("salary"))
    }.toList
    connection.close()
    emps
  }

  // Update emp
  def update(emp: Employee): Unit = {
    val connection = getConnection
    val statement = connection.prepareStatement("UPDATE emp SET name = ?, salary = ? WHERE id = ?")
    emp.id.foreach{ id =>
      statement.setString(1, emp.name)
      statement.setDouble(2, emp.salary)
      statement.setInt(3, id)
      statement.executeUpdate()
    }
    connection.close()
  }

  // Delete emp
  def delete(id: Int): Unit = {
    val connection = getConnection
    val statement = connection.prepareStatement("DELETE FROM emp WHERE id = ?")
    statement.setInt(1, id)
    statement.executeUpdate()
    connection.close()
  }
}
