from operator import index
import pandas

dataframe = pandas.read_csv("C:/Users/0033RC744/Desktop/sample1.csv")

print ("Full Data: ")
print (dataframe)
print ("------------------------------------------")
print (dataframe["username"])
print ("------------------------------------------")
print (dataframe["username"][1] , "||" , dataframe["passwords"][1])
print ("------------------------------------------")
print (dataframe.sort_values("username"))
print ("------------------------------------------")
print (dataframe.sort_values("username" , ascending= False))
