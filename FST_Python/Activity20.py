import pandas

dataframe = pandas.read_excel("C:/Users/0033RC744/Desktop/sample.xlsx")

print ("-------------PRINTING DATAFRAME-----------------------------")
print (dataframe)
print ("--------------ASCENDING ORDER-----------------------------")
print (dataframe.sort_values("FirstName"))
print ("--------------DECENDING ORDER----------------------------")
print (dataframe.sort_values("PhoneNumber" , ascending= False))
print ("----------------SORT--------------------------")
print(dataframe["Email"])