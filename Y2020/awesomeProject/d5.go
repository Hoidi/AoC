package main

import (
	"fmt"
	"strings"
	"time"
)

func D5() {
	a := OnPage("5","\n")


	//a = []string{"FBFBBFFRLR","BFFFBBFRRR","FFFBBBFRRR","BBFFBBFRLL"}

	var s [][]string

	for _,val := range a {
		s = append(s, strings.Split(val, ""))
	}

	start := time.Now()

	var taken [128][8]string

	for i,_ := range taken {
		for j,_ := range taken[0]{
			taken[i][j] = "empty"
		}
	}

	maxId := 0

	for _,val := range s {
		id := id(val)
		idNum := id[0] * 8 + id[1]
		taken[id[0]][id[1]] = "taken"
		if idNum > maxId {
			maxId = idNum
		}
	}

	println("Max id:",maxId)


	for i,_ := range taken {
		for j,_ := range taken[0]{
			if i <= 11 || i >= 115 {
				continue
			}
			if taken[i][j] == "empty" {
				println("Empty seat at",i,j) // prints all empty seats, just look manually for the right one
				println("Id is",i*8+j)
			}
		}
	}


	elapsed := time.Since(start)
	fmt.Println("Part 2 took",elapsed)

	return
}

func id(s []string) []int  {
	rowFrom := 0
	rowTo := 127
	rowDiff := 128

	colLeft := 0
	colRight := 7
	colDiff := 8


	for _,val := range s {
		rowDiff = int(rowDiff /2)
		if val == "F" {
			rowTo -= rowDiff
		}
		if val == "B" {
			rowFrom += rowDiff
		}
		if val == "R" {
			colDiff = int(colDiff /2)
			colLeft += colDiff
		}
		if val == "L" {
			colDiff = int(colDiff /2)
			colRight -= colDiff
		}
	}

	if rowFrom != rowFrom {
		println("Not same row")
	}

	if colLeft != colRight {
		println("Not same col")
	}

	var result []int
	result = append(result, rowFrom)
	result = append(result, colLeft)

	return result
}
