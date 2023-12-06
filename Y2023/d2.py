import re

with open('d2.txt') as f:
    lines = f.readlines()

availableRed = 12
availableGreen = 13
availableBlue = 14

sum = 0
powerSum = 0

for line in lines:
    maxRed = 0
    maxGreen = 0
    maxBlue = 0

    round = re.match("Game (\d+)(:)(.*)", line)
    gameId = int(round.group(1))
    rounds = round.group(3).split(";")

    for draw in rounds:
        red = re.match(".* (\d+) red", draw)
        green = re.match(".* (\d+) green", draw)
        blue = re.match(".* (\d+) blue", draw)

        red = int(red.group(1)) if red else 0
        green = int(green.group(1)) if green else 0
        blue = int(blue.group(1)) if blue else 0

        maxRed = max(red, maxRed)
        maxGreen = max(green, maxGreen)
        maxBlue = max(blue, maxBlue)

    power = maxRed * maxGreen * maxBlue
    powerSum += power

    if (maxRed <= availableRed and maxGreen <= availableGreen and maxBlue <= availableBlue):
        sum += gameId

print("Part 1:", sum)
print("Part 2:", powerSum)
