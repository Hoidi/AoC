import re

with open('d3.txt') as f:
    lines = f.readlines()

# padding
lines = ["." + line.removesuffix("\n") + "." for line in lines]
length = len(lines[0]) - 1
lines.insert(0, "." * length)
lines.append("." * length)

grid = [[*(line)] for line in lines]
allGearPositions = {}
for x, row in enumerate(grid):
    for y, cell in enumerate(row):
        if (cell == "*"):
            allGearPositions[(x, y)] = []


def findNeighbourIndices(row, start, end):
    # no value can be OB because padding
    neighbourStart = start-1
    left = [(row, neighbourStart)]
    right = [(row, end)]
    top = [(row-1, neighbourStart + col) for col in range(end-start+2)]
    bottom = [(row+1, neighbourStart + col) for col in range(end-start+2)]

    allNeighbours = left + right + top + bottom
    return allNeighbours


for row, line in enumerate(lines):
    numbersOnLine = re.finditer("(\d+)", line)
    for number in numbersOnLine:
        startIndex = number.start()
        endIndex = number.end()
        value = int(number.group(0))

        allNeighbours = findNeighbourIndices(row, startIndex, endIndex)
        for neighbour in allNeighbours:
            if neighbour in allGearPositions.keys():
                allGearPositions[neighbour] = allGearPositions[neighbour] + [value]

part2 = 0

for key in allGearPositions:
    neighbours = allGearPositions[key]

    if (len(neighbours) == 2):
        gearRatio = neighbours[0] * neighbours[1]
        part2 += gearRatio

print("Part 2:", part2)
