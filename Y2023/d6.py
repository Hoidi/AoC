import re

with open('d6.txt') as f:
    lines = f.readlines()

times = list(map(lambda x: int(x), filter(lambda x: x != "", re.search(
    "Time:([ +\d+]*)", lines[0]).group(1).split(" "))))

distances = list(map(lambda x: int(x), filter(lambda x: x != "", re.search(
    "Distance:([ +\d+]*)", lines[1]).group(1).split(" "))))

oneRaceTime = int(re.search(
    "Time:([ +\d+]*)", lines[0]).group(1).replace(" ", ""))

oneRaceDistance = int(re.search(
    "Distance:([ +\d+]*)", lines[1]).group(1).replace(" ", ""))

part1 = 1

for race in range(len(times)):
    time = times[race]
    record = distances[race]
    timesBeatenRecord = 0

    for milli in range(time):
        speed = milli
        timeLeft = time - milli
        distanceTraveled = speed * timeLeft

        if (distanceTraveled > record):
            timesBeatenRecord += 1

    print("Times beaten:", timesBeatenRecord)
    part1 *= timesBeatenRecord


timesBeatenBigRecord = 0
for milli in range(oneRaceTime):
    speed = milli
    timeLeft = oneRaceTime - milli
    distanceTraveled = speed * timeLeft

    if (distanceTraveled > oneRaceDistance):
        timesBeatenBigRecord += 1

print("Part 1:", part1)
print("Part 2:", timesBeatenBigRecord)
