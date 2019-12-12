def readInput():
    text_file = open("input/d1.txt", "r")
    #lines = text_file.readlines()
    lines = text_file.read().split('\n')
    text_file.close()
    #print(lines)
    #print(len(lines))

    return lines

def fuelReq():
    lines = readInput()
    #lines = [1969]
    length = int(len(lines))
    fuel = 0
    l = [i for i in range(length)] # same as range(length)
    
    for i in range(0, len(lines)): 
        lines[i] = int(lines[i]) 
    
    while sum(lines) > 0:
        for x in l:
            if lines[x] > 0:
                y = int(lines[x])
                dev = int(y/3)-2
                lines[x] = dev
                if dev < 0:
                    break
                fuel += dev
                print("dev: ", dev)
                
    print("fuel: ", fuel)



fuelReq()