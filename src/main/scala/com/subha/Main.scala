package com.subha

import com.subha.controller.EmployeeController

object Main extends App{
  val empController = new EmployeeController()

  //empController.createEmp("Alexa", 70000.00)
  //empController.deleteEmp(2)
  //empController.updateEmp(1,"Alexa",87000.00)
  empController.getEmps()

}
