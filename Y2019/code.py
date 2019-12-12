def readInput():
    lines = [197487,673251]

    return lines

def runProgram():
    lines = readInput()
    comb = 0
    testInt = 197487
    while testInt <= 673251:
        if meetsCrit(testInt):
            comb+=1
        testInt+=1

    print("comb: ", comb)

def meetsCrit(testInt):
    testStr = str(testInt)
    isSame = False
    decreases = False
    x = 0
    while x < 5:
        #print("x:     ", x)
        #print("val:   ", int(testStr[x]))
        #print("val+1: ", int(testStr[x+1]))
        if int(testStr[x]) > int(testStr[x+1]):
            decreases = True
        if int(testStr[x]) == int(testStr[x+1]):
            isSame = True
            if False and x < 4:
                if int(testStr[x+1]) == int(testStr[x+2]):
                    #print("val+2: ", int(testStr[x+2]))
                    isSame = False
            x = x+1
        x = x+1
    
    if (not isSame) or decreases:
        return False

    return True

print("111111: ", meetsCrit(111111))
print("223450: ", meetsCrit(223450))
print("123789: ", meetsCrit(123789))


print("112233: ", meetsCrit(112233))
print("123444: ", meetsCrit(123444))
print("111122: ", meetsCrit(111122))
print("122225: ", meetsCrit(122225))




runProgram()