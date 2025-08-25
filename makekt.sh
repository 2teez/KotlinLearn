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
    printf "q   - compile, run and then delete the standalone kotline file.\n"
}

# file creation
function create_default_file() {
    filename="${1^}"
    # kt_file_type="${2}"  # might use late to include script

    # modify and use package name
    package_name="${filename%.*}"
    package_name="com.prac.${package_name,,}"
    echo "
package ${package_name}
fun main() {
    println(\"Hello, World!\")
}
    " > "${filename}"
}

# generic function to do some action on file
function action_on_file() {
    func="${1}"; shift
    filename="${1}"; shift
    messages=("$@")
    if [[ -e "${filename}" ]]; then
        while read -p "${messages[0]}" ans; do
            case "${ans,,}" in
                y)
                "${func}" "${filename}" # create the file
                echo "${messages[1]}"
                exit 0
                ;;
                n)
                   echo "${messages[2]}"
                   exit 1
                ;;
                *)
                echo "${messages[3]}"
                ;;
            esac
        done
    fi
}


# file extension remover
function remove_ext() {
   filename="${1}"
   extension="${filename%.*}"

   echo "${remove_ext}"
}

function delete_file() {
    filename="${1}";

    rm -f "${filename}"
}

# check that the cli option is 2 namely;
# option and filename
if [[ "$#" -ne 2 ]]; then
    help
fi

opstring="c:d:g:q:h"
while getopts "${opstring}" opt; do
    case "${opt}" in
        c)
        # compile and run kotlin standalone file
        filename="${OPTARG^}"
        file_name="${filename%.*}"

        # modify and use package name
        #package_name="${filename%.*}"
        package_name="com.prac.${file_name,,}"

        # kotlin command to compile and run
        kotlinc-jvm "${filename}" -d "${file_name}.jar"
        kotlin -classpath "${file_name}.jar" "${package_name}.${file_name}Kt"
        ;;
        d)
        # delete specified file
        filename="${OPTARG^}"

        # delete file messages
        messages=(
            "${filename} exist. Do you want to Delete it? "
            "${filename} Deleted."
            "${filename} not deleted."
            "You can only use y for YES and n for NO."
        )

        action_on_file delete_file "${filename}" "${messages[@]}"
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
        messages=(
            "${filename} exist. Do you want to overwrite it? "
            "${filename} Overwritten."
            "${filename} not overwritten."
            "You can only use y for YES and n for NO."
        )
        action_on_file create_default_file "${filename}" "${messages[@]}"
        # create the file
        create_default_file "${filename}"
        ;;
        q)
            filename="${OPTARG}"
            file_without_sion="${filename%.*}"
            kotlinc "${filename}" &&
            kotlin "com/prac/${file_without_sion,,}/${file_without_sion}Kt.class" &&
            rm -rf "com/prac/${file_without_sion,,}"
            rm -rf META-INF/
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
