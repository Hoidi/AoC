import re
import math

with open('d8.txt') as f:
    lines = f.readlines()

instructions = list(lines[0])[:-1]

lines = lines[2:]
paths = {}
startPositions = []

for line in lines:
    [origin, left, right] = re.findall(r"[A-Z\d][A-Z\d][A-Z\d]", line)

    if (origin.endswith("A")):
        startPositions.append(origin)
    paths[origin] = (left, right)

print("Paths created")


def end(node):
    return node.endswith("Z")


def whole(node):
    return node == "ZZZ"


def findSteps(startNode, goal):
    instructionIndex = 0
    while not goal(startNode):
        instruction = instructions[instructionIndex % len(instructions)]
        instructionIndex += 1
        (left, right) = paths[startNode]

        startNode = left if instruction == "L" else right
    return instructionIndex


print("Part 1:", findSteps("AAA", whole))

steps = [findSteps(node, end) for node in startPositions]
print(steps)
print("Part 2:", math.lcm(*steps))
