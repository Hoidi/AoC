import re
import numpy as np

with open('d13.txt') as f:
    input = f.read()

maps = [map.split("\n") for map in input.split("\n\n")]


def printInput(input):
    for row in input:
        print(row)
    print()


def getMirrorIndexes(row: str, possibleSym: []) -> []:
    sym = []
    for step in possibleSym:
        left = row[:step]
        right = row[step:]

        maxLen = min(len(left), len(right))

        for i in range(maxLen):
            if (left[-(i+1)] != right[i]):
                break

            if i == maxLen-1:
                sym.append(step)
    return sym


def keepMirrorIndex(possibleSym: [], newPossible: []) -> []:
    result = list(newPossible)
    for i in newPossible:
        if i not in possibleSym:
            result.remove(i)
    return result


def findSym(map, skipRow=-1, skipCol=-1):
    possibleSym = [i for i in range(len(map[0]))]
    if skipRow in possibleSym:
        possibleSym.remove(skipRow)

    for rowIndex, row in enumerate(map):
        newPossible = getMirrorIndexes(row, possibleSym)
        possibleSym = keepMirrorIndex(possibleSym, newPossible)

    if (possibleSym != []):
        return possibleSym[0], possibleSym[0], -1

    map = np.transpose([list(col) for col in map])
    possibleSym = [i for i in range(len(map[0]))]
    if skipCol in possibleSym:
        possibleSym.remove(skipCol)

    for col in map:
        newPossible = getMirrorIndexes(col, possibleSym)
        possibleSym = keepMirrorIndex(possibleSym, newPossible)

    if (possibleSym != []):
        return 100 * possibleSym[0], -1, possibleSym[0]

    return -1, -1, -1


def flipped(map):
    result = []
    mapOg = map.copy()

    for rowIndex, row in enumerate(map):
        for colIndex, col in enumerate(row):
            if col == ".":
                changed = map[rowIndex][:colIndex] + \
                    '#' + map[rowIndex][colIndex + 1:]
                map[rowIndex] = changed
            elif col == "#":
                changed = map[rowIndex][:colIndex] + \
                    '.' + map[rowIndex][colIndex + 1:]
                map[rowIndex] = changed
            result.append(map)
            map = mapOg.copy()
    return result


part1 = 0
part2 = 0

for mapI, map in enumerate(maps):
    symForOgMap, r, c = findSym(map)
    part1 += symForOgMap

    allFlipped = flipped(map)

    flippedSym = 0
    for allFlippedMap in allFlipped:
        symForFlippedMap, _, _ = findSym(allFlippedMap, r,   c)

        if symForFlippedMap == -1:
            continue
        flippedSym = symForFlippedMap

    part2 += flippedSym


print("Part 1:", part1)
print("Part 2:", part2)
