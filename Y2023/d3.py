import re

with open('d3.txt') as f:
    lines = f.readlines()

grid = [[*(line.removesuffix("\n"))] for line in lines]


def isAdjacentSymbol(grid, x, y):
    distance = 1
    for v in range(0-distance, 1+distance):
        for h in range(0-distance, 1+distance):
            if (x+v < 0 or y+h < 0 or x+v > len(grid)-1 or y+h > len(grid[0])-1 or v == 0 and h == 0):
                continue

            adj = grid[x+v][y+h]

            # print("adj", adj)

            if (not adj.isnumeric() and adj != "."):
                return True

    return False


def isAdjacentGear(grid, x, y):
    adjGears = []
    distance = 1
    for v in range(0-distance, 1+distance):
        for h in range(0-distance, 1+distance):
            if (x+v < 0 or y+h < 0 or x+v > len(grid)-1 or y+h > len(grid[0])-1 or v == 0 and h == 0):
                continue

            adj = grid[x+v][y+h]

            # print("adj", adj)

            if (adj == '*'):
                adjGears.append((x+v, y+h))

    if (len(adjGears) > 0):
        return True, adjGears

    return False, []


allGearPositions = {}
for x, row in enumerate(grid):
    for y, cell in enumerate(row):
        if (cell == "*"):
            numberOfAdjacentEngineParts = 0
            gearRatio = 1
            allGearPositions[(x, y)] = (numberOfAdjacentEngineParts, gearRatio)

sum = 0

for x, row in enumerate(grid):

    currentNumber = ""
    currentNumberHasSymbol = False
    thisNumbersGearPositions = []
    print("allGearPositions", allGearPositions)

    for y, cell in enumerate(row):
        if (cell.isnumeric()):
            currentNumber += cell

            if (isAdjacentSymbol(grid, x, y)):
                isGear, gearPositions = isAdjacentGear(grid, x, y)
                if (not currentNumberHasSymbol and isGear):
                    thisNumbersGearPositions.append(gearPositions)
                    for gearPos in thisNumbersGearPositions:
                        allGearPositions[gearPos] = (
                            allGearPositions[gearPos][0]+1, allGearPositions[gearPos][1])

                currentNumberHasSymbol = True

            if (y == len(row)-1):
                if (currentNumberHasSymbol):
                    sum += int(currentNumber)

                currentNumber = ""
                currentNumberHasSymbol = False
        else:
            if (currentNumberHasSymbol):
                sum += int(currentNumber)

            if (thisNumbersGearPositions != []):
                for lastGearPos in thisNumbersGearPositions:
                    allGearPositions[lastGearPos] = (
                        allGearPositions[lastGearPos][0], allGearPositions[lastGearPos][1] * int(currentNumber))

            currentNumber = ""
            currentNumberHasSymbol = False
            thisNumbersGearPositions = []

gearSum = 0

for gearPos in allGearPositions:
    (numberOfAdjacentEngineParts, gearRatio) = allGearPositions[gearPos]

    if (numberOfAdjacentEngineParts != 2):
        continue

    gearSum += gearRatio

print("allGearPositions", allGearPositions)
print("Part 1:", sum)
print("Part 2:", gearSum)
