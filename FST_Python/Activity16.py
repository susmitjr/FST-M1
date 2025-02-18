class Car:
    def __init__(self, manufacturer , model ,color , price, transmission):
        self.manufacturer = manufacturer,
        self.model = model,
        self.color = color,
        self.price = price,
        self.transmission = transmission
    
    def accelerate(self):
        print ("The " , self.manufacturer , self.model , "has been moving faster")
    
    def stop (self):
        print ("Car ", self.manufacturer , " is braked through " , self.transmission , " Transmission")

Car1 = Car("TOYOTA" , "GRAZIA" , "RED" , "1000000", "Semi")
Car2 = Car("BMD" , "G3" , "Black" , "99000000", "Automatic")

Car1.accelerate()
Car2.accelerate()

Car2.stop()
Car1.stop()




        