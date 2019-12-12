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
    x = 0
    isOdd = False
    while x < 5:
        #print("x:     ", x)
        #print("val:   ", int(testStr[x]))
        #print("val+1: ", int(testStr[x+1]))
        if int(testStr[x]) > int(testStr[x+1]):
            return False
        if int(testStr[x]) == int(testStr[x+1]) and not isOdd:
            isSame = True
            if False or x < 4:
                if int(testStr[x+1]) > int(testStr[x+2]):
                    return False
                if int(testStr[x+1]) == int(testStr[x+2]):
                    #print("val+2: ", int(testStr[x+2]))
                    isSame = False
                    isOdd = True
                x = x+1
        x+=1
        if isOdd:
            return False
    return isSame

print("---------------")
print("111111: ", meetsCrit(111111))
print("112233: ", meetsCrit(112233))
print("111122: ", meetsCrit(111122))
print("---------------")
print("223450: ", meetsCrit(223450))
print("123789: ", meetsCrit(123789))
print("111345: ", meetsCrit(111345))
print("112223: ", meetsCrit(112223))
print("115522: ", meetsCrit(115522))
print("112333: ", meetsCrit(112333))
print("444229: ", meetsCrit(444229))
print("444889: ", meetsCrit(444889))


runProgram()

#1128 is too high