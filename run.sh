#!/bin/bash

# from https://github.com/realpacific/algorithms/blob/master/run.sh
isKotlinMainClass() {
  echo "$(
    grep -q "fun main()" "$1"
    echo $?
  )"
}

removeExtension() {
  echo "$(echo "$1" | cut -f 1 -d '.')"
}

YELLOW=$(tput setaf 3)
CYAN=$(tput setaf 6)
WHITE=$(tput sgr0)

for i in $(git ls-files | grep .kt); do
  filename=$(removeExtension "$i")
  isMainClass=$(isKotlinMainClass "$i")

  if [[ "$isMainClass" == "0" ]]; then
    kotlinFileName="$filename"
    kotlinFileName="org.cmolisee.${kotlinFileName#src/}Kt"
    echo "$CYAN >>>>> Executing file $kotlinFileName $WHITE"
    ./gradlew -PmainClass="$kotlinFileName" execute -q -Dorg.gradle.console=plain --warning-mode=summary
  else
    echo "$YELLOW >>>>> Skipping $i $WHITE"
  fi
done