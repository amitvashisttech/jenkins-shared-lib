package com.jenkinsshlibdemo;


class Car {
    int numberOfDoors
    String brand
    String model
    def script 

    Car(script) {
      this.script = script
    }


   void printOutCar() {
      script.echo "Using the script.echo"
      script.echo "numberOfDoors:${numberOfDoors}"
      script.echo "brand:${brand}"
      script.echo "model.${model}"

   }
}
