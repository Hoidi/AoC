import itertools

with open('d11.txt') as f:
    lines = f.readlines()

lines = [line.removesuffix("\n") for line in lines]

expandedRows = []
for row, line in enumerate(lines):
    if all(c == "." for c in line):
        expandedRows.append(row)

expandedCols = []
for col in range(len(lines[0])):
    if all(line[col] == "." for line in lines):
        expandedCols.append(col)

galaxies = []
for y, row in enumerate(lines):
    for x, char in enumerate(row):
        if char != ".":
            galaxies.append((x, y))

galaxyPairs = list(itertools.combinations(galaxies, 2))


def spaceBetween(first, second, expansion):
    (x1, y1) = first
    (x2, y2) = second
    xSteps = abs(x1-x2)
    ySteps = abs(y1-y2)

    for x in range(min(x1, x2) + 1, max(x1, x2) + 1):
        if x in expandedCols:
            xSteps += expansion

    for y in range(min(y1, y2)+1, max(y1, y2)+1):
        if y in expandedRows:
            ySteps += expansion

    return xSteps + ySteps


part1 = 0
part2 = 0

for ((x1, y1), (x2, y2)) in galaxyPairs:
    part1 += spaceBetween((x1, y1), (x2, y2), 1)
    part2 += spaceBetween((x1, y1), (x2, y2), 999999)

print("Part 1:", part1)
print("Part 1:", part2)
