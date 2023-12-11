with open('d10.txt') as f:
    lines = f.readlines()

grid = [[*(line.removesuffix("\n"))] for line in lines]
myPath = [["."]*len(row) for row in grid]

sPos = (0, 0)
for y, row in enumerate(grid):
    for x, col in enumerate(row):
        if (col == "S"):
            sPos = (x, y)
            print("S:", sPos)


def nexPosition(prevPos: (int, int), currentPos: (int, int)):
    prevX = prevPos[0]
    prevY = prevPos[1]
    currX = currentPos[0]
    currY = currentPos[1]
    symbol = grid[currY][currX]

    if (symbol == "-"):
        # make sure that we came from the same row? Nah
        if (prevX < currX):
            return (currX+1, currY)
        return (currX-1, currY)

    if (symbol == "|"):
        if (prevY < currY):
            return (currX, currY+1)
        return (currX, currY-1)

    if (symbol == "7"):
        if (prevX < currX):
            return (currX, currY+1)
        return (currX-1, currY)

    if (symbol == "J"):
        if (prevX < currX):
            return (currX, currY-1)
        return (currX-1, currY)

    if (symbol == "F"):
        if (prevX > currX):
            return (currX, currY+1)
        return (currX+1, currY)

    if (symbol == "L"):
        if (prevX > currX):
            return (currX, currY-1)
        return (currX+1, currY)

    return (-1, -1)


prevPos = sPos
currPos = (sPos[0], sPos[1] + 1)
nrSteps = 1

while True:
    symbol = grid[currPos[1]][currPos[0]]
    myPath[currPos[1]][currPos[0]] = symbol
    nextPos = nexPosition(prevPos, currPos)

    if (nextPos == (-1, -1)):
        myPath[sPos[1]][sPos[0]] = "7"
        break

    nrSteps += 1
    prevPos = currPos
    currPos = nextPos


print("Part 1:", nrSteps/2)

enclosedSum = 0
for rowIndex, row in enumerate(myPath):
    enterSymbol = ""
    exitSymbol = ""
    enclosed = False
    nrEnclosed = 0

    for index, symbol in enumerate(row):
        if enclosed and symbol == ".":
            # row[index] = "X"
            nrEnclosed += 1

        # staring crossing line
        if symbol == "F" or symbol == "L":
            enterSymbol = symbol

        # cossing line
        if (enterSymbol == "F" and symbol == "J") or (enterSymbol == "L" and symbol == "7"):
            enclosed = not enclosed
            enterSymbol = ""

        if symbol == "|":
            enclosed = not enclosed

    enclosedSum += nrEnclosed

print("Part 2:", enclosedSum)
