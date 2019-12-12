def readInput():
    text_file = open("input/d5.txt", "r")
    lines = text_file.read().split(',')
    text_file.close()
    return lines[0]

def runProgram():
    lines = readInput()
    lines = "123456789012"
    width = 3#25
    height = 2#6
    indexOnWidth = 0
    indexOnHeight = 0

    #layers=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0] # should be 25 0s
    layers = [0] * width
    print(lines)

    while indexOnHeight < height:
        while indexOnWidth < width:
            print("height: ", indexOnHeight)
            print("width: ", indexOnWidth)
            print("the number:",lines[indexOnHeight*width + indexOnWidth])
            print("the index: ", indexOnHeight*width + indexOnWidth)
            if lines[indexOnHeight*width + indexOnWidth] == 0:
                layers[indexOnWidth]+=1
            indexOnWidth+=1
        indexOnHeight+=1

    smallestRowIndex = countSmallest(layers)

    noOnes = countNoOf(lines[smallestRowIndex],1)
    noTwos = countNoOf(lines[smallestRowIndex],2)

    print("1: ", noOnes)
    print("2: ", noTwos)

    print("Result: ", noOnes*noTwos)

def countNoOf(arr, number):
    numberOf = 0
    for x in arr:
        if x == number:
            numberOf+=1
    
    return numberOf


def countSmallest(layers):
    largestRowIndex = 0
    i = 0
    print("Count smallest begin ---------------")
    print("len-1: ",len(layers)-1)
    while i < (len(layers)-1):
        if layers[i] < layers[largestRowIndex]:
            largestRowIndex = i
        i+=1
    print("Count smallest end ---------------")
    return largestRowIndex


runProgram()

#1128 is too high