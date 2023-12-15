with open('d14.txt') as f:
    input = f.readlines()

input = [row.removesuffix("\n") for row in input]


def printInput():
    for row in input:
        print(row)
    print()


def moveRockVertical(rockPos, mov):
    (x, y) = rockPos

    if (y+mov != -1 and y+mov != len(input) and input[y+mov][x] == "."):
        newFirstrow = input[y][:x] + '.' + input[y][x + 1:]
        input[y] = newFirstrow

    # make recursive?
    while y+mov != -1 and y+mov != len(input) and input[y+mov][x] == ".":
        y += mov

    newSecondRow = input[y][:x] + 'O' + input[y][x + 1:]
    input[y] = newSecondRow

    return (x, y)


def moveRockHorizontal(rockPos, mov):
    (x, y) = rockPos

    if x+mov != -1 and x+mov != len(input[y]) and input[y][x+mov] == ".":
        newFirstrow = input[y][:x] + '.' + input[y][x + 1:]
        input[y] = newFirstrow

    # make recursive?
    while x+mov != -1 and x+mov != len(input[y]) and input[y][x+mov] == ".":
        x += mov

    newSecondRow = input[y][:x] + 'O' + input[y][x + 1:]
    input[y] = newSecondRow

    return (x, y)


def calcLoad(rockPos) -> int:
    (_, y) = rockPos
    return len(input) - y


def part1() -> int:
    totalLoad = 0
    for y, row in enumerate(input):
        for x, col in enumerate(row):
            if (col == "O"):
                newPos = moveRockVertical((x, y), -1)
                # totalLoad += calcLoad(newPos)
    totalLoad = 0
    for y, row in enumerate(input):
        for x, col in enumerate(row):
            if (col == "O"):
                totalLoad += calcLoad((x, y))
    return totalLoad

# are there any cycles?


cycles = set()


def part2() -> int:
    for cycle in range(1000000000):
        if (cycle % 101 == 0 and cycle != 0):
            print("Cycle", cycle)
            exit()
        for y, row in enumerate(input):
            for x, col in enumerate(row):
                if (col == "O"):
                    moveRockVertical((x, y), -1)

        # printInput()
        for y, row in enumerate(input):
            for x, col in enumerate(row):
                if (col == "O"):
                    moveRockHorizontal((x, y), -1)

        # printInput()
        for y, row in reversed(list(enumerate(input))):
            for x, col in enumerate(row):
                if (col == "O"):
                    moveRockVertical((x, y), 1)

        # printInput()
        for y, row in enumerate(input):
            for x, col in reversed(list(enumerate(row))):
                if (col == "O"):
                    moveRockHorizontal((x, y), 1)

        string = "".join(input)
        print(string)
        if (string in cycles):
            print("cycle at", cycle)
        cycles.add(string)
        # printInput()

    totalLoad = 0
    for y, row in enumerate(input):
        for x, col in enumerate(row):
            if (col == "O"):
                totalLoad += calcLoad((x, y))
    return totalLoad


print("Part 1:", part1())
print("Part 2:", part2())
