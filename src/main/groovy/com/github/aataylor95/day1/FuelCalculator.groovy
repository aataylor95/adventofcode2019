package com.github.aataylor95.day1

import groovy.json.JsonSlurper

class FuelCalculator {

  static void main(String[] args) {
    def calculator = new FuelCalculator()

    println "Task 1: ${calculator.task1()}"
    println "Task 2: ${calculator.task2()}"
  }

  Integer task1() {
    moduleMasses.sum { calculateModuleFuel(it) } as Integer
  }

  Integer task2() {
    (Integer)moduleMasses.sum {
      addExtraFuel calculateModuleFuel(it)
    }
  }

  Integer addExtraFuel(Integer moduleFuel) {
    Integer extraFuel = calculateModuleFuel(moduleFuel)

    while (extraFuel > 0) {
      moduleFuel += extraFuel

      extraFuel = calculateModuleFuel(extraFuel)
    }

    return moduleFuel
  }

  Integer calculateModuleFuel(Integer moduleMass) {
    (moduleMass.toBigDecimal() / 3).trunc() - 2
  }

  List<Integer> getModuleMasses() {
    (List<Integer>)new JsonSlurper().parse(this.class.getResourceAsStream('/day1/input.json'))
  }
}
