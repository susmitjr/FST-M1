from ast import Num


firstList = [10,22,34,56,78,89,117]
secondList = [37,15,77,10,00,51]

print ("1st list", firstList)
print ("2nd list", secondList)

thirdList = []

for Num in firstList:
    if (Num%2==0):
        thirdList.append(Num)
    else:
        print(False)

for Num in secondList:
    if (Num%2!=0):
        thirdList.append(Num)
    else:
        print(True)

print ("New list:" , thirdList)

