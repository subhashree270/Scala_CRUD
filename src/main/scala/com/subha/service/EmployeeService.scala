package com.subha.service

import com.subha.model.Employee
import com.subha.repository.EmployeeRepository

class EmployeeService {

  private val empRepository = new EmployeeRepository()

  def createEmp(name: String, salary: Double): Unit = {
    val emp = Employee(None, name, salary)
    empRepository.create(emp)
  }

  def getEmps(): List[Employee] = {
    empRepository.read()
  }

  def updateEmp(emp: Employee): Unit = {
    empRepository.update(emp)
  }

  def deleteEmp(id: Int): Unit = {
    empRepository.delete(id)
  }

}
