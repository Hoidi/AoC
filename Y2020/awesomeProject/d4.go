package main

import (
	"fmt"
	"strconv"
	"strings"
)

func D4() {
	a := OnPage("4","\n\n")

	/*
	a = []string{"pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f",
		"eyr:2029 ecl:blu cid:129 byr:1989\niyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
		"hcl:#888785\nhgt:164cm byr:2001 iyr:2015 cid:88\npid:545766238 ecl:hzl\neyr:2022",
		"iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"}

	a = []string{"eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
		"iyr:2019\nhcl:#602927 eyr:1967 hgt:170cm\necl:grn pid:012533040 byr:1946",
		"\nhcl:dab227 iyr:2012\necl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
		"hgt:59cm ecl:zzz\neyr:2038 hcl:74454a iyr:2023\npid:3556412378 byr:2007"}
	*/

	var s [][]string

	for _,val := range a {
		val = strings.ReplaceAll(val,"\n", " ")
		fmt.Println("person: ",val)
		println()
		s = append(s, strings.Split(val, " "))
	}
	
	valid := 0
	
	for _,val := range s {
		if isValid(val) {
			valid++
		}
	}
	
	println("Number of valid:",valid)


	return
}

func isValid(person []string) bool {
	passes := 0
	for _,val := range person {
		var attr []string
		attr = strings.Split(val, ":")

		if val == "cid:271"{
			return false
		}
		if attr[0] == "byr" {
			passes++
			byr, _ := strconv.Atoi(attr[1])
			if byr < 1920 || byr > 2002 {
				return false
			}
		}
		if attr[0] == "iyr" {
			passes++
			iyr, _ := strconv.Atoi(attr[1])
			if iyr < 2010 || iyr > 2020 {
				return false
			}
		}
		if attr[0] == "eyr" {
			passes++
			eyr, _ := strconv.Atoi(attr[1])
			if eyr < 2020 || eyr > 2030 {
				return false
			}
		}
		if attr[0] == "hgt" {
			if strings.HasSuffix(attr[1],"in") {
				hgt,_ := strconv.Atoi(strings.TrimRight(attr[1],"in"))
				if hgt < 59 || hgt > 76 {
					return false
				}
			} else if strings.HasSuffix(attr[1],"cm") {
				hgt,_ := strconv.Atoi(strings.TrimRight(attr[1],"cm"))
				if hgt < 150 || hgt > 193 {
					return false
				}
			} else {
				return false
			}
			passes++
		}
		if attr[0] == "hcl" {
			if attr[1][0] != '#' {
				return false
			}
			attr[1] = attr[1][1:] // remove first element
			if len(attr[1]) != 6 {
				return false
			}
			for _,val := range attr[1] {
				ewhoi := string(val)
				if !strings.Contains("0123456789abcdef", ewhoi) {
					return false
				}
			}
			passes++
		}
		if attr[0] == "ecl" {
			if (attr[1] == "amb") || (attr[1] == "blu") || (attr[1] == "brn") || (attr[1] == "gry") || (attr[1] == "grn") || (attr[1] == "hzl") || (attr[1] == "oth") {
				passes++
			} else {
				return false
			}
		}
		if attr[0] == "pid" {
			if len(attr[1]) != 9 {
				return false
			}
			if _, err := strconv.Atoi(attr[1]); err != nil {
				return false
			}
			passes++
		}
		if attr[0] == "cid" {
			//passes++
		}
	}
	return passes == 7
}

