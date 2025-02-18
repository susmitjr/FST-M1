def calculateSum (num):
    sum = 0
    for num in num:
        sum += num
    return sum

list = [10,23,21,14,1,51,51,76]

cal = calculateSum(list)

print (cal)