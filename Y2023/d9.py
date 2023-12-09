import re

with open('d9.txt') as f:
    lines = f.readlines()


def createLists():
    all = []

    for line in lines:
        numbers = []
        numbers.append([int(x) for x in re.findall("-?\d+", line)])
        index = 0

        while numbers[index].count(0) != len(numbers[index]):
            current = numbers[index]
            next = []
            for i in range(len(current)-1):
                diff = current[i+1] - current[i]
                next.append(diff)

            numbers.append(next)
            index += 1

        all.append(numbers)
    return all


def predictOne(diffs):
    for index in reversed(range(len(diffs)-1)):
        predictedValue = diffs[index][-1] + diffs[index+1][-1]
        diffs[index].append(predictedValue)

        predictedValue = diffs[index][0] - diffs[index+1][0]
        diffs[index].insert(0, predictedValue)

    return diffs


def predictAll(all):
    sumPart1 = 0
    sumPart2 = 0
    for one in all:
        predictions = predictOne(one)
        lastPredicted = predictions[0][-1]
        firstPredicted = predictions[0][0]
        sumPart1 += lastPredicted
        sumPart2 += firstPredicted
    return sumPart1, sumPart2


all = createLists()

sumPart1, sumPart2 = predictAll(all)
print("Part 1:", sumPart1)
print("Part 2:", sumPart2)
