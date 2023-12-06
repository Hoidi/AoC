import re

with open('d5.txt') as f:
    lines = f.read()


def groups(name, lines):
    return [[int(f) for f in i.split(" ")] for i in re.search(
        ".*\n\n" + name + " map:\n((\d+[ |\n])+)", lines).group(1).removesuffix("\n").split("\n")]


seedPairs = [int(i) for i in re.match(
    "seeds:([ \d+]*)", lines).group(1).split(" ")[1:]]

print("staring")

seedSet = set()

seedToSoilGroups = groups("seed-to-soil", lines)
soilToFertGroups = groups("soil-to-fertilizer", lines)
fertToWaterGroups = groups("fertilizer-to-water", lines)
waterToLightGroups = groups("water-to-light", lines)
lightToTempGroups = groups("light-to-temperature", lines)
tempToHumidGroups = groups("temperature-to-humidity", lines)
humidToLocGroups = groups("humidity-to-location", lines)


def mapIt(group: [[int]]) -> {}:
    mapping = {}
    for oneMap in group:
        destinationStart = oneMap[0]
        sourceStart = oneMap[1]
        rangeNum = oneMap[2]

        # print(destinationStart, sourceStart, rangeNum)

        for i in range(rangeNum):
            mapping[sourceStart + i] = destinationStart + i

    return mapping


def useMapping(mapping: {}, source: []) -> []:
    destination = [0] * len(source)
    for index, seed in enumerate(source):
        if (seed in mapping.keys()):
            destination[index] = mapping[seed]
        else:
            destination[index] = seed

    return destination


def useSmartMapping(group: [[int]], source: []) -> []:
    destination = source
    for index, seed in enumerate(source):
        for oneMap in group:
            destinationStart = oneMap[0]
            sourceStart = oneMap[1]
            rangeNum = oneMap[2]

            diff = seed - sourceStart
            if (diff < rangeNum and diff >= 0):
                destination[index] = destinationStart + diff
                break

    return destination


result = []

for i in range(int(len(seedPairs)/2)):
    start = seedPairs[i*2]
    length = seedPairs[i*2 + 1]
    seeds = [start + diff for diff in range(length)]
    print("seeds done for", start)
    print("mapping", "(", start, ")")
    soil = useSmartMapping(seedToSoilGroups, seeds)
    print("soil", "(", start, ")")
    fert = useSmartMapping(soilToFertGroups, soil)
    print("fert", "(", start, ")")
    water = useSmartMapping(fertToWaterGroups, fert)
    print("water", "(", start, ")")
    light = useSmartMapping(waterToLightGroups, water)
    print("light", "(", start, ")")
    temp = useSmartMapping(lightToTempGroups, light)
    print("temp", "(", start, ")")
    humid = useSmartMapping(tempToHumidGroups, temp)
    print("humid", "(", start, ")")
    loc = useSmartMapping(humidToLocGroups, humid)
    print("loc", "(", start, ")")
    mini = min(loc)
    print("min:", mini, "(", start, ")")
    result.append(mini)

print("result:", result)
print("Part 2:", min(result))
# 1: 98758884
# 2: 91196450
# 3: 1897502919
# 4: 857586243
# 5: 32956608
# 6: 1756603980
# 7: 58556595
# 8:
# 9:
# 0:

# result: [98758884, 91196450, 1897502919, 857586243, 32956608, 1756603980, 58556595, 142045598, 214995753, 27992443]
