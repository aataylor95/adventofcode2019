package com.github.aataylor95.day1

import groovy.json.JsonSlurper

class FuelCalculator {

  static void main(String[] args) {
    println new FuelCalculator().calculateTotalFuel()
  }

  Integer calculateTotalFuel() {
    List<Integer> moduleMasses = new JsonSlurper().parse(this.class.getResourceAsStream('/day1/input.json'))

    return (Integer)moduleMasses.sum { calculateModuleFuel(it) }
  }

  Integer calculateModuleFuel(Integer moduleMass) {
    (moduleMass.toBigDecimal() / 3).trunc() - 2
  }
}
