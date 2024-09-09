#!/usr/bin/env bash
day="$(printf "%02d" $2)"
command="cat ./test-data/$day-$1.txt | clojure -M -m day$day"
eval "$command"
