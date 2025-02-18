import pandas

dataset = {
    "username" : ["A" , "B" , "C"],
    "passwords" : ["1231!" , "432#" , "091F"]
}

dataframe = pandas.DataFrame(dataset)

print (dataframe)

dataframe.to_csv ("C:/Users/0033RC744/Desktop/sample1.csv" , index=False)

