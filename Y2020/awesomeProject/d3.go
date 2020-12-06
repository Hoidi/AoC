package main

import (
	"fmt"
	"strings"
	"time"
)

func D3() {
	a := OnPage("3","\n")

	/*a = []string{"..##.......",
		 "#...#...#..",
		 ".#....#..#.",
		 ".A#.#...#.#",
		 ".#...##..#.",
		 "..#.##.....",
		 ".#.#.#....#",
		 ".#........#",
		 "#.##...#...",
		 "#...##....#",
		 ".#..#...#.#"}*/

	var s [][]string

	for _,val := range a {
		s = append(s, strings.Split(val, ""))
	}

	start := time.Now()


	l := slope(s,1,1)
	m := slope(s,3,1)
	n := slope(s,5,1)
	o := slope(s,7,1)
	p :=  slope(s,1,2)

	println(l,m,n,o,p)

	println("mul:",l*m*n*o*p)

	elapsed := time.Since(start)
	fmt.Println("Part 2 took",elapsed)

	return
}

func slope(s [][]string, r int, d int) (int){
	trees := 0

	for i := r; i < len(s[0]); {
		for j := d; j < len(s); j = j + d {
			plot := s[j][i]
			if plot == "#" {
				trees++
			}
			i = i + r
			i = i % len(s[0])
			if j >= len(s)-1 {
				return trees
			}
		}
	}
	return 9999999
}
