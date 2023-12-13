import re
from itertools import product

with open('d12.txt') as f:
    lines = f.readlines()


def isValid(springs: str, seq: []):
    if springs.count("#") != sum(seq):
        return False

    # remove starting "."
    while len(springs) >= 1 and springs[0] == ".":
        springs = springs[1:]

    for nrBroke in seq:
        broke = re.search(r"#{" + str(nrBroke) + r"}\.+", springs)

        if (not broke or broke.start() != 0):
            return False

        springs = springs[broke.end():]

    if (springs != ""):
        return False

    return True


def fixUnknown(line):
    unknownPositions = [pos for pos, char in enumerate(line) if char == '?']
    combinations = product("#.", repeat=line.count("?"))

    # Replace each '?' with a combination of '#' and '.' in the input string
    result_strings = []
    for combination in combinations:
        result = list(line)
        for pos, char in zip(unknownPositions, combination):
            result[pos] = char
        result_strings.append(''.join(result))

    print("Size:", len(result_strings))
    return result_strings


p1totalValid = 0
p2totalValid = 0
for line in lines:
    seq = [int(i) for i in re.findall("\d+", line)]
    springs = str(line.split(" ")[0])

    part2Seq = seq*5
    part2Springs = "." + springs + "?" + springs + "?" + \
        springs + "?" + springs + "?" + springs + "."

    springs = "." + springs + "."

    p1nrValid = 0
    for combination in fixUnknown(springs):
        p1nrValid += 1 if isValid(combination, seq) else 0
    p1totalValid += p1nrValid

    print("s2", part2Springs)
    print("q2", part2Seq)
    p2nrValid = 0
    for combination in fixUnknown(part2Springs):
        p2nrValid += 1 if isValid(combination, part2Seq) else 0
    p2totalValid += p2nrValid

print("Part 1:", p1totalValid)
print("Part 2:", p1totalValid)


# part 2:
# we can figure out one part, but then there's ? in beteen
