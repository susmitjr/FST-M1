from timeit import repeat


user1=input ("What is the User1 Player Name: ")
user2=input ("What is the User2 Player Name: ")

while True:
    user1Answer= input(user1 + " ,Do you want to choose rock, paper or scissors.. ").lower()
    user2Answer= input(user2 + " ,Do you want to choose rock, paper or scissors.. ").lower()
    
    if user1Answer==user2Answer:
        print("Its a tie")
    elif user1Answer == 'rock':
        if user2Answer == 'scissors':
            print ("The Rock Wins")
        else:
            print ("Paper Wins")
    elif user1Answer=='scissors':
        if user2Answer=='paper':
            print("Scissors Wins")
        else:
            print ("Rock Wins")

    elif user1Answer=='papar':
        if user2Answer=='rock':
            print("paper Wins")
        else:
            print ("scissors Wins")
    else:
        print ("Invalid data")
    
    repeat = input("Do you wish to continue! ").lower()

    if (repeat == 'yes'):
        pass
    elif (repeat == 'no'):
        raise SystemExit
    else:
        print("Please try later")
        raise SystemExit







