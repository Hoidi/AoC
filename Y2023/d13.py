import re
import numpy as np

with open('d13.txt') as f:
    input = f.read()

maps = [map.split("\n") for map in input.split("\n\n")]


def printInput(input):
    for row in input:
        print(row)
    print()


def getMirrorIndexes(row: str):
    sym = []
    for step in range(len(row)):

        left = row[:step]
        right = row[step:]
        # print("l:", left, "r:", right)

        maxLen = min(len(left), len(right))

        for i in range(maxLen):
            # print(left[-(i+1)], right[i], i)
            if (left[-(i+1)] != right[i]):
                break

            if i == maxLen-1:
                # print("match", "l:", left, "r:", right)
                sym.append(step)
    # print(sym)
    return sym


def keepMirrorIndex(possibleSym: [], newPossible: []) -> []:
    # print("start ------------------")
    # print(possibleSym, newPossible)
    if (possibleSym == [-1]):
        # print("init")
        return newPossible

    result = list(newPossible)
    for i in newPossible:
        if i not in possibleSym:
            # print(i, "not in", possibleSym, newPossible, "=>", result)
            result.remove(i)
            # print(i, "not in", possibleSym, newPossible, "=>", result)

    # print(result)
    # print("end ------------------")
    return result


# print(keepMirrorIndex([7], [3, 7]))

# exit()

part1 = 0
for i, map in enumerate(maps):
    # if (i != 1):
    #    continue

    possibleSym = [-1]
    for rowIndex, row in enumerate(map):
        newPossible = getMirrorIndexes(row)
        possibleSym = keepMirrorIndex(possibleSym, newPossible)
        # print(possibleSym)

    # exit()

    if (possibleSym != [-1] and possibleSym != []):
        # print("norm", possibleSym)
        part1 += possibleSym[0]
        continue

    possibleSym = [-1]
    map = np.transpose([list(col) for col in map])
    # printInput(map)
    # print(map)
    for col in map:
        newPossible = getMirrorIndexes(col)
        possibleSym = keepMirrorIndex(possibleSym, newPossible)

    if (possibleSym != [-1] and possibleSym != []):
        # print("trans", possibleSym)
        part1 += 100 * possibleSym[0]

print("Part 1:", part1)
