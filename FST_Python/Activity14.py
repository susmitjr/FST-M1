 
def fabionacci(num):
    if num <=1:
        return num
    else:
        print (fabionacci(num-1) + fabionacci(num -2))

uinput = int(input("Enter list of numbers"))

if  uinput <=0:
    print ("Run again")
else:
    print ("Creating series")
    for i in range (uinput):
        print(fabionacci(i))