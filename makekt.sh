#!/usr/bin/env bash
# Description: Sh script to work kotlin files
# it generates, compile kotlin files
# Date: 01082025
# Author: omitida

# helper funcition
function help() {
    echo "Usage: ${0} <-option> <file>"

    printf "Options Avaliable:\n\n"
    printf "c   - compiles and run a generic kotlin file\n"
    printf "g   - generate a generic kotlin standalone file\n"
}

# file extension remover
function remove_ext() {
   filename="${1}"
   extension="${filename%.*}"

   echo "${remove_ext}"
}

# check that the cli option is 2 namely;
# option and filename
if [[ "$#" -ne 2 ]]; then
    help
fi

opstring="c:g:h"
while getops "${opstring}" opt; do
    case "${opt}" in
        c)
        ;;
        g)
        ;;
        h)
        ;;
        *)
        ;;
    esac
done
