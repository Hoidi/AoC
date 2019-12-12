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
    layersZ = [0] * int(len(lines)/(height*width))
    layersO = [0] * int(len(lines)/(height*width))
    layersT = [0] * int(len(lines)/(height*width))
    print(lines)

    layerIndex = 0
    i= 0
    while i < len(lines):
        if lines[i] == "0":
            layersZ[layerIndex]+=1
        if lines[i] == "1":
            layersO[layerIndex]+=1
        if lines[i] == "2":
            layersT[layerIndex]+=1
        if i%(height*width-1) == 0:
            layerIndex+=1
        i+=1

    smallestRowIndex = countSmallest(layersZ)

    #noOnes = countNoOf(layersO[smallestRowIndex],1)
    #noTwos = countNoOf(lines[smallestRowIndex],2)

    print("1: ", layersO[smallestRowIndex])
    print("2: ", layersT[smallestRowIndex])

    print("Result: ", layersO[smallestRowIndex]*layersT[smallestRowIndex])

def countNoOf(arr, number):
    numberOf = 0
    for x in arr:
        if x == number:
            numberOf+=1
    
    print("numer of ", number, " in ", arr, " is: ", numberOf)
    
    return numberOf


def countSmallest(layers):
    largestRowIndex = 0
    i = 0
    print("Count smallest begin ---------------")
    while i < (len(layers)-1):
        if layers[i] < layers[largestRowIndex]:
            largestRowIndex = i
        i+=1
    
    print("the smallest number of 0s in ", layers, " is: ", largestRowIndex)
    print("Count smallest end ---------------")
    return largestRowIndex


runProgram()

countNoOf("12312311",1)