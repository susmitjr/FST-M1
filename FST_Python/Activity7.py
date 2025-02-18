numbers = list (input("Please enter list of numbers to add: ").split(","))
sum = 0
for numbers in numbers:
    sum += int(numbers)
print(sum)

