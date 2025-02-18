fruit_shop = {
    "apple" : 20,
    "promogranate" : 31,
    "banana" : 10,
    "papaya" : 10
}

print ("Available fruits in Prices" , fruit_shop)

check_availability = input("Let me know the fruit names: ").lower()

if check_availability in fruit_shop:
    print ("Available")
else:
    print ("Not Available")
