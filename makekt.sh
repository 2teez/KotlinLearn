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
    printf "d   - delete a standalone kotlin file\n"
}

# file creation
function create_default_file() {
    filename="${1^}"
    # kt_file_type="${2}"  # might use late to include script

    echo "
    fun main(args: Array<String>) {
        println("Hello, World!")
    }
    " > "${filename}"
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

opstring="c:d:g:h"
while getopts "${opstring}" opt; do
    case "${opt}" in
        c)
        # compile and run kotlin standalone file
        filename="${OPTARG^}"
        ;;
        d)
        filename="${OPTARG^}"
        ;;
        g)
        # generate a generic file
        # even if the file does have an extension
        filename="${OPTARG^}"
        file_extension="${filename#*.}" # get file extension
        file_name="${filename%.*}" # get filename without the extention

        # check if file doesn't have an extension, append either kt #or kts
        [[ "${file_extension}" == "${file_name}" ]] && filename="${filename}.kt"


        # check if the file exist and if you want to overwrite it
        if [[ -e "${filename}" ]]; then
            #echo "${filename} exist. Do you want to overwrite it?"
            while read -p "${filename} exist. Do you want to overwrite it? " ans; do
                case "${ans,,}" in
                    y)
                    create_default_file "${filename}" # create the file
                    echo "${filename} Overwritten."
                    exit 0
                    ;;
                    n)
                       echo "${filename} not overwritten."
                       break
                    ;;
                    *)
                    echo "You can only use y for YES and n for NO."
                    ;;
                esac
            done
        fi
        # create the file
        create_default_file "${filename}"
        ;;
        h)
          help # help function
          exit 1
        ;;
        *)
         echo "Invalid Option."
         exit 1
        ;;
    esac
done
