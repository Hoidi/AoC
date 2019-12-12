def readInput():
    text_file = open("input/d5.txt", "r")
    lines = text_file.read().split(',')
    text_file.close()
    for i in range(0, len(lines)): 
        lines[i] = int(lines[i])
    #print(lines) 
    #print(len(lines))

    return lines

def intcode():
    lines = readInput()
    output = 0
    while output != 19690720:
        for noun in range(100):
            for verb in range(100):
                lines = readInput()
                output = runProgram(noun,verb,lines)
                if output == 19690720:
                    print("noun: ", noun)
                    print("verb: ", verb)
                    print("output: ", output)
                    print("actual result: ", 100*noun+verb)
                    break
            if output == 19690720:
                break
        break
        

def runProgram(noun, verb, lines):
    pos = 0
    lines[1]=noun
    lines[2]=verb
    while pos < int(len(lines)):
            op = lines[pos]
            if op == 1:
                lines[lines[pos+3]]=lines[lines[pos+2]]+lines[lines[pos+1]]
            if lines[pos] == 2:
                lines[lines[pos+3]]=lines[lines[pos+2]]*lines[lines[pos+1]]
            if lines[pos] == 99:
                break
            pos+=4
    
    return lines[0]

intcode()