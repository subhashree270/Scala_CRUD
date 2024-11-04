package com.subha.controller

import com.subha.model.Employee
import com.subha.service.EmployeeService

class EmployeeController {

  private val empService = new EmployeeService()

  def createEmp(name: String, salary: Double): Unit = {
    empService.createEmp(name, salary)
    println(s"Employee  $name created.")
  }

  def getEmps(): Unit = {
    val emps = empService.getEmps()
    emps.foreach { emp =>
      println(s"ID: ${emp.id.get}, Name: ${emp.name}, Salary: ${emp.salary}")
    }
  }

  def updateEmp(id: Int, name: String, salary: Double): Unit = {
    val emp = Employee(Some(id), name, salary)
    empService.updateEmp(emp)
    println(s"Employee  ID $id updated.")
  }

  def deleteEmp(id: Int): Unit = {
    empService.deleteEmp(id)
    println(s"Employee  ID $id deleted.")
  }

}
